package hscard;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
	private JPopupMenu popup;
	private JMenuItem[] popItem;
	private final String[] popupTitle = {"カード情報詳細","カード変更","カード情報削除"};
	
	//Constructor
	public HsTappedPane() {
		setCompose();
		setEvent();
	}
	
	//Method
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
			
			popup = new JPopupMenu();
			popItem = new JMenuItem[3];
			for (int i = 0; i < popItem.length; i++) {
				popItem[i] = new JMenuItem(popupTitle[i]);
				popItem[i].setName(i+"");
				popup.add(popItem[i]);
			}

	}
	
	public void setEvent(){
		for (int i = 0; i < popItem.length; i++) {
			popItem[i].addActionListener(new MyActionEvent());
		}
	}
	
	//Innerclass MouseEvent
	class MyMouseEvent extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3){
				popup.show((Component)e.getSource(), e.getX(), e.getY());
			}
		}
	}//end Innerclass MouseEvent
	
	//Innseclass menu actionEvent
	class MyActionEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			switch(item.getName()){
			case "0" :
				DetailCard detailCard = new DetailCard();
				break;
			case "1" :
				ChangeCard changeCard = new ChangeCard();
				break;
			case "2" :
				int messageAnswer = JOptionPane.showConfirmDialog(null, "このカードを削除しますか？", "警告", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(messageAnswer == 0){
					//write delete event code
				}
			}
		}
	}//end Innseclass menu actionEvent
}






