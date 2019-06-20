package com.network3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MessageRoom extends JPanel implements ActionListener{
	TalkClientVer2 tc2 = null;
	JTextArea jta_display 	= new JTextArea();
	JScrollPane jsp_display 
				= new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
						        , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_first 		= new JPanel();//���� ��ġ�� ������Ʈ ���
	JPanel jp_first_south   = new JPanel();//BorderLayout
	JTextField jtf_msg 		= new JTextField();//Center
	JButton jbtn_send 		= new JButton("����");//East
	JPanel jp_second 		= new JPanel();//���� �߰��ϴ� ������Ʈ ���-JTable - Center:JTable, South:��ư 6��
	JPanel jp_second_south 	= new JPanel();//���� �߰��ϴ� ������Ʈ ���-JButton 6�� - GridLayout(3,2)
	JButton jbtn_whisper	= new JButton("1:1");//East
	JButton jbtn_change		= new JButton("��ȭ����");//East
	JButton jbtn_fontColor	= new JButton("���ڻ�");//East
	JButton jbtn_emoticon	= new JButton("�̸�Ƽ��");//East
	JButton jbtn_blank 		= new JButton("");//East
	JButton jbtn_exit 		= new JButton("����");//East
	String cols[] = {"��ȭ��"};
	String data[][] = new String[0][1];
	//DataSet�� ������ �����ϴ� DefaultTableModel�� ���� �����ϰ� �ʱ�ȭ �ϱ�
	DefaultTableModel dtm_nick = new DefaultTableModel(data,cols); 
	JTable 			  jtb_nick = new JTable(dtm_nick);
	JScrollPane 	  jsp_nick = new JScrollPane(jtb_nick
			                                    ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                    ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	public MessageRoom() {
	}

	public MessageRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	public void initDisplay() {
		jbtn_exit.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_send.addActionListener(this);
		//JFrame�� ���̾ƿ��� GridLayout����
		this.setLayout(new GridLayout(1,2));
		//ù��° ���ǿ� ���� ������Ʈ ��ġ
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);
		//�ι�° ���ǿ� �߰�  ������Ʈ ��ġ
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second.add("Center", jsp_nick);
		jp_second_south.add(jbtn_whisper);//1:1
		jp_second_south.add(jbtn_change);//��ȭ����
		jp_second_south.add(jbtn_fontColor);//���ڻ�
		jp_second_south.add(jbtn_emoticon);//�̸�Ƽ��
		jp_second_south.add(jbtn_blank);//��ũ
		jp_second_south.add(jbtn_exit);//����
		jp_second.add("South",jp_second_south);
		this.add(jp_first);//ù��° ����
		this.add(jp_second);//�ι�° ����
		this.setSize(500, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
