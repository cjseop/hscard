package hscard.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hscard.util.HsUtil;

public class DetailCardDialog extends JDialog {
	//Instance
	private JLabel cardDetailImg;
	private JTextArea cardContent;
	
	//Constructor
	public DetailCardDialog() {
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
		ImageIcon background = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\detailBackIcon.jpg", 500, 300);
		JPanel panel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		panel.setLayout(null);
		setContentPane(panel);
		ImageIcon cardImg = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\sample1.jpg", 180, 230);
		cardDetailImg = new JLabel(cardImg);
		cardDetailImg.setBounds(25, 20, 180, 230);
		add(cardDetailImg);
		
		cardContent = new JTextArea();
		cardContent.setLineWrap(true);
		cardContent.setBounds(235,20,230,230);
		cardContent.setEditable(false);
		cardContent.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		cardContent.setForeground(Color.GRAY);
		cardContent.setText("asdafaasfasfasdafasfaaaaaaaaaaaaaaaaaaa");
		add(cardContent);
		
	}
	
	public void setEvent(){
		
	}

}
