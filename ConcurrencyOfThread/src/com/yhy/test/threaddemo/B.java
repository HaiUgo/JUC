package com.yhy.test.threaddemo;

public class B {

	private int a;
	
	public B() {
	}


	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public void sub() {
		this.a = this.a - 1;
	}

	public void add() {
		this.a = this.a +1;
	}
	
	public static void main(String[] args) {
		B b1 = new B();
		B b2 = new B();
		
		b1.setA(5);
		b1.sub();
		System.out.println(b1.getA());
		System.out.println(b2.getA());
	}
}
