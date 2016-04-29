
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class Test extends JPanel  {
	Point startPoint,endPoint;
	int start=0;
	public Test() {
		startPoint=endPoint=null;
		addMouseMotionListener(new MyListener());
		addMouseListener(new MyListener());
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		/*for(Point point:p)
		{
			arg0.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		}*/
		arg0.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

	}
	
	
	private class MyListener extends MouseInputAdapter{

		@Override
		public void mouseDragged(MouseEvent e) {
			if(start==0){
				start++;
				startPoint=e.getPoint();
			}
			else
				endPoint=e.getPoint();
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			System.out.println("released");
			start=0;
		}
		
	}


	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setSize(500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new Test(),BorderLayout.CENTER);
		jf.setVisible(true);
	}

	
	
}
