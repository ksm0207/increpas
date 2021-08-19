package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageDownload extends JFrame{
	
	JPanel center_panel , south_panel;
	JTextField url_text;
	JButton confirm_btn;
	
	File save_file;
	
	InputStream is;
	FileOutputStream fos;
	URL url;
	
	
	public ImageDownload() {
		
		center_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		south_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		center_panel.add(new JLabel("URL :  "));
	
		center_panel.add(url_text = new JTextField(40));
		
		this.add(center_panel); 
		
		south_panel.add(confirm_btn = new JButton("down load"));
		this.add(south_panel,BorderLayout.SOUTH);
		
		
		
		
		this.setBounds(300,200,510,180);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				
				try {
					
					if (is != null) {
						is.close();
					}
					if (fos != null ) {
						fos.close();
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
				

			}
		});
		
		confirm_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String path = "C:/Users/user/Desktop/테스트/";
				JFileChooser jfc = new JFileChooser(path);
				
				int status = jfc.showSaveDialog(ImageDownload.this);
				
				if (status == JFileChooser.APPROVE_OPTION) {
					
					save_file = jfc.getSelectedFile();
					
					try {
						
						fos = new FileOutputStream(save_file);
						
						String url_images = url_text.getText();
						
						url = new URL(url_images);
						
						is = url.openStream();
						
						byte[] buf = new byte[2048];
						int size = -1;
						
						while ((size = is.read(buf)) != -1) {
							fos.write(buf,0,size);
							fos.flush();
						}
								
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		
		new ImageDownload();
	}
	

}
