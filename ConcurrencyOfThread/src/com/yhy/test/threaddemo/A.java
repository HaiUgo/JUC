package com.yhy.test.threaddemo;

import java.util.concurrent.TimeUnit;

/**
* 面试题：模拟银行账户
* 对业务写方法加锁
* 对业务读方法不加锁
* 这样行不行？
*
* 容易产生脏读问题（dirtyRead）
*/

public class A {
	String name;
	double  balance;

	public synchronized void set(String name, double balance) {
		System.out.println(Thread.currentThread().getName()+"-----1");
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-----2");
		this.balance = balance;
		System.out.println(Thread.currentThread().getName()+"-----3");
	}

	public /*synchronized*/  double getBalance(String name) {
		return this.balance;
	}

	public static void main(String[] args) {
		A a = new A();
		new Thread(() -> a.set("zhangsan", 100.0)).start();
		System.out.println(Thread.currentThread().getName()+"-----4");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   
		System.out.println(Thread.currentThread().getName()+" "+a.getBalance("zhangsan"));

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName()+" "+a.getBalance("zhangsan"));
	}
}
