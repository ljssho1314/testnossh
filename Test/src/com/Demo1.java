package com;

import java.util.HashSet;
import java.util.Iterator;


public class Demo1 {
	
	private int num = 4;
	
	public void ss()
	{
		inclass i = new inclass();
		i.say();
	}
	
	private class inclass
	{
		void say(){
			System.out.println("aaaaaaaaaaaaa"+num);
		}
	}

	public static void main(String[] args) {
		Demo1 a = new Demo1();
		a.ss();
//		Demo1.inclass i = new Demo1().new inclass();
//		i.say();
//		tackeit t = new tackeit();
		
//		tackeitRunnable t = new tackeitRunnable();
//		Thread t1  = new Thread(t,"win1");
//		Thread t2  = new Thread(t,"win2");
//		Thread t3  = new Thread(t,"win3");
//		Thread t4  = new Thread(t,"win4");
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
	} 

}
