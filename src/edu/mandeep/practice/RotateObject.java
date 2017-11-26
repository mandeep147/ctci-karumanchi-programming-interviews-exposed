/**
 * 
 */
package edu.mandeep.practice;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mandeep
 *
 */
public class RotateObject extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	
	/**
	 * 
	 */
	public RotateObject() {
		super();
		image = Toolkit.getDefaultToolkit().getImage("image.jpg");
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(170, 0);
		g2d.rotate(1);
		g2d.drawImage(image, 0, 0, 200, 200, this);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Rotate Image");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		
		RotateObject panel1 = new RotateObject();
		frame.setContentPane(panel1);
		frame.setVisible(true);
	}
}