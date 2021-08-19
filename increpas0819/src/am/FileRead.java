package am;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead extends JFrame{
	
	String path = "C:/Users/user/Desktop/테스트/Test.txt";
	
	File file = new File(path);
	
	FileInputStream fs = null;
	
	JTextArea ta = new JTextArea();
	
	public FileRead() {
		
		
		getContentPane().add(ta, BorderLayout.CENTER);
		res();
		
		this.setVisible(true);
		this.setBounds(100,100,505,495);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new FileRead();
	}
	
	void res() {
		try {
			String text ="";
			if (file.isFile()) {
				try {
					fs = new FileInputStream(file);
					byte[] encoded = new byte[2048];
					int size = -1; // end of file
					
					for (int i=0; i< encoded.length; i++) {
						if ((size = fs.read(encoded))  != -1) {
							text = new String(encoded, 0, size);
							ta.append(text);	
						}else {
							return;
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}finally {
					
					try {
						
						fs.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
