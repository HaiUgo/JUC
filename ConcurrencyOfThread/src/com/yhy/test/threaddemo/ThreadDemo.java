package com.yhy.test.threaddemo;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

	public ThreadDemo() {
		// TODO Auto-generated constructor stub
	}
	
	private static class MyThread extends Thread{

		@Override
		public void run() {
			for(int i=1;i<=10;i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("MyThread i="+i);
			}
		}
		
	}
	
	private static class MyRun implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=1;i<=10;i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("MyRun :i="+i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MyThread().start();
		
		new Thread(new MyRun()).start();
		
		new Thread(()->{
			for(int i=1;i<=10;i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Thread:i="+i);
				}
			}
		).start() ;
		
		for(int i=1;i<=10;i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("MyMain:i="+i);
		}
	}
		
}
