package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSo {
	
	
	public static void main(String str[]) throws IOException
	{
		
		try {
			while(true)
			{
				ServerSocket ss = new ServerSocket(8888);
//				ss.setSoTimeout(1000);
				Socket sc = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String str1 = br.readLine();
				System.out.println(str1);
				sc.close();
				ss.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
		}
//		
	}
}
