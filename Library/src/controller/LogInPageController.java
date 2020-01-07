package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInPageController{
	@FXML
    private TextField usernameField;
	@FXML
	private PasswordField passwordField;
    @FXML
    private Button logInButton;
     
    @FXML
    private void initialize() {
    	
    }       
    
    private void onPressLogInBtn()
    {
    	if(usernameField.getText().equalsIgnoreCase("librarian") && passwordField.getText().equalsIgnoreCase("password"))
    	{
    		try
        	{
        		Stage stage = (Stage)logInButton.getScene().getWindow();
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Librarian.fxml"));
        		Parent root = loader.load();
        		LibrarianPageController c = loader.getController();
        		stage.setTitle("Librarian View");	        
        		stage.setScene(new Scene(root));
        		stage.show();
                c.loadPage();
        	}
        	catch(Exception exc)
        	{
        		exc.printStackTrace();
        	}
    	}
    	else if(usernameField.getText().equalsIgnoreCase("admin") && passwordField.getText().equalsIgnoreCase("password"))
    	{
    		try
        	{
        		Stage stage = (Stage)logInButton.getScene().getWindow();
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Admin.fxml"));
        		Parent root = loader.load();
        		AdminPageController c = loader.getController();
        		stage.setTitle("Admin View");	        
        		stage.setScene(new Scene(root));
        		stage.show();
                c.loadPage();
        	}
        	catch(Exception exc)
        	{
        		exc.printStackTrace();
        	}
    	}
    }
    
    public void start()
    {
    	usernameField.setText("");
        passwordField.setText("");
        logInButton.setOnAction(event -> onPressLogInBtn());
    }
}
