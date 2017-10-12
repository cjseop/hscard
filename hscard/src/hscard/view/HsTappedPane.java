package hscard.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import hscard.bean.HsNameIma;
import hscard.util.HsUtil;

public class HsTappedPane extends JTabbedPane {
	//Instance
	private JPanel[] jpanel;
	private JLabel[] cardImageLabel;
	private final String[] jobTitle = {"ドルイド","ハンター","メイジー","パラディン",
									   "プリースト","ローグ","シャーマン",
									   "ウォーロック","ウォリアー","中立"};
	private String iconName = "icon_class_";
	private JPopupMenu popup;
	private JMenuItem[] popItem;
	private final String[] popupTitle = {"カード情報詳細","カード情報変更","カード情報削除"};
	
	private List<HsNameIma> searchList;
	
	//Constructor
	public HsTappedPane() {
		setCompose();
		setEvent();
	}
	
	//Method
	public List<HsNameIma> getSearchList() {
		return searchList;
	}
	
	public void setSearchList(List<HsNameIma> searchList) {
		this.searchList = searchList;
	}

	public void setCompose(){
		searchList = new ArrayList<HsNameIma>();
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
				jpanel[i] = new JPanel();
				jpanel[i].setLayout(new GridLayout(2, 5, 0, 30));
				jpanel[i].setBorder(BorderFactory.createEmptyBorder(0, 0,50, 0));
				jpanel[i].setBackground(Color.darkGray);
				this.addTab("", imc, jpanel[i], jobTitle[i]);
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
	
	public void drawImage(){
		jpanel[this.getSelectedIndex()].removeAll();
		for (int i = 0; i < searchList.size(); i++) {
			ImageIcon cardImg = HsUtil.resizeImage(searchList.get(i).getImage(), 270, 300);
			cardImageLabel[i] = new JLabel(cardImg);
			jpanel[this.getSelectedIndex()].add(cardImageLabel[i]);
			cardImageLabel[i].addMouseListener(new MyMouseEvent());
		}
		for (int i = 0; i < cardImageLabel.length - searchList.size(); i++) {
			cardImageLabel[i] = new JLabel("");
			jpanel[this.getSelectedIndex()].add(cardImageLabel[i]);
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
				DetailCardDialog detailCard = new DetailCardDialog();
				break;
			case "1" :
				ChangeCardDialog changeCard = new ChangeCardDialog();
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






