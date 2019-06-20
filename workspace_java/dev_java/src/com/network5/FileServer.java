package com.network5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileServer extends JFrame implements Runnable{
	ServerSocket ss = null;
	Socket client = null;
	int len = 0;
	int nameLen = 0;
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
	public FileServer() {
		fileAccount();

	}
	public void fileAccount() {
		try {
			ss = new ServerSocket(3002);
			client = ss.accept();
			JOptionPane.showMessageDialog(this, client);
			ips = client.getInputStream();
			ops = client.getOutputStream();
			dis = new DataInputStream(client.getInputStream());
			path = new File("C:\\Java\\dev_javaB\\dev_java\\src\\com\\network5\\image\\lion11.png");
			System.out.println("°æ·Î : "+path.getAbsolutePath());
			arrlen = dis.readInt();
			bis = new BufferedInputStream(client.getInputStream());
			for(int i=0;i<arrlen;i++) {
				nameLen = ips.read();
				ips.read(bytes, 0, nameLen);
				String name = new String(bytes,0,nameLen);
				long size = dis.readLong();
				System.out.println(i+"th\t"+name+"\t name length "+nameLen);
				bos = new BufferedOutputStream(new FileOutputStream(path.getAbsolutePath()));
				count = (int)(size/1024);
				leftLen = (int)(size-(count*1024));
				for(int j=0;j<count;j++) {
					bis.read(bytes);
					bos.write(bytes);
				}
				bis.read(bytes, 0, leftLen);
				bos.write(bytes, 0, leftLen);
				bos.flush();
				bos.close();
				System.out.println("Last byte length "+leftLen);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public void run() {

		boolean isStop = false;
		try {
			ss = new ServerSocket(3002);
			while(!isStop) {
				client = ss.accept();//
				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		fileAccount();
	}/////////////////end of run
	public static void main(String[] args) {
		FileServer fs = new FileServer();
		//Thread th = new Thread(fs);
		//th.start();
	}

}
