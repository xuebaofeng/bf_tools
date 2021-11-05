package com.xue.test;

/**
 * @author Baofeng Xue at 2015/11/3 19:43.
 */
public class DeadLock {
	public static void main(String[] args){
		new Thread() {
			public void run(){
				synchronized(Integer.class){
					System.out.println("Thread 1: locked Integer");
					try{
						Thread.sleep(50);
					}catch(InterruptedException e){
					}

					synchronized(String.class){
						System.out.println("Thread 1: locked String");
					}
				}
			}
		}.start();

		new Thread() {
			public void run(){
				synchronized(String.class){
					System.out.println("Thread 2: locked String");
					try{
						Thread.sleep(50);
					}catch(InterruptedException e){
					}
					synchronized(Integer.class){
						System.out.println("Thread 2: locked Integer");
					}
				}
			}
		}.start();

	}
}
