package hscard;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class DetailCard extends JDialog {
	//Instance
	private JLabel cardDetailImg;
	private JTextArea cardContent;
	
	//Constructor
	public DetailCard() {
		setLayout(null);
		setSize(500, 300);
		setTitle("カード情報詳細");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setCompose();
		setVisible(true);
	}
	
	//Method
	public void setCompose(){
		ImageIcon cardImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\sample1.jpg", 180, 230);
		cardDetailImg = new JLabel(cardImg);
		cardDetailImg.setBounds(25, 20, 180, 230);
		add(cardDetailImg);
		
		cardContent = new JTextArea();
		cardContent.setBounds(235,20,230,230);
		cardContent.setEditable(false);
		cardContent.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		cardContent.setForeground(Color.GRAY);
		cardContent.setText("asdafaasfasf\nasdafasf");
		add(cardContent);
		
	}
	
	public void setEvent(){
		
	}

}
