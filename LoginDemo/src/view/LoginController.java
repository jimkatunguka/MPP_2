package view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Text resultMsg;

	@FXML
	private void handleLoginBtn() {

		String username = usernameField.getText();
		String password = passwordField.getText();

		if ("Tina".equals(username) && "123".equals(password)) {
			resultMsg.setText("Login Successfully!");
		} else {
			resultMsg.setText("Login Failed");
		}

	}

	@FXML
	private void handleUserNameKeyPressed() {

		String username = usernameField.getText();
		// do something with it ??
	}
}
