package com.learn.thread;

class Runner11 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Thread Runner 1 "+i);
			
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


class Runner21 extends Thread{
	

	@Override
	public void run() {
		for(int i=0;i<10;i++) { System.out.println("Thread Runner 2 "+i);
			
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
}
}

public class ThreadMethod2 {
	
	

	public static void main(String[] args) {
		
		//Thread t1 = new Thread(new Runner1());
		//Thread t2 = new Thread(new Runner2());
		
		Runner11 t1 = new Runner11();
		Runner21 t2 = new Runner21();
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished threading");
	}

}


