package com;

public class tackeit extends Thread
{

	private int count = 100;
	int i=0;
	@Override
	public void run() {
		
		while(count>0)
		{
			Thread t = Thread.currentThread();//��ȡ��ǰִ�е��߳�
			String tname = t.getName();
			
			System.out.println(tname+"�߳����˵�"+count--+"��Ʊ");
		}
	}

	
}
