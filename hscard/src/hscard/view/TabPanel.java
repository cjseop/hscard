package hscard.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import hscard.controller.SearchCardController;
import hscard.util.HsPaging;
import hscard.util.HsUtil;

public class TabPanel extends JPanel{
		//Instance
		private HsTappedPane hsTap;
		private JButton insertBtn;
		private JButton preBtn;
		private JButton nexBtn;
		private JComboBox combo;
		private String[] cardPackName = {"全部","基本","クラシック","ナクスラーマスの呪い","ゴブリンvsノーム","ブラックロックマウンテン","グランド・トーナメント"
										 ,"リーグ・オブ・エクスプローラー","旧神のささやき","ワン・ナイト・イン・カラザン","仁義なきガジェッツァン","大魔境ウンゴロ","凍てつく玉座の騎士団", "栄誉の殿堂"};
		private HsPaging paging;
		
		/*
		  	0 全部
		  	1 基本
		  	2 クラシック
		  	3 ナクスラーマスの呪い
		 	4 ゴブリンvsノーム
		 	5 ブラックロックマウンテン
		  	6 グランド・トーナメント
			7 リーグ・オブ・エクスプローラー
			8 旧神のささやき
			9 ワン・ナイト・イン・カラザン
			10 仁義なきガジェッツァン
			11 大魔境ウンゴロ
			12 凍てつく玉座の騎士団
			13 栄誉の殿堂
		 */
		
		private JRadioButton[] radio;
		private ButtonGroup btnGroup;
		
		private JTextField searchField;
		private JButton searchBtn;
		private boolean flag = true;
		private String sel1;
		private String sel2;
		private JRadioButton checkFalse;
		
		private int searchCost = -1;
		
		//Constructor
		public TabPanel() {
			setComponent();	
			setEvent();
		}
		
		//Method
		public void setComponent(){
			paging = new HsPaging();
			setLayout(null);
			hsTap = new HsTappedPane();
			hsTap.setBounds(10, 10, 1180, 730);
				ImageIcon btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\insertBtn.jpg", 95, 35);
				insertBtn = new JButton(btnImg);
				insertBtn.setBounds(1000, 12, 90, 35);
				
				btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\preBtnIcon.png", 30, 30);
				preBtn = new JButton(btnImg);
				preBtn.setBounds(5, 355, 30, 30);
				
				btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\nextBtnIcon.png", 30, 30);
				nexBtn = new JButton(btnImg);
				nexBtn.setBounds(1165, 355, 30, 30);
				
				combo = new JComboBox<String>(cardPackName);
				combo.setBounds(90, 690, 230, 30);
				searchField = new JTextField();
				searchField.setBounds(800, 690, 170, 30);
				btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\serachIcon.png", 30, 30);
				searchBtn = new JButton(btnImg);
				searchBtn.setBounds(980, 690, 30, 30);
				radio = new JRadioButton[8];
				btnGroup =  new ButtonGroup();
				for (int i = 0; i < radio.length; i++) {
					ImageIcon radioImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\" + i + ".png", 35, 35);
					radio[i] = new JRadioButton(radioImg);
					radio[i].setName(i+"");
					radio[i].setBounds((i * 45) + 360, 685, 40, 40);
					radio[i].setBackground(Color.darkGray);
					btnGroup.add(radio[i]);
					add(radio[i]);
				}
				checkFalse = new JRadioButton();
				btnGroup.add(checkFalse);
				
				add(searchField);
				add(searchBtn);
				add(combo);
				add(preBtn);
				add(nexBtn);
				add(insertBtn);
				add(hsTap);
				
				getSearchList();
				hsTap.drawImage();
		}
		
		public void setEvent(){
			for (int i = 0; i < radio.length; i++) {
				radio[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JRadioButton who = (JRadioButton)e.getSource();
						if(flag){
							sel1 = who.getName();
							flag = false;
						}else{
							sel2 = who.getName();
							flag = true;
						}
						if(sel1.equals(sel2)){
							checkFalse.setSelected(true);
							sel1="";
							sel2="";
						}
						if(checkFalse.isSelected()){
							searchCost = Integer.valueOf("-1");
							getSearchList();
							reDrawTab();
						}
						for (int j = 0; j < radio.length; j++) {
								if(radio[j].isSelected()){
									searchCost = Integer.valueOf(radio[j].getName());
									paging.setSelectPage(1);
									getSearchList();
									reDrawTab();
									ImageIcon chgradioImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\c" + j + ".png", 35, 35);
									radio[j].setIcon(chgradioImg);
								}else{
									ImageIcon chgradioImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\" + j + ".png", 35, 35);
									radio[j].setIcon(chgradioImg);
								}
						}
					}
				});
			}
			
			insertBtn.addActionListener(
				e -> {
						InsertCardDialog insertDialog = new InsertCardDialog();
						getSearchList();
						reDrawTab();
					 });
			combo.addActionListener(
				e -> {
					paging.setSelectPage(1);
					getSearchList();
					reDrawTab();
					});
			searchBtn.addActionListener(
				e -> {
					paging.setSelectPage(1);
					getSearchList();
					reDrawTab();
					});
			hsTap.addChangeListener(
				e -> {
					paging.setSelectPage(1);
					getSearchList();
					reDrawTab();
	 	    		});
			searchField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					paging.setSelectPage(1);
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
						getSearchList();
						reDrawTab();
					}
					if(searchField.getText().length() == 0){
						getSearchList();
						reDrawTab();
					}
					super.keyReleased(e);
				}
			});
			preBtn.addActionListener(
				e -> {
					paging.setSelectPage(paging.getSelectPage() - 1);
					getSearchList();
					reDrawTab();
	 	    		});
			nexBtn.addActionListener(
				e -> {
					paging.setSelectPage(paging.getSelectPage() + 1);
					getSearchList();
					reDrawTab();
		 	   		});
			
	  }//setEvent Method end
		
		public void getSearchList(){
			paging.getTotalPage(hsTap.getSelectedIndex(), searchCost, combo.getSelectedIndex(), searchField.getText());
			if(paging.getSelectPage() == 1){
				preBtn.setVisible(false);
			}else{
				preBtn.setVisible(true);
			}
			if(paging.getTotalPage() == paging.getSelectPage()){
				nexBtn.setVisible(false);
				paging.setSelectPage(paging.getTotalPage());
			}else{
				nexBtn.setVisible(true);
			}
			SearchCardController searchCardCon = new SearchCardController();
			hsTap.setSearchList(searchCardCon.getNameImagebySearch(hsTap.getSelectedIndex(), searchCost, combo.getSelectedIndex(), searchField.getText(), paging.getSelectPage()));
		}
		
		public void reDrawTab(){
			hsTap.drawImage();
			SwingUtilities.updateComponentTreeUI(hsTap);
			hsTap.setUI(new BasicTabbedPaneUI() {
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
		}
}

