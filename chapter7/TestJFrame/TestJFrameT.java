import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJFrame1
{
	public static void main(String args[])
	{
		MyJFrame mf = new MyJFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

class MyJFrame extends JFrame implements ActionListener
{
	JLabel jl;
	JButton jbtn;
	JTextField jtf;
	Icon lblIcon, btnIcon;
	
	MyJFrame()
	{
		lblIcon = new ImageIcon("swing.gif");
		btnIcon = new ImageIcon("normal.gif");
		jl = new JLabel("picture label for example", lblIcon, JLabel.CENTER);
		jbtn = new JButton("copy", btnIcon);
		jtf = new JTextField(20);
		
		add(jl);
		add(jbtn, BorderLayout.SOUTH);
		add(jtf, BorderLayout.NORTH);
		
		jbtn.addActionListener(this);
		
		setVisible(true);
		setSize(300,200);
		}
	
	public void actionPerformed(ActionEvent e)
	{
		//if (e.getSource() == jbtn)
			jl.setText(jtf.getText());
		}
	}