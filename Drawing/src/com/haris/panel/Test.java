package com.haris.panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import com.haris.shapes.Line;
import com.haris.shapes.Shape;


public class Test extends JPanel{
	Point startPoint,endPoint,final_point;
	ArrayList<Shape> shapes;
	int start=0,drag=0;
	public Test() {
		startPoint=endPoint=null;
		addMouseMotionListener(new MyListener());
		addMouseListener(new MyListener());
		shapes=new ArrayList<Shape>();
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		if(drag==1){
			arg0.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			draw_all(arg0);
		}
		else{
			draw_all(arg0);
		}
		//arg0.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

	}
	
	private void draw_all(Graphics arg0){
		for(Shape s:shapes)
		{
			//arg0.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			s.draw(arg0);
			System.out.println("loop");
		}
	}
	
	
	private class MyListener extends MouseInputAdapter{

		@Override
		public void mouseDragged(MouseEvent e) {
			if(start==0){
				drag=1;
				start++;
				startPoint=e.getPoint();
			}
			else{
				endPoint=e.getPoint();
			}
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			final_point=arg0.getPoint();
			Line line=new Line(startPoint.x, startPoint.y,final_point.x,final_point.y);
			shapes.add(line);
			System.out.println("released");
			start=0;
			drag=0;
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
