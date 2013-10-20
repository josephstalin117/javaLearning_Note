import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.swing.event.*;

public class TestJCheckbox extends JApplet implements ItemListener,ListSelectionListener{
	JButton jbtn;
	JCheckBox jc;
	JComboBox jcb;  //awt.Choice
	JList j1;
	String[] slist = {"18","24","30",};
	Font oldF;
	
	public void init(){
		
		Container
		jbtn = new JButton("效果");
		jc = new JCheckBox("blue");
		jcb = new JComboBox();
		jl = new JList(slist);
		jcb = new JComboBox();  //组合框
		
		jcb.addItem("plain");
		jcb.addItem("italic");
		jcb.addItem("bold");
		
		
		Container c = this.getContentPane();
		
		c.setLayout(new FlowLayout());  //变成新的浮动流
		c.add(jbtn);
		c.add(jc);
		c.add(jcb);
		c.add(jl);
		
		jc.addItemListener(this);
		jcb.addItemLisetener(this);
		jl.addListSelectionListener(this);
		
		
		
	}

	public void itemStateChanged(ItemEvent e){
		
		JComboBox temp;
		oldF = jbtn;
		
		if(e.getItemSelectable() instanceof JCommboBox){
			if((JCheckBox)e.getItemSelectable().isSelected()){
				jbtn.setBackground(Color.blue);
			}
		}
		if(e.getItemSelectable() instanceof JCheckBox){
			temp = (JComboBox)e.getItemSelectable();
			if(temp.getSelectedItem() == "plain"){
				jbtn.setFont(new Font(oldF.getName(),Font.PLAIN,oldF.getSize()));
			}
			if(temp.getSelectedItem() == "italic"){
				jbtn.setFont(new Font(oldF.getName(),Font.ITALIC,oldF.getSize()));
			}
			if(temp.getSelectedItem()=="bold")
				jbtn.setFont(new Font(oldF.getName(),Font.BOLD,oldF.getSize()));
			}
		}
	}
	public void valueChanged(ListSelectionEvent e){
		oldF = jbtn.getFont();
		jbtn.setFont(new Font(oldF.getName(),oldF.getStyle(),Integer.parseInt((String)((JList)e.getSource()).getSelectedValue())));
	}
}