package hscard;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	//Instance
	private TabPanel tp;
	
	//constructor
	public Main(String title) throws IOException {		
		ImageIcon backgroundImage = HsUtil.resizeImage("C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\images\\Back2.jpg", 1400, 900);
		setContentPane(new JLabel(backgroundImage));
		tp = new TabPanel();
		tp.setBounds(100, 50, 1200, 750);
		setTitle(title);
		setSize(1400, 900);
		setLayout(null);
		add(tp);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	//main method
	public static void main(String[] args) throws IOException {
		Main main = new Main("HS_Card");
	}//end main

}//end class
