package com.learn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processor12{
	
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	
	public void produce()throws InterruptedException{
		
		lock.lock();
		System.out.println("produced method");
		condition.await();
		System.out.println("producer method again");
		lock.unlock();
		
	}
	
	public void consume()throws InterruptedException {
		
		lock.lock();
		Thread.sleep(1000);
		System.out.println("consumer method");
		condition.signal();
		lock.unlock();
		System.out.println("consumer	 method again");
		
	}
}
public class ProducerConsumerWithLock {
	
	public static void main(String[] args) {
		
		Processor12 p = new Processor12();
		
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
