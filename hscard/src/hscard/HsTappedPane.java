package hscard;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;


public class HsTappedPane extends JTabbedPane {
	//Instance
	private JPanel[] jpanel;
	private JLabel[] lb;
	private final String[] jobTitle = {"ウォリアー", "ドルイド","ハンター","メイジー","パラディン",
									   "プリースト","ローグ","シャーマン",
									   "ウォーロック","共通"};
	private String iconName = "icon_class_";
	
	//Constructor
	public HsTappedPane() {
		setCompose();
	}
	
	public void setCompose(){
		this.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect,
					Rectangle textRect) {
				rects[tabIndex].height = 45;
		        rects[tabIndex].width = 45;
		        for (int i = 0; i < rects.length; i++) {
					rects[i].x = 50 * i;
				}
				super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
			}
		});
		
		jpanel = new JPanel[10];
		lb = new JLabel[10];
		try {
			for (int i = 0; i < jpanel.length; i++) {
				BufferedImage imgBuffer = ImageIO.read(new File("C:\\Users\\KISSCO-PC82\\workspace\\hscard\\src\\images\\"+iconName + (i + 1) +".gif"));
				Image resizeImg = imgBuffer.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				ImageIcon imc = new ImageIcon(resizeImg);
				
				imgBuffer = ImageIO.read(new File("C:\\Users\\KISSCO-PC82\\workspace\\hscard\\src\\images\\sample" + ((i + 1) % 3) + ".jpg"));
				resizeImg = imgBuffer.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
				ImageIcon cardImg = new ImageIcon(resizeImg);
				jpanel[i] = new JPanel();
				this.addTab("", imc, jpanel[i], jobTitle[i]);
				for (int j = 0; j < jpanel.length; j++) {
					lb[j] = new JLabel(cardImg);
					jpanel[i].add(lb[j]);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setEvent(){
		
	}

}
