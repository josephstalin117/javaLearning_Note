import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;

public class AppleInput extends Applet{
	TextField tf;
	int i;
	
	public void init(){
		i=Integer.parseInt(getParameter("lenth"));
		tf=new TextField(i);
		add(tf);
	}
}