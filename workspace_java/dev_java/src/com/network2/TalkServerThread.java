package com.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;


public class TalkServerThread extends Thread {
	TalkServer ts = null;
	ObjectInputStream ois  = null;
	ObjectOutputStream oos = null;
	String nickName = null;//��濡 ������ ����� ��ȭ�� ���
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream
					(ts.client.getOutputStream());			
			ois = new ObjectInputStream
						(ts.client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				 st = new StringTokenizer(msg,"|");
			}
			st.nextToken();//100
			nickName = st.nextToken();//�г���
			String fontColor = st.nextToken();
			for(TalkServerThread tst:ts.chatList) {
				String currentName = tst.nickName;
			//this�� ����� ���� tst�� ����� �� �������� ���ؼ� ������ ������.	
				this.send(Protocol.ROOM_IN
						 +Protocol.seperator+currentName
				         +Protocol.seperator+fontColor);
			}
			ts.chatList.add(this);
			this.broadCasting(msg);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public void broadCasting(String msg) {
		for(TalkServerThread tst:ts.chatList) {
			tst.send(msg);
		}
	}
	private void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		boolean isStop = false;
		try {
			run_start://while�� ���� �ݺ��� ��ü�� ���� �������� ó���Ҷ�
			while(!isStop) {
				String msg = (String)ois.readObject();
				ts.jta_log.append(msg+"\n");
				ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				int protocol = 0;
				//��ū(|)�� �������� ���ڿ� �߶� ī��Ʈ �Ѵ�.
				//������ ���� protocol�� ���� ���Ƿ� �Ʒ��� ó���� �� 1�� ���� �����.
				//switch���� ���ǰ����� Ȱ���ϱ� ���� ���� �߶󳽴�.
				StringTokenizer st = null;
				if(msg!=null) {
					st = new StringTokenizer(msg,Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				//msg==> 200|����|�����?
				switch(protocol) {
				case Protocol.MESSAGE:{//200
					String nickName = st.nextToken();
					String message = st.nextToken();
					String fontColor = st.nextToken();
					String imgChoice = "";
					while(st.hasMoreTokens()){
						imgChoice = st.nextToken();
					}					
					this.broadCasting(Protocol.MESSAGE
							         +Protocol.seperator+nickName
							         +Protocol.seperator+message
							         +Protocol.seperator+fontColor
							         +Protocol.seperator+imgChoice);
				}break;
				//300|nickName|afterName|msg
				case Protocol.CHANGE:{//case���ȿ� {}���� ������ �����ߺ������� ���ϱ� ���ؼ�.
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String message = st.nextToken();
					//Ŭ���̾�Ʈ������ ��ȭ���� ���� ��û�Ͽ���.
					//���������� ����ϰ� �ִ� �̸������� �����ؾ��ұ�? ���ص� �ǳ�?
					//���������� ����ϰ� �ִ� �̸��� nickName�ϱ�? �ƴ� afterName�ϱ�?
					//insert here
					this.nickName = afterName;//��ȭ���� afterName���� �����ؼ� ������.
					//��۳�������(run() - 2���۾��Ϸ�, 3�� �۾��Ϸ�:broadCasting
					broadCasting(Protocol.CHANGE+Protocol.seperator
							    +nickName+Protocol.seperator
							    +afterName+Protocol.seperator
							    +message);
				}break;
				//�����ϱ⿡ ���� ó������
				case Protocol.ROOM_OUT:{//500
					String nickName = st.nextToken();
					//500 �޽����� ������ �����带 chatList���� ���� �Ѵ�.
					ts.chatList.remove(this);//tst
					String message = Protocol.ROOM_OUT
							        +Protocol.seperator+nickName;
					this.broadCasting(message);
				}break run_start;//break�ڿ� �󺧹��� ����ϸ� while�� ����ü�� ���� ����.
				}
			}/////////end of while
		} catch (Exception e) {
			// TODO: handle exception
		}
	}/////////////////end of run
}




