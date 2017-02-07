package com;

public class tackeitRunnable implements Runnable
{

	private int count = 10;
	int i=0;
	@Override
	public  void run() {
		
		synchronized(tackeitRunnable.class)
		{
			while(count>0)
			{
				Thread t = Thread.currentThread();//获取当前执行的线程
				String tname = t.getName();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count<0){
					System.out.println("*****************"+count+"**********************************");
				}
				
				System.out.println(tname+"线程卖runnable了第"+count--+"张票");
			}
		}
		
	}

	
}
