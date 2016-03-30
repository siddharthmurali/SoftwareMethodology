package app;
import View.*;


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import View.LoginManager;

public class Album extends Application {

	public static void main(String[] args){
		
		launch(args);
	}
		
	public void start(Stage stage) throws IOException {
		    Scene scene = new Scene(new StackPane());
		    
		    LoginManager loginManager = new LoginManager(scene);
		    loginManager.showLoginScreen();

		    stage.setScene(scene);
		    stage.show();
	}
		
}
