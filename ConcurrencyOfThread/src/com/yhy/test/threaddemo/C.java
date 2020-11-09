package com.yhy.test.threaddemo;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class C {

	int i = 0;
	private static C t = new C();

	public static void main(String[] args) throws Exception {
		//Unsafe unsafe = Unsafe.getUnsafe();

		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);

		Field f = C.class.getDeclaredField("i");
		long offset = unsafe.objectFieldOffset(f);
		System.out.println(offset);

		boolean success = unsafe.compareAndSwapInt(t, offset, 0, 1);
		System.out.println(success);

		System.out.println(t.i);
		//unsafe.compareAndSwapInt()

	}
}
