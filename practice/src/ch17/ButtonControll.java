package ch17;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ButtonControll {
	@FXML private Label lb1;
	
	public void btn1Ctrl(ActionEvent e){
		
		lb1.setText("hahahah");
	}
}
