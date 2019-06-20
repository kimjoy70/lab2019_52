package com.network5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

	Socket client = null;
	int len = 0;
	int arrlen = 0;
	int count = 0;
	int leftLen = 0;
	File path = null;
	InputStream ips  = null;
	OutputStream ops = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	byte bytes[] = new byte[1024];
	File fileArr[] = null;
	BufferedOutputStream bos = null;
	BufferedInputStream bis = null;
	PrintStream ps = null;
	public FileClient() {
		fileAccount();
	}
	public void fileAccount() {
		try {
			System.out.println("Client fileAccount ");
			client = new Socket("127.0.0.1",3002);
			if(client!=null) {
				System.out.println("Socket client:"+client);
			}
			ips = client.getInputStream();
			ops = client.getOutputStream();
			ps = new PrintStream(ops);
			dos = new DataOutputStream(client.getOutputStream());
			System.out.println("CLIENT");
			bos = new BufferedOutputStream(client.getOutputStream());
			File deskTop = new File("C:\\Java\\dev_javaB\\dev_java\\src\\com\\network5\\image"); 
			File fileArr[] = deskTop.listFiles();
			dos.writeInt(fileArr.length);
			Scanner s = new Scanner(System.in);
			for(File file:fileArr) {
				if(file.isFile()) {
					System.out.println(file.getName()+"\tsize "+file.length()+"\t");
					ops.write(file.getName().length());
					ps.print(file.getName());
					dos.writeLong(file.length());
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(deskTop));
					len=0;
					long size = file.length();
					count = (int)(size/1024);
					leftLen = (int)(size-(count*1024));
					for(int j=0;j<count;j++) {
						bis.read(bytes);
						bos.write(bytes);
					}
					bis.read(bytes,0,leftLen);
					bos.write(bytes,0,leftLen);
					bos.flush();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Finished\n");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

	public static void main(String[] args) {
		FileClient fc = new FileClient();
	}

}
