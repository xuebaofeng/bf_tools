package com.xue.test;

/**
 * @author Baofeng Xue at 2015/11/3 19:43.
 */
public class ShutdownHook {


	public static void main(String a[]){
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run(){
				System.out.println("in shutdown hook");
				try{
					Thread.sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("end of shutdown hook");
			}
		});

		System.out.println("main over");
	}
}
