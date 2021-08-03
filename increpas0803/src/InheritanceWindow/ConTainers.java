package InheritanceWindow;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ConTainers extends Windows {

	public ConTainers() {
		initUI();
	}
	

	
	public void initUI (){
		Container content = getContentPane();
		content.setBackground(Color.WHITE);
		content.setLayout(new FlowLayout());
		setSize(1280,720);
		setVisible(true);
	
	}


}
