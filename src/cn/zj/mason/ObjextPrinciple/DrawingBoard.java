package cn.zj.mason.ObjextPrinciple;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSplitPane;
import javax.swing.JList;

public class DrawingBoard implements ItemListener {

	private JFrame frame;
	private Canvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingBoard window = new DrawingBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void itemStateChanged(ItemEvent e) {
		JRadioButton rdButton;
		rdButton = (JRadioButton) e.getSource();// 得到对象
		if (rdButton.isSelected()) {
			if (rdButton.getText() == "Line") {
				canvas.setTodoAction(0);// 当监听到button的text为Line，浙canvas执行todoAction(0)
			} else if (rdButton.getText() == "Rectangle") {
				canvas.setTodoAction(1);// 当监听到button的text为Rectangle，浙canvas执行todoAction(1)
			} else if (rdButton.getText() == "Cycle") {
				canvas.setTodoAction(2);// 当监听到button的text为Rectangle，浙canvas执行todoAction(1)
			}else if (rdButton.getText() == "Move") {
				canvas.setTodoAction(100);// 当监听到button的text为Rectangle，浙canvas执行todoAction(1)
			}
		}
	}

	/**
	 * Create the application.
	 */
	public DrawingBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(160);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		canvas = new Canvas();
		splitPane.setRightComponent(canvas);

		JList<String> list = new JList<String>();
		splitPane.setLeftComponent(list);
		
		canvas.setLayers(list);

		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		JRadioButton rdbtnLine = new JRadioButton("Line");
		rdbtnLine.setSelected(true);
		rdbtnLine.addItemListener(this);
		toolBar.add(rdbtnLine);

		JRadioButton rdbtnRectangle = new JRadioButton("Rectangle");
		rdbtnRectangle.addItemListener(this);
		toolBar.add(rdbtnRectangle);
		
		JRadioButton rdbtnCycle = new JRadioButton("Cycle");
		rdbtnCycle.addItemListener(this);
		toolBar.add(rdbtnCycle);
		
	
		JRadioButton rdbtnMove = new JRadioButton("Move");
		rdbtnMove.addItemListener(this);
		toolBar.add(rdbtnMove);
		
		
		

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdbtnLine);
		bGroup.add(rdbtnRectangle);
		bGroup.add(rdbtnCycle);
		bGroup.add(rdbtnMove);

	}

}
