//<html><body><applet code = "TestAdapter.class" width = 300 height = 300></applet></body></html>

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestAdapter extends Applet implements MouseMotionListener
{  
  public void init()
  {
    this.addMouseListener(new MyAdapter());
    this.addMouseMotionListener(this);
  }  
  
  public void mouseMoved(MouseEvent e)
  {
    showStatus("您移动了鼠标，新位置在("+e.getX()+","+e.getY()+")。");
  }
  public void mouseDragged(MouseEvent e)
  {
    showStatus("您拖动了鼠标。");
  }
  
  class MyAdapter extends MouseAdapter
{
	public void mouseClicked(MouseEvent e)
  {
    if(e.getClickCount()==1)
         showStatus("您在("+e.getX()+","+e.getY()+")单击了鼠标左键。");
    else if(e.getClickCount()==2)
         showStatus("您在("+e.getX()+","+e.getY()+")双击了鼠标。");
  }
  
	}
}


