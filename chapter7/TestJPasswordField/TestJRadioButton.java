//<html><body><applet code = "TestJRadioButton.class" width =300 height = 300></applet></body></html>

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestJRadioButton extends JApplet implements ItemListener
{
	JRadioButton  r1, r2, r3;
	ButtonGroup bg;
	JLabel jl;
	
	public void init()
	{
		Container c = getContentPane();
		r1=new JRadioButton("教授"); 
		r2=new JRadioButton("副教授"); 
		r3=new JRadioButton("讲师"); 
		bg=new ButtonGroup(); 
	
		bg.add(r1); 
		bg.add(r2); 
		bg.add(r3);
		
		c.add(r1,BorderLayout.NORTH);
		c.add(r2,BorderLayout.CENTER);
		c.add(r3,BorderLayout.SOUTH);
			
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		JRadioButton temp;
		
		if(e.getItemSelectable() instanceof JRadioButton)
		{
			temp = (JRadioButton)(e.getItemSelectable());
			if(temp.getText()=="教授") 
				showStatus("教授");				
			if(temp.getText()=="副教授") 
				showStatus("副教授");
			if(temp.getText()=="讲师") 
				showStatus("讲师");
		}
	}
}
