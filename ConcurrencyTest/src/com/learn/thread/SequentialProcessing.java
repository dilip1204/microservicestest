package com.learn.thread;

class Runner1 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Thread Runner 1 "+i);
		}
	}
	
}


class Runner2 implements Runnable{
	

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Thread Runner 2 "+i);
		}
	}
	
}

public class SequentialProcessing {
	
	

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		
		
		t1.start();
		t2.start();
	}

}
