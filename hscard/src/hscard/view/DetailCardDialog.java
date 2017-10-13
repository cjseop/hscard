package hscard.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hscard.bean.HscardValue;
import hscard.controller.SearchCardController;
import hscard.util.HsUtil;

public class DetailCardDialog extends JDialog {
	// Instance
	private JLabel cardDetailImg;
	private JTextArea cardContent;
	private String selectedCardName;
	private JScrollPane contentScroll;

	// Constructor
	public DetailCardDialog(String selectedCardName) {
		this.selectedCardName = selectedCardName;
		setLayout(null);
		setSize(500, 300);
		setTitle("カード情報詳細");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setCompose();
		setVisible(true);
	}

	// Method
	public void setCompose() {
		ImageIcon background = HsUtil
				.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\detailBackIcon.jpg", 500, 300);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		panel.setLayout(null);
		setContentPane(panel);
		cardDetailImg = new JLabel();
		cardDetailImg.setBounds(1, 1, 240, 280);
		add(cardDetailImg);
		cardContent = new JTextArea();
		cardContent.setLineWrap(true);
		cardContent.setEditable(false);
		cardContent.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		cardContent.setForeground(Color.GRAY);
		contentScroll = new JScrollPane(cardContent);
		contentScroll.setBounds(235, 20, 230, 230);
		add(contentScroll);
		getUpdateData();
	}

	public void getUpdateData() {
		SearchCardController searchCardCon = new SearchCardController();
		HscardValue bean = searchCardCon.getCardByCardName(selectedCardName);
		cardContent.setText(bean.getContent());
		ImageIcon cardImg = HsUtil.resizeImage(bean.getImage(),
				240, 280);
		cardDetailImg.setIcon(cardImg);
	}
}
