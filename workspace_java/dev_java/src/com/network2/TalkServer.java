package com.network2;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * ������ 24�ð� �����Ǿ�� �ϰ� ���� ����ڰ� ���ÿ� ������ ��  �ִ�.
 * �� �� ������ �������Ƿ� �����尡 ÷���Ǹ� ���������� ����ڸ� ���� �� ���� ���̴�.
 * 
 * �ڹٴ� ���� ��Ӹ� �����Ѵ�.
 * ���� �ٸ� Ŭ������ �����ϰ� ���� �� �������̽��� �����ϵ��� ����
 * 
 */
public class TalkServer extends JFrame implements Runnable {
	ServerSocket server = null;
	Socket       client = null;
	JTextArea 	jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
			                             ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                             ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//������ ������
	TalkServerThread tst = null;
	List<TalkServerThread> chatList = null;
	public TalkServer() {
		
	}
	public void initDisplay() {
		//Ŭ������ implements���� �ʰ� �͸�Ŭ������ ó���غ���
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					if(server!=null) server.close();
					//�ڹٰ���ӽŰ��� ����� ����
					System.exit(0);
					//�������÷��� ȣ�� System.gc();
					//�����Ⱚ ����̸� Candidate���¶� ��.
					//Candidate���°� �Ǵ°� ����?
					// A a = new A();  A a = null; �̶� ���ͼ�Ʈ a = new A();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		this.add("Center",jsp_log);
		this.setTitle("���� �α� ���....");
		this.setSize(500, 400);
		this.setVisible(true);
	}//////////////////end of initDisplay
	//main�� ���� ���� ����ȴ�.- main�޼ҵ嵵 ���ν�������.
	public static void main(String args[]) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		new Thread(ts).start();//��[TalkServer]�ȿ� �ִ� run�޼ҵ� ȣ���.
	}/////////////////end of main
	@Override
	public void run() {
		//List�� �������̽�, Vector�� List�� �����ϴ� ����ü Ŭ������.
		chatList = new Vector<TalkServerThread>();
		boolean isStop = false;
		try {
			server = new ServerSocket(3001);
			while(!isStop) {
				client = server.accept();//������������(�����Ŀ� ��Ʈ��ȣ �Ҵ�)
				jta_log.append(client.toString()+"\n");//������Ʈ��ȣ ����׽�Ʈ
				//������ �����ϱ�
				//�Ķ���ͷ� TalkServer�� �ѱ�� �� ������ TalkServer�� �����ߴµ�
				//����� TalkServerThread������ ��밡���ؾ� �ϴϱ�......
				tst = new TalkServerThread(this);
				tst.start();//run�޼ҵ带 �ڵ�(JVM)���� ȣ����. - �ݹ�޼ҵ�
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}/////////////////end of run
}







