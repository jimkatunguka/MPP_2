package persistance.entities;

import javafx.beans.property.SimpleStringProperty;

public class User extends Person{
	private SimpleStringProperty userId = new SimpleStringProperty();
	private SimpleStringProperty password = new SimpleStringProperty();
	
	public String getUserId() {
		return userId.get();
	}
	public void setUserId(String userId) {
		this.userId.set(userId);
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
}
