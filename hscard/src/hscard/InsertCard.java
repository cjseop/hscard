package hscard;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InsertCard extends JDialog {
	//Instance
	private JLabel label[];
	private String[] labelName = {"カード名","費用","レアリティ", "クラス", "タイプ", "セット", "効果", "説明", "イメージ"};
	
	private JComboBox<String> Rcombo;
	private JComboBox<String> Ccombo;
	private JComboBox<String> Tcombo;
	private JComboBox<String> Scombo;
	
	private String[] RcomboItem = {"フリー","コモン","レア","エピック","レジェン"};
	private String[] CcomboItem = {"ウォリアー", "ドルイド","ハンター","メイジー","パラディン",
								   "プリースト","ローグ","シャーマン",
								   "ウォーロック","共通"};
	private String[] TcomboItem = {"ミニオン","呪文","武器","ヒーロー"};
	private String[] ScomboItem = {"基本","クラシック","ナクスラーマスの呪い","ゴブリンvsノーム","ブラックロックマウンテン","グランド・トーナメント"
			 ,"リーグ・オブ・エクスプローラー","旧神のささやき","ワン・ナイト・イン・カラザン","仁義なきガジェッツァン","大魔境ウンゴロ","凍てつく玉座の騎士団"};
	
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
	
	//Constructor
	public InsertCard() {
		setLayout(null);
		setSize(400, 620);
		setTitle("カード情報登録");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setCompose();
		setEvent();
		setVisible(true);
	}
	
	//Method
	public void setCompose(){
		label = new JLabel[9];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(labelName[i]);
			if(i == 7){
				label[i].setBounds(30, 60 + (i*50), 100, 30);
			}else if(i == 8){
				label[i].setBounds(30, 90 + (i*50), 100, 30);
			}else{
				label[i].setBounds(30, 30 + (i*50), 100, 30);
			}
			add(label[i]);
		}
		
		cardName = new JTextField();
		cardName.setBounds(120, 30, 200, 30);
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
		
		ImageIcon openIcon = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\fileOpenIcon.png", 30, 30);
		imageOpenBtn = new JButton(openIcon);
		imageOpenBtn.setBounds(120, 490, 30, 30);
		add(imageOpenBtn);
		imagePath = new JTextField();
		imagePath.setBounds(160, 490, 180, 30);
		imagePath.setEnabled(false);
		add(imagePath);
		
		confirmBtn = new JButton("登録");
		confirmBtn.setBounds(165, 540, 70, 30);
		add(confirmBtn);
		
	}
	
	public void setEvent(){
		imageOpenBtn.addActionListener(
		e -> {
				openImage = new JFileChooser();
				int reVal = openImage.showOpenDialog(InsertCard.this);
				if(reVal == JFileChooser.APPROVE_OPTION){
					File file = openImage.getSelectedFile();
					imagePath.setText(file.toString());
				}
			 });
	}
}
