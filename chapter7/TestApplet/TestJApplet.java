import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJApplet extends JApplet implements ActionListener{
	JLabel j1;
	JButton jbtn;
	JTextField jtf;
	Icon icn;
	
	public void init(){
		icn = new ImageIcon("swing");
		j1 = new JLabel("JLabeL",icn,JLabel.CENTER);
		jbtn = new JButton("JButton");
		jtf = new JTextField(10);
		
		Container c = getContentPane();
		c.add(j1,BorderLayout.CENTER);
		c.add(jbtn,BorderLayout.SOUTH);
		c.add(jtf,BorderLayout.NORTH);
		
		jbtn.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbtn){
			j1.setText(jtf.getText());
			
		}
	}
	
}