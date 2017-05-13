package cn.zj.mason.ObjextPrinciple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends Shape {

	@Override
	public void drawingshape(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(x,y,width,height);
		((Graphics2D) g2d).draw(rect);
 	}

}