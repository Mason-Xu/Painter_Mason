package cn.zj.mason.ObjextPrinciple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class MyCycle extends Shape {

	@Override
	public void drawingshape(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		Ellipse2D cycle = new Ellipse2D.Double(x,y,width,height);
		((Graphics2D) g2d).draw(cycle);


	}

}
