import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class TestJCheckbox extends JApplet implements ItemListener, ListSelectionListener
{
	JButton jbtn;
	JCheckBox jc;
	JComboBox jcb;	//awt.Choice
	JList jl;	
	String[] slist = {"18", "24" ,"30"}; 
	Font oldF;
	
	public void init()
	{
		jbtn = new JButton("  Ð§¹û  ");		
		jc = new JCheckBox("blue");	
		jl = new JList(slist);
		jcb = new JComboBox();
		jcb.addItem("plain");
		jcb.addItem("italic");
		jcb.addItem("bold");
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jbtn);
		c.add(jc);
		c.add(jcb);
		c.add(jl);
		
		jc.addItemListener(this);
		jcb.addItemListener(this);
		jl.addListSelectionListener(this);
		}
	
	public void itemStateChanged(ItemEvent e)
	{
		JComboBox temp;
		oldF = jbtn.getFont();
		
		if (e.getItemSelectable() instanceof JCheckBox)
		{
			if (((JCheckBox)e.getItemSelectable()).isSelected())
				jbtn.setBackground(Color.blue);
			}
		
		if (e.getItemSelectable() instanceof JComboBox)
		{
			temp = (JComboBox)e.getItemSelectable();
			
			if(temp.getSelectedItem()=="plain")
				jbtn.setFont(new Font(oldF.getName(),Font.PLAIN,oldF.getSize()));
			if(temp.getSelectedItem()=="italic")
				jbtn.setFont(new Font(oldF.getName(),Font.ITALIC,oldF.getSize()));
			if(temp.getSelectedItem()=="bold")
				jbtn.setFont(new Font(oldF.getName(),Font.BOLD,oldF.getSize()));
			}
		}
	
	public void  valueChanged(ListSelectionEvent e){
		 	
	 	oldF = jbtn.getFont();
	 	jbtn.setFont(new Font(oldF.getName(), 		oldF.getStyle(),Integer.parseInt((String)((JList)e.getSource()).getSelectedValue())));													
		}
	}