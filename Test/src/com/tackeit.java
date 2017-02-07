package com;

public class tackeit extends Thread
{

	private int count = 100;
	int i=0;
	@Override
	public void run() {
		
		while(count>0)
		{
			Thread t = Thread.currentThread();//获取当前执行的线程
			String tname = t.getName();
			
			System.out.println(tname+"线程卖了第"+count--+"张票");
		}
	}

	
}
