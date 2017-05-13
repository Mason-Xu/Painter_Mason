package cn.zj.mason.ObjextPrinciple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;



public class MyLine extends Shape {

	
	public void drawingshape(Graphics g) {
		
		Graphics g2d = (Graphics2D) g;
		Line2D line = new Line2D.Double(x,y,x + width,y + height);
		((Graphics2D) g2d).draw(line);

	}

}
