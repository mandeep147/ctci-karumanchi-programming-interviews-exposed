package edu.mandeep.karumanchi;

class Node {
	Node next;
	int data;

	public Node(){
		next = null;
		data = 0;
	}

	public Node(int data){
		this.data = data;
		next = null;
	}

	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

class LinkedList {

	private Node head;
	private int data;
	private int length = 0;
	
	public LinkedList(){
		head = null;
		data = 0;
	}

	public LinkedList(Node head, int data){
		this.head = head;		
		this.data = data;
	}

	public void insertAtBegin(int data){
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;	
		length++;
		System.out.println("begin, data: " +data+"length: " +length);
	}

	public void insertAtEnd(int data){
		Node newNode = new Node(data);
		if(head == null)
			head = newNode;
		else{
			Node temp = null;

			for(temp = head; temp.getNext() != null; temp = temp.getNext());

			temp.setNext(newNode);
			newNode.setNext(null);
		}
		length++;
		
		System.out.println("end, data: " +data+"length: " +length);
		
	}

	public void insertAtPosition(int data, int pos){

		if( pos < 0)
			pos = 0;
		
		if( pos > length)
			pos = length;

		if( head == null)
			head = new Node(data);

		else if( pos == 0){
			insertAtBegin(data);
			return;
		}
		
		else {
			Node temp = head;
			for(int i = 1; i < pos - 1; i++){
				temp = temp.getNext();
			}
			Node newNode = new Node(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
		
		System.out.println("postion: "+ pos+ ", data: " +data+"length: " +length);
	}
	
	public void deleteAtStart(){
		if( head != null)
			head = head.getNext();
		length--;
	}
	
	public void deleteAtEnd(){
		Node temp = head;
		Node newNode = temp.getNext();
		
		while( newNode.getNext() !=  null){
			temp = temp.getNext();
			newNode = newNode.getNext();
		}
		
		temp.next = null;
		length--;
	}
	
	public void deleteAtPosition(int pos){
		
		if( pos < 0)
			pos = 0;
		
		if( pos > length)
			pos = length;
		
		if( head == null)
			return;
		
		if( pos == 0){
			deleteAtStart();
			return;
		}
		
		else{
			Node temp = head;
			
			for(int i = 1; i < pos - 1 ; i++){
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			length--;
		}
		
	}

	//Prints list data
	public void printList() {
		Node currentNode = head;
		System.out.print("List: ");

		System.out.print(head.getData()+ " -> ");
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			System.out.print(currentNode.getData()+" -> ");

		}
		System.out.println("");
	}

}

public class SinglyLinkedList{
	public static void main(String args[]){
		LinkedList l = new LinkedList();

		l.insertAtEnd(10);
		l.insertAtBegin(5);
		l.insertAtEnd(7);
		l.insertAtBegin(3);
		l.insertAtEnd(15);
		l.insertAtPosition(6, 2);
		l.insertAtPosition(2, -1);
		l.insertAtPosition(9, 7);
		l.deleteAtStart();
	///	l.deleteAtStart();
		l.deleteAtEnd();
	//	l.deleteAtEnd();
		l.printList();
		l.deleteAtPosition(3);
		l.printList();

	}
}
