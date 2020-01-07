package lab_6_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField name;
	@FXML
	private TextField street;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField zip;
	
	String Name;
	String Street;
	String City;
	String State;
	String Zip;
	
	public void display(ActionEvent event) {
		Name = name.getText();
		Street = street.getText();
		City = city.getText();
		State = state.getText();
		Zip = zip.getText();
		
		System.out.println(Name + "\n" + Street + "\n" + City + ", " + State + " " + Zip);		
	}
}
