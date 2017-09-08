/**
 * 
 */
package edu.mandeep.practice.multithreading;

/**
 * Multithreading is a Java feature that allows concurrent execution of two or more parts of a program 
 * for maximum utilization of CPU. Each part of such program is called a thread. 
 * 
 * Method 1: Extending Thread Class -->  it provides some inbuilt methods like yield(), interrupt() etc. 
 * that are not available in Runnable interface.
 * Method 2: Implementing Runnable Interface --> beneficial if we want to extend some other base class
 * @author mandeep
 */

class Multithreading extends Thread{
	public void run(){
		try{
			System.out.println("thread with id "+Thread.currentThread().getId()+" is running "+Thread.currentThread().getName());
			
		}catch(Exception e){
			System.out.println("Exception is caught");
		}
	}
}

class MultithreadingRunnable implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try{
			System.out.println("thread with id "+Thread.currentThread().getId()+" is running "+Thread.currentThread().getName());
			
		}catch(Exception e){
			System.out.println("Exception is caught");
		}
	}
}
public class MultithreadCreation{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberofThreads = 10;
		for(int i = 0; i < numberofThreads; i++){
			//Multithreading thread = new Multithreading();
			Thread thread = new Thread(new MultithreadingRunnable());
			thread.start();
		}
	}
}