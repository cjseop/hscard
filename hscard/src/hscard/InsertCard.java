package hscard;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class InsertCard extends JDialog {
	//Instance
	private JLabel label[];
	private String[] labelName = {"カード名","費用","レアリティ", "クラス", "タイプ", "効果", "説明", "セット", "イメージ"};
	
	private JComboBox<String> Rcombo;
	private JComboBox<String> Ccombo;
	private JComboBox<String> Tcombo;
	private JComboBox<String> Scombo;
	
	private String[] RcomboItem = {};
	private String[] CcomboItem = {};
	private String[] TcomboItem = {};
	private String[] ScomboItem = {};
	
	private JTextArea effect;
	private JTextArea content;
	
	private JFileChooser fileOpener;
	
	private JButton confirmBtn;
	
	//Constructor
	public InsertCard() {
		setLayout(null);
		setSize(400, 800);
		setTitle("カード情報登録");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setCompose();
		setVisible(true);
	}
	
	//Method
	public void setCompose(){
		
	}
}
