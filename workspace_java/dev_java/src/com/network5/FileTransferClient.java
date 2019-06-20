package com.network5;
/*
 * 자바 네트워크 프로그래밍에서 자주 사용되는 ObjectInputStream 에서 발생하는 다음과 같은 스트림 오류를 해결한 예이다.

java.io.StreamCorruptedException: invalid type code:
java.io.StreamCorruptedException: invalid stream header:

결과적으로 아래의 코드에서 발생하는 에러 중 invalid type code: 는 스트림을 새로 생성하는 방법으로 해결할 수 있었고, invalid stream header: 에러는 새로 생성한 스트림을 사용하는 것이 아니라 이미 생성된 스트림의 참조를 다른 곳으로 전달하여 계속 재사용하는 방법으로 해결할 수 있었다. 
네트워크 상에서 이들 오류를 방지하려면 클라이언트와 서버간에 연결되는 입출력 스트림은 반드시 1대1로 연결되어야 한다는 것이다. 좀더 구체적으로 설명하면, new ObjectOutputStream ( socket.getOutputStream() ) 을 사용하여 출력스트림을 생성했다면 이 스트림에 연결되는 네트워크 상대편에서도 단 한번의 new ObjectInputStream ( socket.getInputStream() ) 으로 연결해야 한다는 것이며, 한개의 출력스트림 생성에 다수개의 입력스트림을 생성하여 사용하려는 경우에는 입력스트림 측에서 invalid stream header 오류가 발생한다. 반대로 한개의 입력스트림에 연결되는 네트워크 상대편에서 다수개의 출력스트림을 생성하여 사용하려는 경우에는 입력스트림 측에서 invalid type code 오류가 발생하게 된다
이 문제를 해결하려면 한번 생성된 스트림은 프로그램 내에서 계속 재사용해야 하고, 어쩔 수 없이 출력스트림을 다시 생성해야 한다면 이에 대응하는 입력스트림도 새로 생성하여 입출력 스트림의 1:1 관계를 유지해 주어야 한다
또 한가지 네트워크상의 오브젝트 스트림을 사용할 때 주의할 점은 ObjectInputStream의 생성자는 연결된 서버의 ObjectOutputStream의 생성자가 실행되기 전까지는 블로킹 상태로 머물러 있다는 것이다. ObjectInputStream 생성자 이후의 코드가 실행되지 않는 경우가 있다면 반드시 확인해야 하며 ObjectInputStream생성자보다 ObjectOutputStream의 생성자가 먼저 실행되도록 조정해야 한다
 */
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
public class FileTransferClient {
	final static int SIZE = 1024;
	OutputStream out = null;
	InputStream in = null;
	DataOutputStream dos = null;
	public FileTransferClient() {
	
	}
	public void init() {
		  String serverIp = "127.0.0.1"; // 서버 ip
		  int serverPort = 5500; // 서버 포트
		  System.out
		    .println("connect to server..." + serverIp + ":" + serverPort);
		  try {
		   // 객체 생성과 동시에 접속시도를 한다.
		   Socket socket = new Socket(serverIp, serverPort);
		   // 입력, 출력 스트림을 얻는다.
		   out = socket.getOutputStream();
		   in = socket.getInputStream();
		   dos = new DataOutputStream(out);
		   // 정수값을 이진데이터로 보낸다.
		   // 서버에서는 클라이언트와 약속된 이진 정수(4byte)데이터가 제대로
		   // 들어왔는지 확인하고 같으면 접속을 허용 다르면 접속을 끊을 것이다.
		   dos.writeInt(5500);
		   // 분리된 쓰레드에서 파일전송을 하기 위해서 쓰레드를 상속받은 클래스 사용
		   Thread.sleep( 50 );
		   FileReceiveThread frt;
		   frt = new FileReceiveThread(this,"lion11.png", "127.0.0.1", 5500);
		   frt.run();
		   System.out.println("close connection");
		   socket.close();
		  } catch (ConnectException ce) {
		   ce.printStackTrace();
		  } catch (IOException ie) {
		   ie.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }/////////////end of catch			
	}
	public static void main(String[] args) {
		FileTransferClient ftc = new FileTransferClient();
		ftc.init();
	}//////////////end of main
}
class FileReceiveThread extends Thread {
 Socket socket; // socket
 FileOutputStream fos; // File Stream
 InputStream is;
 OutputStream os;
 int serverPort; // server port
 String serverIp; // server Ip
 String filePath; // 파일 경로
 final static int BUFFER_SIZE = 1024 * 4; // /////////////// 버퍼 크기
 FileTransferClient ftc = null;
 	public FileReceiveThread(String filePath, String serverIp, int serverPort) {
 		this.serverPort = serverPort;
 		this.serverIp = serverIp;
 		this.filePath = filePath; // 파일의 경로
 		try {
 			System.out.println("filePath:"+filePath);//lion11.png
 			fos = new FileOutputStream(filePath);
 			System.out.println("Client fos: "+fos);
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 			// / FileNotFoundExceptione e;;
 		}
 	}////////////////end of FieReceiveThread
 	public FileReceiveThread(FileTransferClient ftc, String filePath, String serverIp, int serverPort) {
 		this.ftc = ftc;
 		this.serverPort = serverPort;
 		this.serverIp = serverIp;
 		this.filePath = filePath; // 파일의 경로
 		try {
 			System.out.println("filePath:"+filePath);//lion11.png
 			fos = new FileOutputStream(filePath);
 			System.out.println("Client fos: "+fos);
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 			// / FileNotFoundExceptione e;;
 		}
 	}
	public void run() {
 		System.out.println("FileReceiveThread run호출 성공");
 		byte[] buffer;
 		int i;
 		int n = 0;
 		buffer = new byte[BUFFER_SIZE]; // 버퍼 생성
  // 서버측의 accept 보다 socket 생성자가 먼저 호출되면 연결이 실패하기 때문에
  // 50ms 만큼 쉬어준다.
 		try {
 			socket = new Socket(serverIp, serverPort);
 			System.out.println("socket:"+socket);
 			while (true) {
 				os = socket.getOutputStream();
 				is = socket.getInputStream();
 				i = is.read(buffer);
// 				i = ftc.in.read(buffer);
 				System.out.println("client:i"+i);
 				if (i == -1)
 					break;
 				fos.write(buffer, 0, i);
 			} // while( true )
            //socket.close();
            //fos.close();
 		} catch (UnknownHostException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
}

