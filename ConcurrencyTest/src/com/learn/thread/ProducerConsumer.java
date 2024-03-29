package com.learn.thread;

import java.util.ArrayList;

class Processor1{
	
	
	private ArrayList<Integer> list = new ArrayList();
	private final int LIMIT=5;
	private final int BOTTOM=0;
	private Object lock = new Object();
	private int value=0;
	
	public void produce()throws InterruptedException{
		
		synchronized (lock) {
			while(true) {
				if(list.size() == LIMIT ) {
					System.out.println("waiting for removing items from the list ");
					lock.wait();
				}else {
					System.out.println("Adding "+value);
					list.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
			
		}
		
	}
	
	public void consume()throws InterruptedException {
		
		synchronized (lock) {
			while(true) {
				if(list.size() == BOTTOM ) {
					System.out.println("waiting for adding items from the list ");
					lock.wait();
				}else {
					System.out.println("Removed: "+list.remove(--value));
					lock.notify();
				}
				
				Thread.sleep(500);
			}
			
		}
		
	}
}
public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		Processor1 p = new Processor1	();
		
		
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
