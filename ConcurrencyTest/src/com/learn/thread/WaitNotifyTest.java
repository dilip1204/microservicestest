package com.learn.thread;


class Processor{
	
	
	public void produce()throws InterruptedException{
		
		synchronized (this) {
			System.out.println("we are in the producer method");
			wait();
			System.out.println("again same producer method");
		}
	}
	
	public void consume()throws InterruptedException {
		Thread.sleep(1000);
		

		synchronized (this) {
			System.out.println("we are in the consumer method");
			notify();
			//System.out.println("again same consumer method");
		}
		
	}
}
public class WaitNotifyTest {
	
	public static void main(String[] args) {
		
		Processor p = new Processor();
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					p.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	t1.start();
	t2.start();
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}
