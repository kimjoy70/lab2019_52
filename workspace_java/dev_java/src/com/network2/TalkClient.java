package com.network2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyledDocument;


import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
public class TalkClient extends JFrame implements ActionListener{
	Socket mySocket = null;
	ObjectInputStream ois  = null;
	ObjectOutputStream oos = null;	
	//JTextArea jta_display 	= new JTextArea();
	//JTextPane�� ��Ÿ���� �����ϱ� ���ؼ��� ��Ÿ���� �����ϴ� Ŭ������ �߰��� �����Ͽ�
	//����ؾ� �Ѵ�.
	//�ֳ��ϸ� ������ ��쵵 �׸��� �������� �����ؾ� �ϹǷ� �۲��� �����Ű�ų� ��ũ�⸦ �����ϴ�
	//�κе� �ݿ��Ϸ��� �� �ʿ�
	StyledDocument sd_display = 
						new DefaultStyledDocument(
								new StyleContext());
	Image i;
	String imgPath = "C:\\dev_kosmo20181101\\dev_java\\com\\book\\image\\";
	ImageIcon icon = new ImageIcon(imgPath+"booklogo.jpg");
	JLabel jlb_bg = new JLabel(icon);
	JTextPane   jtp_display     = new JTextPane(sd_display);
	JScrollPane jsp_display 
				= new JScrollPane(jtp_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
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
	JOptionPane jop = null;
	String ip = "127.0.0.1";
	int port = 3001;
	String nickName = null;
	//���� ������ �ѱ� �� Color��ü�� ����ؾ������� ��Ž� Object�� �ѱ� �� ���
	//String Ÿ������ ������ �Ѱܾ� ��.
	String fontColor = "0";	
	JFrame jf_fontColor = null;
	JTableHeader jth_nick = jtb_nick.getTableHeader();
	PictureMessage  pm = new PictureMessage(this);
	public TalkClient() {
		nickName = JOptionPane.showInputDialog("���� ��ȭ����?");
		initDisplay();
		try {
			//����� ������ �� �ִ�.-wait - try...catch�ؾ���.
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream
					(mySocket.getOutputStream());			
			ois = new ObjectInputStream
						(mySocket.getInputStream());
			//100|���ʺ�
			oos.writeObject(Protocol.ROOM_IN
					       +Protocol.seperator+nickName
                		   +Protocol.seperator+fontColor);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();//TalkClientThread�� runȣ���.-�ݹ��Լ�
		} catch (Exception e) {
			System.out.println(e.toString());//���� ��Ʈ�� ���.
		}
	}
	//������ ��� ���� �̺�Ʈ ���� ������ �� �����Ƿ� ���� �����ϵ��� �޼ҵ�� ������ ����.
	public void exitChat() {
		try {
			oos.writeObject(500+"|"+this.nickName);
		} catch (Exception e) {
			//stack�޸� ������ �׿��ִ� ���� �޽������� ���������� ������ְ� ���ι�ȣ�� ���� �޽��� ���
			e.printStackTrace();//�� �������.- ��Ʈ�� ����ϴ� �޼ҵ��ε� �̷±����� ���, ���ι�ȣ�� ���� ���
		}
	}
	public void initDisplay() {
		//�̸�Ƽ�� 
		jbtn_emoticon.addActionListener(this);
		//��ȭ�� ���� ��ư �̺�Ʈ ���� - �ݹ��Լ�(actionPerformed)�� ȣ���
		jbtn_change.addActionListener(this);
		jbtn_send.setBorderPainted(false);
		jbtn_send.setFocusPainted(false);
		i = Toolkit.getDefaultToolkit().getImage(imgPath+"googlelogo.png");
		//JTable ��� ����
		jth_nick.setBackground(Color.red);
		jth_nick.setForeground(Color.WHITE);
		jtb_nick.setGridColor(Color.red);
		jtp_display.setEditable(false);
		jtp_display.setFocusable(false);
		//���ڻ� �����ư
		jbtn_fontColor.addActionListener(this);
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
		this.setTitle(nickName+"���� ��ȭâ");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
	}
	public void message_process(String msg) {
		if(msg==null ||msg.length()==0){
			msg = "�̸�Ƽ��";
			try {
				oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+nickName
						+Protocol.seperator+msg
						+Protocol.seperator+fontColor
						+Protocol.seperator+pm.imgChoice);
			} catch (Exception e2) {
				System.out.println(e2.toString());//��Ʈ�� ����ϱ�
			}
		}
		else {//�޽����� ���� ��
			try {
				oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+nickName
						+Protocol.seperator+msg
						+Protocol.seperator+fontColor
						+Protocol.seperator+"default");
			} catch (Exception e2) {
				System.out.println(e2.toString());//��Ʈ�� ����ϱ�
			}
		}
		jtf_msg.setText("");		
	}
	/*******************************************************************
	 * TalkClient�� �̺�Ʈ ó�������� ���ϱ⸸�� �����ϰ� �˴ϴ�.
	 * ���⼭ ���� ������ �ݵ�� ������ �����մϴ�. - TalkServerThread�� run()���� ��� ���ϱ� ó����. 
	 * @param e
	 ******************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ�� ������ ��ư�̳� ����Ű������ ������Ʈ�� �ּҹ���
		String msg = jtf_msg.getText();
		if(obj == jbtn_emoticon) {
			pm.setVisible(true);
		}
		else if(obj == jbtn_change) {//�� ��ȭ�� �����ҷ���?
			//�������� ��ȭâ�� ���� ������ run�޼ҵ�(4��:this.setTitle(afterName+"���� ��ȭâ"))���� ó������.
			String afterName = 
					JOptionPane.showInputDialog("������ ��ȭ���� �Է��ϼ���.");
			//���� ����ڰ� �����̽��ٸ� �Է��Ͽ���. -�ٽ� �Է��ϵ��� �䱸�ϱ� - return
			if(afterName == null || afterName.trim().length()<3) {
				JOptionPane.showMessageDialog
				(this, "������ ��ȭ���� �ȹٷ� �Է��ϼ���.", "INFO"
			   , JOptionPane.INFORMATION_MESSAGE);
				return;//actionPerformed Ż��, break-�ݺ����� Ż��
			}
			//�޽��� ����
			//���ǻ���-StringTokenizer���� ��� ó���� �� ���� ���߱�
			//�߻���Ȳ:������ �α׿��� ����� �Ǿ��µ� Ŭ���̾�Ʈ������ �޽����� ��µ��� ����.
			try {
				oos.writeObject(Protocol.CHANGE+Protocol.seperator
						       +nickName+Protocol.seperator
						       +afterName+Protocol.seperator
						       +nickName+"���� ��ȭ���� "+afterName+"���� ����");
			} catch (Exception e2) {
			//�����޽����� JVM�� �����Ѵ�.-stack����(�賶)
			//stack�� ���� �����޽����� �����.- Line Number��� - ��Ʈ	
				e2.printStackTrace();//����ؿ�..........
			}
		}///////////////end of ��ȭ�� ����
		else if(obj==msg || obj==jtf_msg) {
			message_process(msg);
/*			if(msg==null ||msg.length()==0){
				msg = "�̸�Ƽ��";
			}	
			try {
				oos.writeObject(Protocol.MESSAGE
						       +Protocol.seperator+nickName
						       +Protocol.seperator+msg
						       +Protocol.seperator+fontColor
				               +Protocol.seperator+pm.imgChoice);
			} catch (Exception e2) {
				System.out.println(e2.toString());//��Ʈ�� ����ϱ�
			}
			jtf_msg.setText("");*/
		}
		else if(obj==jbtn_exit) {
			exitChat();
			//��� 0�� �ָ� �ڹٰ���ӽŰ��� ������� ���Ե�.
			//���� ���� - �޸𸮰� ��� ȸ����.
			System.exit(0);
		}
		else if(obj == jbtn_fontColor) {
			jf_fontColor = new JFrame();
			jf_fontColor.setSize(600, 500);
			//�������� ��� �ȷ�Ʈ ���� - JTable
			JColorChooser jc_color = new JColorChooser();
			//������������ Objectȭ
			ColorSelectionModel model = jc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					Color c_fontColor = jc_color.getColor();
					fontColor=String.valueOf(c_fontColor.getRGB());
				}
			};
			//���� �ȷ�Ʈ���� ������ ������ ����ɶ� ���� �̺�Ʈ�� �����ؼ� ���������� ��������.
			model.addChangeListener(listener);
			jf_fontColor.add(jc_color);
			jf_fontColor.setVisible(true);
		}//////////////////end of ���ڻ�
	}

}









