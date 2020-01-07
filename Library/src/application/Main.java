package application;
	
import controller.LogInPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			Parent root = loader.load();
			LogInPageController c = loader.getController();
	        primaryStage.setTitle("Lib App - Login");	        
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	        c.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
