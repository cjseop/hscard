package ch17;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		VBox root = new VBox();
//		root.setPrefWidth(350);
//		root.setPrefHeight(150);
//		root.setAlignment(Pos.CENTER);
//		root.setSpacing(20);
//		
//		Label lable = new Label();
//		lable.setText("Hello, JavaFX");
//		lable.setFont(new Font(50));
//		
//		Button btn = new Button();
//		btn.setText("confirm");
//		btn.setOnAction(e -> Platform.exit());
//		
//		root.getChildren().add(lable);
//		root.getChildren().add(btn);
		
		Parent root = FXMLLoader.load(getClass().getResource("sam01.fxml"));
		Scene scene = new Scene(root);
		//scene.setRoot(root);
		primaryStage.setTitle("Test01");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}


}
