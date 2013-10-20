import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestJPasswordField extends JApplet implements ActionListener, DocumentListener{
 JLabel jl1,jl2;
 JPasswordField jp1,jp2;
 JTextField jtf;
 JTextArea jta;
 JButton commit,cancel;

 public void init(){
	Container c = getContentPane();
	
	jl1 = new JLabel("请输入您的密码：");
	jl2 = new JLabel("请再次输入密码：");
	jp1 = new JPasswordField(10);
	jp2 = new JPasswordField(10);
	jtf = new JTextField("jtextfield",10);
	jta = new JTextArea(5,6);
	commit = new JButton("确认");
	cancel = new JButton("清除");
	c.setLayout(new GridLayout(4,2));
	c.add(jl1);
	c.add(jp1);
	c.add(jl2);
	c.add(jp2);
	c.add(commit);
	c.add(cancel);
	c.add(jtf);
	c.add(jta);
	
	//jtf.setEditable(false);
	jta.insert("this is a jtextarea component!",0);
	
	commit.addActionListener(this);
	cancel.addActionListener(this);
	jtf.addActionListener(this);
	jta.getDocument().addDocumentListener(this);
 }
 public void actionPerformed(ActionEvent e)
 {
	if(e.getSource()==commit)
		if(String.valueOf(jp1.getPassword()).equals(String.valueOf(jp2.getPassword())))
				showStatus("密码输入成功！");
		else
				showStatus("两次输入的密码不同，请重新输入！");
	else if(e.getSource()==cancel)
		{
			jp1.setText("");
			jp2.setText("");
		}
	else
		jtf.setText("");
 }
 
 public void changedUpdate(DocumentEvent event) 
 {  }

 public void insertUpdate(DocumentEvent event) 
 { 
 	 jtf.setText(jta.getText());
 }
 public void removeUpdate(DocumentEvent event)
 {
   jtf.setText ("removeUpdate");
  } 		
}

