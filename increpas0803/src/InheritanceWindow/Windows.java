package InheritanceWindow;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Windows extends JFrame{
	
	public Windows () {
		
		setTitle("MyFirstSwingApp");
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
