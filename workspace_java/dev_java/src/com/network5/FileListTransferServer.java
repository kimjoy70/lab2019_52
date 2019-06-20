package com.network5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class FileListTransferServer extends JFrame {
	public FileListTransferServer() {
		ServerSocket serverSocket = null; 
		Socket socket = null;
		  
		File myFile = new File("C:\\Java\\dev_javaB\\dev_java\\src\\com\\network5\\image");
		File[] myFilesInfo1 = myFile.listFiles(); 
		  
		try{
			System.out.println("myFilesInfo1.length"+myFilesInfo1.length);
		// 서버 소켓 생성, 포트번호 1209
		    serverSocket = new ServerSocket( 5500 );
		    System.out.println("server ready");
		    
		    System.out.println("wait for connect...");
		    // 클라이언트의 접속 대기 이것은 보통 분리된 쓰레드로 하는것이 정석이나 일단 대충...
		    // 이 메서드가 리턴하면 연결이 성공된 것임
		    socket = serverSocket.accept();
		    System.out.println("conneced...");
		    // socket.getInetAddress() 메서드는 접속한 클라이언트의 IP 를 가져옴 ( InetAddress 형)
		    System.out.println("from : " + socket.getInetAddress() );
		    // getLocalPort() 는 클라이언트의 포트번호를, getLocalPort() 는 서버의 포트번호를 가져온다. (int 형)
		    System.out.println("server port : " + socket.getLocalPort() );
		    System.out.println("client port : " + socket.getPort() );
		    
		    InputStream in = socket.getInputStream();
		    OutputStream out = socket.getOutputStream();
		    DataInputStream dis = new DataInputStream( in );
		    DataOutputStream dos = new DataOutputStream( out );
		    
		    dos.writeInt( myFilesInfo1.length );
		   
		    FileListSendThread flst;
		    flst = new FileListSendThread(myFilesInfo1, in, out );
		    flst.start();   
		    
		    //socket.close();
		   
		}catch( IOException e ){
		   e.printStackTrace();
		}		
	}
	public static void main(String[] args) {
		new FileListTransferServer(); 
	}
}
class FileListSendThread extends Thread{
 
    File[] fileList;
    InputStream in;
    OutputStream out;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    DataInputStream dis;
    DataOutputStream dos;
 
 	public FileListSendThread( File[] fileList, InputStream in, OutputStream out ) throws IOException{
 		this.fileList = fileList;
 		this.in = in;
 		this.out = out;
  
 		dis = new DataInputStream( this.in );
 		dos = new DataOutputStream( this.out );
 	}
 
 	public void run(){
 		System.out.println("Server run호출 성공");
 		File temp = null;
 		int fileNum = 0 ;  
  
 		try {
 			oos = new ObjectOutputStream( this.out ); // 생성자에서 ObjectOutputStream 을 생성하면 블록된다!! 
 			ois = new ObjectInputStream( this.in );
 		} catch ( IOException ioe ) {
 			ioe.printStackTrace();
 		}
  
 		fileNum = fileList.length;   // 먼저 파일의 갯수를 변수에 받고
  
 		try {
 			System.out.println( "fileNum = " + fileNum );
 			dos.writeInt( fileNum ); // 클라이언트에게 파일의 갯수가 몇개인지 알려준다.
 			System.out.println( "DataOutput fileNum = " + fileNum );
   
 			for( int i = 0 ; i < fileNum ; i++ ){    
 				temp = fileList[i];     
     
 				System.out.println("temp:"+temp);
 				oos.writeObject(temp ); // 직렬화 하여 전송한다.
 			}
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
}
