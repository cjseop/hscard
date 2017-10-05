package hscard;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JLabel[] cardImageLabel;
	private final String[] jobTitle = {"ウォリアー", "ドルイド","ハンター","メイジー","パラディン",
									   "プリースト","ローグ","シャーマン",
									   "ウォーロック","共通"};
	private String iconName = "icon_class_";
	
	//Constructor
	public HsTappedPane() {
		setCompose();
		setEvent();
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
		cardImageLabel = new JLabel[10];
		
			for (int i = 0; i < jpanel.length; i++) {
				ImageIcon imc = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\"+iconName + (i + 1) +".gif", 40, 40);
				ImageIcon cardImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\sample" + ((i + 1) % 3) + ".jpg", 200, 300);
				jpanel[i] = new JPanel();
				this.addTab("", imc, jpanel[i], jobTitle[i]);
				for (int j = 0; j < jpanel.length; j++) {
					cardImageLabel[j] = new JLabel(cardImg);
					jpanel[i].add(cardImageLabel[j]);
					cardImageLabel[j].addMouseListener(new MyMouseEvent());
					
				}
			}
	}
	
	public void setEvent(){
		
	}
	
	//Innerclass MouseEvent
	class MyMouseEvent extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3){
				
			}
		}
	}
}
