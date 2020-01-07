package lab_6_2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller2 {
	@FXML
	private TextField input;
	@FXML
	private TextField output;
	
	String Input;
	String Output;
	public void countLetters(ActionEvent event) {
		Input = input.getText();
		int num = Input.length();
		output.setText(Integer.toString(num));
	}
	
	public void reverseLetters(ActionEvent event) {
		Input = input.getText();
		Output = "";
		for(int i = Input.length()-1; i>=0; i--) {
			Output = Output+Input.charAt(i);
		}
		output.setText(Output);
		
	}
	
	public void removeDuplicates(ActionEvent event) {
		Input = input.getText();
		Set<Character> chrSet = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<Input.length(); i++) {
			Character c = Input.charAt(i);
			chrSet.add(c);
		}
		
		for(Character c: chrSet) {
			sb.append(c);
		}
		output.setText(sb.toString());
	}
}
