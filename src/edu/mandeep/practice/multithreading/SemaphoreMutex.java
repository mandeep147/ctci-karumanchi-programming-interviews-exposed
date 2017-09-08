/**
 * 
 */
package edu.mandeep.practice.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Implement semaphores and mutex
 * 
 * Mutex is Semaphore with count = 1 rest implementation is same
 * @author mandeep
 */
public class SemaphoreMutex {
	static Semaphore semaphore = new Semaphore(4);
	
	static class ATMThread extends Thread{
		String name = "";
		
		public ATMThread(String name){
			this.name = name;
		}
		
		public void run(){
			try{
				System.out.println(name + " : acquiring lock...");
				System.out.println(name + " : available Semaphore permits now: "
								+ semaphore.availablePermits());
				semaphore.acquire();
				System.out.println(name + " : acquired lock");
				try {
					for (int i = 1; i <= 5; i++) {
						System.out.println(name + " : is performing operation " + i
								+ ", available Semaphore permits : "
								+ semaphore.availablePermits());
						// sleep 1 second
						Thread.sleep(1000);
					}
				} finally {
					// calling release() after a successful acquire()
					System.out.println(name + " : releasing lock...");
					semaphore.release();
					System.out.println(name + " : available Semaphore permits now: "
								+ semaphore.availablePermits());
				}
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Total available Semaphore permits : "
				+ semaphore.availablePermits());

		ATMThread t1 = new ATMThread("A");
		t1.start();

		ATMThread t2 = new ATMThread("B");
		t2.start();

		ATMThread t3 = new ATMThread("C");
		t3.start();

		ATMThread t4 = new ATMThread("D");
		t4.start();

		ATMThread t5 = new ATMThread("E");
		t5.start();

		ATMThread t6 = new ATMThread("F");
		t6.start();
	}
}