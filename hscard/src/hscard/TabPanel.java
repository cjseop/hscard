package hscard;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class TabPanel extends JPanel{
		//Instance
		private HsTappedPane hsTap;
		private JButton insertBtn;
		private JButton preBtn;
		private JButton nexBtn;
		private JComboBox combo;
		private String[] cardPackName = {"基本","クラシック","ナクスラーマスの呪い","ゴブリンvsノーム","ブラックロックマウンテン","グランド・トーナメント"
										 ,"リーグ・オブ・エクスプローラー","旧神のささやき","ワン・ナイト・イン・カラザン","仁義なきガジェッツァン","大魔境ウンゴロ","凍てつく玉座の騎士団"};
		private JRadioButton[] radio;
		private ButtonGroup btnGroup;
		
		private JTextField searchField;
		private JButton searchBtn;
		private boolean flag = true;
		private String sel1;
		private String sel2;
		private JRadioButton checkFalse;
		
		//Constructor
		public TabPanel() {
			setComponent();	
			setEvent();
		}
		
		//Method
		public void setComponent(){
			setLayout(null);
			hsTap = new HsTappedPane();
			hsTap.setBounds(10, 10, 1180, 730);
				ImageIcon btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\insertBtn.jpg", 95, 35);
				insertBtn = new JButton(btnImg);
				insertBtn.setBounds(1000, 12, 90, 35);
				
				btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\preBtnIcon.png", 30, 30);
				preBtn = new JButton(btnImg);
				preBtn.setBounds(35, 350, 30, 30);
				
				btnImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\nextBtnIcon.png", 30, 30);
				nexBtn = new JButton(btnImg);
				nexBtn.setBounds(1135, 350, 30, 30);
				
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
					
					btnGroup.add(radio[i]);
					add(radio[i]);
				}
				checkFalse = new JRadioButton();
				checkFalse.setName("-1");
				btnGroup.add(checkFalse);
				
				add(searchField);
				add(searchBtn);
				add(combo);
				add(preBtn);
				add(nexBtn);
				add(insertBtn);
				add(hsTap);
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
						for (int j = 0; j < radio.length; j++) {
								if(radio[j].isSelected()){
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
						InsertCard insertDialog = new InsertCard();
					 });
	  }

		
}


