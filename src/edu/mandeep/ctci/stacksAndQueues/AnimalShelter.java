/**
 * Problem 3.6: Animal Shelter
 * An animal shelter holds only cats and dogs, operates on FIFO basis. People must adopt either the "oldest" of all animals, or
 * they can select whether they would prefer a dog or a cat(and receive oldest of that type of animal). They can;t select which specific
 * animal they would like. 
 * Create DS to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, dequeueCat. 
 * 
 */
package edu.mandeep.ctci.stacksAndQueues;

import java.util.LinkedList;

/**
 * @author mandeep
 *
 */
public class AnimalShelter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnimalQueue a = new AnimalQueue();		
		a.enqueue(new Dog("Anthar"));
		a.enqueue(new Dog("Cobo"));		
		a.enqueue(new Dog("Simon"));				
		a.enqueue(new Cat("Cochino"));			
		
		Animal an = (Animal) a.dequeueAny();
		System.out.println(an.name);		
		
		an = (Animal) a.dequeueCat();
		System.out.println(an.name);	
		
		an = (Animal) a.dequeueDog();
		System.out.println(an.name);	
	}
}

class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	/**
	 * @param dog
	 */
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog)
			dogs.addLast((Dog) a);
		else if(a instanceof Cat)
			cats.addLast((Cat) a);
	}

	/**
	 * @return
	 */
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public Dog dequeueDog(){
		return dogs.poll();
	}

	/**
	 * @return
	 */
	public Animal dequeueAny() {
		if(dogs.size() == 0)
			return dequeueCat();
		else if(cats.size() == 0)
			return dequeueDog();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOlderThan(cat))
			return dequeueDog();
		else 
			return dequeueCat();
	}
	
}

abstract class Animal{
	private int order;
	protected String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public int getOrder(){
		return order;
	}
	
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}