package hscard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	//Instance
	private TabPanel tp;
	
	//constructor
	public Main(String title) throws IOException {
	
//		JPanel jp = new JPanel(){
//			public void paintComponent(Graphics g){
//				ImageIcon backgroundImage = new ImageIcon("C:\\Users\\KISSCO-PC82\\workspace\\hscard\\src\\images\\background.jpg");
//				Image img = backgroundImage.getImage();
//				
//				AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
//				Graphics2D g2 = (Graphics2D) g;
//				g2.setComposite(ac);
//				g2.drawImage(newbackgroundImage.getImage(), 0, 0, null);
//				setOpaque(false);
//				super.paintComponent(g2);
//			}
//		};
		
		ImageIcon backgroundImage = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\background.jpg", 1400, 900);
		setContentPane(new JLabel(backgroundImage));
		tp = new TabPanel();
		tp.setBounds(100, 50, 1200, 750);
		setTitle(title);
		setSize(1400, 900);
		setLayout(null);
		add(tp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	//main method
	public static void main(String[] args) throws IOException {
		Main main = new Main("HS_Card");
	}//end main

}//end class
