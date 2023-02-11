package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas cnvs;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		
		createDisplay();
	}
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		cnvs = new Canvas();
		cnvs.setPreferredSize(new Dimension(width, height));
		cnvs.setMaximumSize(new Dimension(width, height));
		cnvs.setMinimumSize(new Dimension(width, height));
		cnvs.setBackground(Color.DARK_GRAY);
		cnvs.setFocusable(false);
		
		frame.add(cnvs);
		frame.pack();
	}
	public Canvas getCanvas() {
		return cnvs;
	}
	public JFrame getFrame() {
		return frame;
	}
}
