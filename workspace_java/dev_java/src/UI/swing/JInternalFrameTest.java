package UI.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JInternalFrameTest extends JFrame implements ActionListener{
	JRootPane jrp = this.getRootPane();
	Container jcp = this.getContentPane();
	JDesktopPane jdp = new JDesktopPane();
	JPanel jp_south = new JPanel();
	JButton jbtn_new = new JButton("새창");
	public void initDisplay() {
		jbtn_new.addActionListener(this);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south.add(jbtn_new);
		jcp.add("South",jp_south);
		jcp.add("Center",jdp);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JInternalFrameTest jif = new JInternalFrameTest();
		jif.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_new) {
			InnerFrame inn = new InnerFrame("새창",true,true,true,true);
			jdp.add(inn);
		}
	}

}
class InnerFrame extends JInternalFrame{
	private String[][] str = {{"1_1", "1_2", "1_3", "1_4"}, {"2_1", "2_2", "2_3", "2_4"}, {"3_1", "3_2", "3_3", "3_4"}};
	private String[] str1 = {"1번", "2번", "3번", "4번"};
	private JTable jt = new JTable(str,str1);
	private JScrollPane jsp = new JScrollPane(jt);
	InnerFrame(String str,boolean a, boolean b, boolean c, boolean d){
		super(str,a, b, c, d);
		this.setTitle(str);
		this.setSize(300,200);
		this.setVisible(true);
	}
}
