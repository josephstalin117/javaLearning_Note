import java.applet.*;
import java.awt.Event.*;
import java.awt.Graphics.*;

public class TestMouse extends Applet implements MouseListener,MouseMotionListener {

	int x1, y1, x2, y2;

	public void init() {
		this.addMouseMotionListener(this);
		this.addMouseListener(new MyMouse());
		this.addKeyListener(new MyKey());
	}

	public void paint(Graphics g) {
		g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
	}

	public void mouseMoved(MouseEvent e) {
		showStatus("the mouse location is (" + e.getX() + "," + e.getY() + ")");
	}

	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.gety();
		repaint();

	}

	class MyMouse extends MouseAdapter {// MouseMotionAdapter
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
		}

	}

	class MyKey implements KeyAdapter {
		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (c == 'c' || c == 'C') {
				x1 = x2 = 0;
				y1 = y2 = 0;
				repaint();
			}
		}
	}

}