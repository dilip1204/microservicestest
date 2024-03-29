package com.learn.thread;

class Worker implements Runnable{
	
	private volatile boolean isTerminated = false;
	

	@Override
	public void run() {
	
		while(!isTerminated) {
			System.out.println("hello from worker class");
			
			try {
				Thread.sleep(300);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public boolean isTerminated() {
		return isTerminated;
	}


	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
	
	
}

public class AppVolatile {
	
	public static void main(String[] args) {
		Worker ww = new Worker();
		Thread tw1= new Thread(ww);
		tw1.start();
		
		
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	
	ww.setTerminated(true);
	System.out.println("finished executing  ");
	
	}
	


}
