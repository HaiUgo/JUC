package com.yhy.test.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {

	public TestExecutorService() {
	}
	
	public static void main(String []args){
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    fixedThreadPool.execute(new Runnable() {
		        @Override
		        public void run() {
		            try {
		                System.out.println(Thread.currentThread().getName()+" "+index);
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    });
		}
		fixedThreadPool.shutdown();
		System.out.println(Thread.currentThread().getName());
		
		
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//		    final int index = i;
//		    try {
//		        Thread.sleep(index * 1000);
//		    } catch (InterruptedException e) {
//		        e.printStackTrace();
//		    }
//
//		    cachedThreadPool.execute(new Runnable() {
//
//		        @Override
//		        public void run() {
//		            System.out.println(index);
//		        }
//		    });
//		}
//		
//		System.out.println("----------------------------------------------------");

	}
}
