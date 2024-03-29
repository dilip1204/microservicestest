package com.learn.thread;

public class SynchBlock {
	
	public static int counter1 =0;
	public static int counter2=0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	
	public static void add() {
		synchronized (lock1) {
			counter1++;
		}
		
	}
	
	public static void add1() {
		synchronized (lock2) {
			counter2++;
		}
		
	}
	
	public static void compute() {
		for(int i=0;i<100;i++) {
			add();
			add1();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				compute();
			}
		});
		
	Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				compute();
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
	
	
System.out.println("counter value  1 = "+counter1);
System.out.println("counter value  2 = "+counter2);		
	}
}
