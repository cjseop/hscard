package hscard.view;

import java.awt.Graphics;
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import hscard.bean.Hscard;
import hscard.bean.HscardValue;
import hscard.controller.InsertCardController;
import hscard.controller.SearchCardController;
import hscard.controller.UpdateCardController;
import hscard.util.HsUtil;

public class ChangeCardDialog extends JDialog {
	// Instance
	private JLabel label[];
	private String[] labelName = { "カード名", "費用", "レアリティ", "クラス", "タイプ", "セット", "効果", "説明", "イメージ" };

	private JComboBox<String> Rcombo;
	private JComboBox<String> Ccombo;
	private JComboBox<String> Tcombo;
	private JComboBox<String> Scombo;

	private String[] RcomboItem = { "フリー", "コモン", "レア", "エピック", "レジェン" };
	private String[] CcomboItem = { "ドルイド", "ハンター", "メイジー", "パラディン", "プリースト", "ローグ", "シャーマン", "ウォーロック", "ウォリアー", "中立" };
	private String[] TcomboItem = { "ミニオン", "呪文", "武器", "ヒーロー" };
	private String[] ScomboItem = { "基本", "クラシック", "ナクスラーマスの呪い", "ゴブリンvsノーム", "ブラックロックマウンテン", "グランド・トーナメント",
			"リーグ・オブ・エクスプローラー", "旧神のささやき", "ワン・ナイト・イン・カラザン", "仁義なきガジェッツァン", "大魔境ウンゴロ", "凍てつく玉座の騎士団", "栄誉の殿堂" };

	private JTextArea effect;
	private JTextArea content;
	private JScrollPane effectScroll;
	private JScrollPane contentScroll;
	private JTextField cardName;
	private JTextField cost;

	private JFileChooser openImage;
	private JButton imageOpenBtn;
	private JTextField imagePath;

	private JButton confirmBtn;
	
	private String selectedCardName;
	
	private String selectedImg;
	private String updatedImg;
	private String oldImg;
	

	public String getOldImg() {
		return oldImg;
	}

	public void setOldImg(String oldImg) {
		this.oldImg = oldImg;
	}

	// Constructor
	public ChangeCardDialog(String selectedCardName) {
		this.selectedCardName = selectedCardName;
		setLayout(null);
		setSize(400, 620);
		setTitle("カード情報変更");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setCompose();
		setEvent();
		getUpdateData();
		setVisible(true);
	}

	// Method
	
	public void setCompose() {
		ImageIcon background = HsUtil
				.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\modalBackIcon.jpg", 400, 620);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		panel.setLayout(null);
		setContentPane(panel);
		label = new JLabel[9];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(labelName[i]);
			if (i == 7) {
				label[i].setBounds(30, 60 + (i * 50), 100, 30);
			} else if (i == 8) {
				label[i].setBounds(30, 90 + (i * 50), 100, 30);
			} else {
				label[i].setBounds(30, 30 + (i * 50), 100, 30);
			}
			add(label[i]);
		}

		cardName = new JTextField();
		cardName.setBounds(120, 30, 200, 30);
		cardName.setEnabled(false);
		add(cardName);

		cost = new JTextField();
		cost.setBounds(120, 80, 100, 30);
		add(cost);

		Rcombo = new JComboBox<>(RcomboItem);
		Rcombo.setBounds(120, 130, 150, 30);
		Ccombo = new JComboBox<>(CcomboItem);
		Ccombo.setBounds(120, 180, 150, 30);
		Tcombo = new JComboBox<>(TcomboItem);
		Tcombo.setBounds(120, 230, 150, 30);
		Scombo = new JComboBox<>(ScomboItem);
		Scombo.setBounds(120, 280, 220, 30);
		add(Rcombo);
		add(Ccombo);
		add(Tcombo);
		add(Scombo);

		effect = new JTextArea();
		effect.setLineWrap(true);
		effectScroll = new JScrollPane(effect);
		effectScroll.setBounds(120, 330, 220, 65);
		add(effectScroll);

		content = new JTextArea();
		content.setLineWrap(true);
		contentScroll = new JScrollPane(content);
		contentScroll.setBounds(120, 410, 220, 65);
		add(contentScroll);

		ImageIcon openIcon = HsUtil
				.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\fileOpenIcon.png", 30, 30);
		imageOpenBtn = new JButton(openIcon);
		imageOpenBtn.setBounds(120, 490, 30, 30);
		add(imageOpenBtn);
		imagePath = new JTextField();
		imagePath.setBounds(160, 490, 180, 30);
		imagePath.setEnabled(false);
		add(imagePath);

		confirmBtn = new JButton("変更");
		confirmBtn.setBounds(165, 540, 70, 30);
		add(confirmBtn);
	}

	public String getUpdatedImg() {
		return updatedImg;
	}

	public void setUpdatedImg(String updatedImg) {
		this.updatedImg = updatedImg;
	}

	public void setEvent() {
		imageOpenBtn.addActionListener(e -> {
			openImage = new JFileChooser();
			int reVal = openImage.showOpenDialog(ChangeCardDialog.this);
			if (reVal == JFileChooser.APPROVE_OPTION) {
				File file = openImage.getSelectedFile();
				imagePath.setText(file.toString());
			}
		});
		confirmBtn.addActionListener(e -> {
			if (vaildCheck()) {
				Hscard cardBean = new Hscard();
				String savedImg = imagePath.getText();
				cardBean.setCardName(cardName.getText());
				cardBean.setCardSet(Scombo.getSelectedIndex());
				cardBean.setContent(content.getText());
				cardBean.setCost(Integer.parseInt(cost.getText()));
				cardBean.setEffect(effect.getText());
				cardBean.setGrade(Rcombo.getSelectedIndex());
				cardBean.setJob(Ccombo.getSelectedIndex());
				cardBean.setKind(Tcombo.getSelectedIndex());
				try {
					File imageFile = openImage.getSelectedFile();
					String saveImgPath = HsUtil.saveImageFile(imageFile);
					cardBean.setImage(saveImgPath);
					updatedImg = cardBean.getImage();
					oldImg = selectedImg;
					File deleteFile = new File(selectedImg);
					deleteFile.delete();
				} catch (NullPointerException e2) {
					cardBean.setImage(imagePath.getText());
				}
				UpdateCardController updateCardCon = new UpdateCardController();
				updateCardCon.updateCard(cardBean);
				this.dispose();
				JOptionPane.showMessageDialog(null, "カード情報が変更されました。");
			}
		});
	}

	public void getUpdateData() {
			SearchCardController searchCardCon = new SearchCardController();
			HscardValue bean = searchCardCon.getCardByCardName(selectedCardName);
			cardName.setText(bean.getCardName());
			cost.setText(String.valueOf(bean.getCost()));
			effect.setText(bean.getEffect());
			content.setText(bean.getContent());
			Rcombo.setSelectedIndex(Integer.parseInt(bean.getGrade()));
			Ccombo.setSelectedIndex(Integer.parseInt(bean.getJob()));
			Tcombo.setSelectedIndex(Integer.parseInt(bean.getKind()));
			Scombo.setSelectedIndex(Integer.parseInt(bean.getCardSet()));
			imagePath.setText(bean.getImage());
			selectedImg = bean.getImage();
	}

	public boolean vaildCheck() {
		try {
			if (cost.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "費用を入力してください。", "error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			int intCost = Integer.parseInt(cost.getText());
			if (intCost < 0 || intCost > 99) {
				JOptionPane.showMessageDialog(null, "0 ~ 99範囲内入力してください。", "error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数字のみ入力してください。", "error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (effect.getText().length() > 100) {
			JOptionPane.showMessageDialog(null, "100桁内で入力してください。", "error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (content.getText().length() > 150) {
			JOptionPane.showMessageDialog(null, "150桁内で入力してください。", "error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (imagePath.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "カードイメージをアップロードしてください。", "error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!(imagePath.getText().equals(""))) {
			StringTokenizer stz = new StringTokenizer(imagePath.getText(), ".");
			String suffix = "";
			while (stz.hasMoreTokens()) {
				suffix = stz.nextToken();
			}

			suffix = "." + suffix;
			// System.out.println(suffix);
			String[] correctSuffix = { ".gif", ".jpg", ".png" };
			int checksuffix = 0;
			for (int i = 0; i < correctSuffix.length; i++) {
				if (suffix.equalsIgnoreCase(correctSuffix[i])) {
					checksuffix = 1;
				}
			}

			if (checksuffix == 0) {
				JOptionPane.showMessageDialog(null, "拡張字が'.gif' '.jpg', '.png'のファイルアのみップロードできます。", "error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
}
