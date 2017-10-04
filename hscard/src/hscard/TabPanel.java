package hscard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TabPanel extends JPanel{
	//Instance
		private HsTappedPane hsTap;
		private JButton insertBtn;
		private JButton preBtn;
		private JButton nexBtn;
		
		public TabPanel() {
			setComponent();		
		}
		
		
		public void setComponent(){
			setLayout(null);
			hsTap = new HsTappedPane();
			hsTap.setBounds(10, 10, 1180, 730);
			try {
				BufferedImage imgBuffer = ImageIO.read(new File("C:\\Users\\KISSCO-PC82\\workspace\\hscard\\src\\images\\insertBtn.jpg"));
				Image resizeImg = imgBuffer.getScaledInstance(95, 28, Image.SCALE_SMOOTH);
				ImageIcon cardImg = new ImageIcon(resizeImg);
				insertBtn = new JButton(cardImg);
				insertBtn.setBounds(1000, 15, 80, 30);
				preBtn = new JButton("P");
				preBtn.setBounds(35, 350, 30, 30);
				nexBtn = new JButton("N");
				nexBtn.setBounds(1135, 350, 30, 30);
				add(preBtn);
				add(nexBtn);
				add(insertBtn);
				add(hsTap);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		
}
