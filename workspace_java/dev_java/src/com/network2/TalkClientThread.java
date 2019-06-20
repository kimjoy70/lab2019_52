package com.network2;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TalkClientThread extends Thread {
	TalkClient tc = null;
	String path = "C:\\Java\\dev_javaB\\dev_java\\src\\image\\";
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	//���ڻ����̳� �۲�, ��Ʈ ������ ���� �����ϰ� ���� ��
	public SimpleAttributeSet makeAttribute(String fontColor) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fontColor)));
		return sas;
	}
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) {//���ѷ��� �����ڵ带 �� �߰����� - ����ó������, ���ǽ��� Ȱ������
			try {
				//100|���ʺ�
				msg = (String)tc.ois.readObject();
				StringTokenizer st  = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case Protocol.ROOM_IN:{
						String nickName = st.nextToken();
						//�����Ͽ����ϴ� ���ڻ��� �ʷϻ����� �����ϱ�
						String fontColor = st.nextToken();
						SimpleAttributeSet sas = makeAttribute(fontColor);
						Vector<String> v_nick = new Vector<String>();
						v_nick.add(nickName);
						tc.dtm_nick.addRow(v_nick);
						tc.jsp_nick.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
						//tc.jtp_display.append(nickName+"���� �����Ͽ����ϴ�.\n");
						//����ó����� - JDBC API, Network API, Thread, IO
						try {
							//offset-��ġ, str-�޽���, a-attribute�Ӽ��ο�
							//tc.sd_display.insertString(offset, str, a);
							tc.sd_display.insertString(tc.sd_display.getLength()
									                 , nickName+"���� �����Ͽ����ϴ�.\n"
									                 , sas);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}break;
					case Protocol.MESSAGE:{//200
						String nickName = st.nextToken();
						String message = st.nextToken();
						//�޽��� �ڿ� Vector�� ���� Object�� �ѱ� �� �ֳ�?
						String fontColor = st.nextToken();
						String imgChoice = st.nextToken();
					    MutableAttributeSet  attr1 = new SimpleAttributeSet();
					    MutableAttributeSet  attr2 = new SimpleAttributeSet();
					    if(!imgChoice.equals("default")){
						    int i=0;
						    for(i=0;i<tc.pm.imgfile.length;i++){
						    	if(tc.pm.imgfile[i].equals(imgChoice)){
						    		JOptionPane.showMessageDialog(tc, "�̹����̸�:"+tc.pm.imgfile[i]);
						    		StyleConstants.setIcon(attr2,
						    				new ImageIcon(path + tc.pm.imgfile[i]));
						    		try{
						    			tc.sd_display.insertString(tc.sd_display.getLength() , "\n" , attr2);
						    		}catch(Exception ex){}
						    	}
						    }
					    }//////////////////////end of emoticon
						//JOptionPane.showMessageDialog(tc, "style:"+style.length);
						//if(!message.equals("�̸�Ƽ��")){
						else if(imgChoice.equals("default")){	
							//SimpleAttributeSet sas = makeAttribute(style);
							//tc.jta_display.setLineWrap(true);
							try {
								//JOptionPane.showMessageDialog(tc, "insertString:"+nickName);
								tc.sd_display.insertString(tc.sd_display.getLength(),"["+nickName+"]"+message+"\n", null);
								//tc.textPane.insertEmoText(nickName+ " : "+msg+"\n", sas);					
							} catch (Exception e) {
								JOptionPane.showMessageDialog(tc, "Excepton:"+e.toString());
							}
							tc.jtp_display.setCaretPosition(tc.sd_display.getLength());					
							//tc.jta_display.append("["+nickName+"] "+msg+"\n");
							//tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
						}//////////////////////end of �̸�Ƽ��						
						//tc.jtp_display.append("["+nickName+"]"+message+"\n");
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
					}break;	
					//��ȭ�� ����ó�� - Ŭ���̾�Ʈ�� ó�� - ����� ��ȭ���� dtm_nick����ó��- dtm_nick.setValueAt(what,row,cols);
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String message = st.nextToken();
						//���̺� ��ȭ�� �����ϱ� - ���⼭ setValueAt()Ȱ���Ұ�.
						for(int i=0;i<tc.dtm_nick.getRowCount();i++) {
							//��ȭ���� �������� ���� dtm_nick���� ������ ��ȭ���� ��´�.
							//�ֳ��ϸ� �̸��� ���ؼ� �� ���� afterName���� �ٲ���� �ϴϱ�.....
							String currentName = (String)tc.dtm_nick.getValueAt(i, 0);
							if(nickName.equals(currentName)) {//�������� �޾ƿ� nickName�� dtm_nick�� �ִ� nickName�� ������ �ִ�?
								tc.dtm_nick.setValueAt(afterName, i, 0);
								break;
							}
							//����� ��ȭ�� �޽����� ����ϱ�
							try {
								tc.sd_display.insertString
										(tc.sd_display.getLength(), message, null);
							} catch (Exception e) {
								// TODO: handle exception
							}
							//�޽����� �߰��ɶ� ��ũ�ѹ� �ڵ� ��ġ ����
							tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
							//ä��â�� Ÿ��Ʋ�� ��������.
							if(nickName.equals(tc.nickName)) {
								tc.setTitle(afterName+"���� ��ȭâ");
								tc.nickName = afterName;
							}
						}
					}break;
					case Protocol.ROOM_OUT:{//500
						String nickName = st.nextToken();
						//tc.jtp_display.append(nickName+"���� ���� �Ͽ����ϴ�.\n");
						//DefaultTableModel���� ����� ���� �����ϱ�
						for(int i=0;i<tc.dtm_nick.getRowCount();i++) {
							String n1 = (String)tc.dtm_nick.getValueAt(i,0);
							if(n1.equals(nickName)) {
								tc.dtm_nick.removeRow(i);
							}
						}
					}break;
				}//////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
