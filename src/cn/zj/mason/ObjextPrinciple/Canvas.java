package cn.zj.mason.ObjextPrinciple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.java2d.pipe.ShapeSpanIterator;

public class Canvas extends JPanel {
	private int todoAction;
	private Rectangle scope;
	private ArrayList<Shape> shapes;
	private JList<String> layers;

	public void setLayers(JList<String> layers) {
		this.layers = layers;
	}

	public void setTodoAction(int todoAction) {
		this.todoAction = todoAction;
	}

	public Canvas() {
		shapes = new ArrayList<Shape>();
		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
	}

	public void paintShape(Shape s) {
		// 需要一个队列，把需要画的图形加到这个队列
		shapes.add(s);

		String[] strings = new String[shapes.size()];
		int i = 0;
		for (Shape shape : shapes) {
			strings[i++] = shape.toString();

		}
		layers.setListData(strings);
		repaint();

	}

	private MouseInputListener mouseHandler = new MouseInputAdapter() {

		java.awt.Point startPoint;

		@Override
		public void mousePressed(MouseEvent e) {
			// 确定起始点
			startPoint = e.getPoint();
			scope = new Rectangle();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			if (todoAction == 100) {
				Moving m = shapes.get(layers.getSelectedIndex());
				m.move(e.getPoint().x, e.getPoint().y);
				
				// 消除矩形框
				scope = null;
				repaint();
				
			} else {

				// 需要一个队列，把需要画的图形加到这个队列
				setScope(startPoint, e.getPoint());

				if (scope.width > 0 || scope.height > 0) {

					if (todoAction == 0) {

						MyLine line = new MyLine();
						line.setShape(scope.x, scope.y, scope.width, scope.height, 0, "line");
						paintShape(line);

					} else if (todoAction == 1) {
						MyRectangle rectangle = new MyRectangle();
						rectangle.setShape(scope.x, scope.y, scope.width, scope.height, 1, "rectangle");
						paintShape(rectangle);
					}
					 else if (todoAction == 2) {
							MyCycle cycle = new MyCycle();
							cycle.setShape(scope.x, scope.y, scope.width, scope.height, 2, "cycle");
							paintShape(cycle);
						}
					

					// 消除矩形框

					scope = null;
					repaint();
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// 不断改变矩形框,固定范围
			if (scope != null) {
				setScope(startPoint, e.getPoint());
			}

			repaint();
		}

		private void setScope(java.awt.Point startPoint, java.awt.Point endPoint) {

			int x = Math.min(startPoint.x, endPoint.x);
			int y = Math.min(startPoint.y, endPoint.y);
			int w = Math.abs(startPoint.x - endPoint.x);
			int h = Math.abs(startPoint.y - endPoint.y);
			scope.setBounds(x, y, w, h);
		}
	};

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		if (scope != null)
			g.drawRect(scope.x, scope.y, scope.width, scope.height);

		// 遍历这个队列，调用每个元素的drawingshape（）
		for (Drawing d : shapes) {
			d.drawingshape(g);
		}
	}

}
