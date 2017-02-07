package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSo2 {
	
	
	public static void main(String str[])
	{
		try {
			Socket ss = new Socket("127.0.0.1",8888);
			PrintWriter pw  = new PrintWriter(ss.getOutputStream());
			pw.println("我是第二个");
			pw.flush();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("client");
	}
}
