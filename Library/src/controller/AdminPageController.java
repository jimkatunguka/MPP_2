package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import persistance.entities.Book;
import persistance.entities.Member;
import persistance.repository.AdminRepository;
import persistance.repository.BookRepository;
import persistance.repository.MemberRepository;

public class AdminPageController {
	@FXML
	private TextField memberFirstNameTextField;
	@FXML
	private TextField memberLastNameTextField;
	@FXML
	private TextField memberPhoneNumberTextField;
	@FXML
	private Button createNewMemberBtn;
	
	@FXML
	private TextField bookTitleTextField;
	@FXML
	private TextField bookAuthorFirstNameTextField;
	@FXML
	private TextField bookAuthorLastNameTextField;
	@FXML
	private TextField bookAuthorIsbnTextField;
	@FXML
	private Button createNewBookBtn;
	
	@FXML
	private TableView<Member> membersTable;
	@FXML
	private TableColumn<Member,String> memberFirstNameColumn;
	@FXML
	private TableColumn<Member,String> memberLastNameColumn;
	@FXML
	private TableColumn<Member,String> memberPhoneNumberColumn;
	private ObservableList<Member> memberRecords = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Book> booksTable;
	@FXML
	private TableColumn<Book,String> bookIsbnColumn;
	@FXML
	private TableColumn<Book,String> bookTitleColumn;
	@FXML
	private TableColumn<Book,String> bookAuthorFirstNameColumn;
	@FXML
	private TableColumn<Book,String> bookAuthorLastNameColumn;
	@FXML
	private TableColumn<Book,String> bookTotalCopiesColumn;
	@FXML
	private TableColumn<Book,String> bookAvailableCopiesColumn;
	@FXML
	private TableColumn<Book,String> bookBorrowedCopiesColumn;
	private ObservableList<Book> bookRecords = FXCollections.observableArrayList();
	
	@FXML
	private Tab viewMembersTab;
	@FXML
	private Tab viewBooksTab;
	
	@FXML
	private ComboBox<Book> bookComboBox;
	@FXML
	private TextField bookCopyIdTextField;
	@FXML
	private Button createBookCopyBtn;
	
	@FXML
	private Button logOutBtn;
	
	public void loadPage()
	{
		clearFields();
		logOutBtn.setOnAction(e -> {
			handleLogOutButton();
		});
		createNewBookBtn.setOnAction(e -> {
			createNewBookBtnHandler();
		});
		createNewMemberBtn.setOnAction(e -> {
			createMemberBtnHandler();
		});
		viewMembersTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
			memberRecords.removeAll(memberRecords);
			populateMembersTable();
        });
		createBookCopyBtn.setOnAction(e -> createBookCopyBtnHandler());
		populateMembersTable();
		initialiseMembersTable();
		populateBooksTable();
		initialiseBooksTable();
		initialiseBookComboBox();
		viewBooksTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
			bookRecords.removeAll(bookRecords);
			populateBooksTable();
        });
	}
	
	private void createBookCopyBtnHandler()
	{
		Book book = bookComboBox.getValue();
		String bookCopyId = bookCopyIdTextField.getText();
		Boolean availability = true;
		BookRepository.get(book.getIsbn()).addBookCopy(bookCopyId,availability);
		clearBookCopyFormFields();
	}
	
	private void clearBookCopyFormFields()
	{
		bookComboBox.setValue(null);
		bookCopyIdTextField.setText("");
	}
	
	private void initialiseBookComboBox()
	{
		bookComboBox.setItems(bookRecords);
		bookComboBox.setCellFactory((selectBox) -> {
			return new ListCell<Book>() {
				@Override
				protected void updateItem(Book item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item.getTitle() + " By " + item.getAuthorFirstName()+" "+item.getAuthorLastName());
		            }
		        }
			};
		});
		bookComboBox.setConverter(new StringConverter<Book>() {
		    @Override
		    public String toString(Book book) {
		        if (book == null) {
		            return null;
		        } else {
		            return book.getTitle() + " By " + book.getAuthorFirstName()+" "+book.getAuthorLastName();
		        }
		    }

		    @Override
		    public Book fromString(String personString) {
		        return null; // No conversion fromString needed.
		    }
		});
	}
	
	private void handleLogOutButton()
	{
		try
		{
			Stage stage = (Stage)logOutBtn.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			Parent root = loader.load();
			LogInPageController c = loader.getController();
	        stage.setTitle("Lib App - Login");	        
	        stage.setScene(new Scene(root));
	        stage.show();
	        c.start();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	private void clearFields()
	{
		bookTitleTextField.clear();
		bookAuthorFirstNameTextField.clear();
		bookAuthorLastNameTextField.clear();
		bookAuthorIsbnTextField.clear();
		memberFirstNameTextField.clear();
		memberLastNameTextField.clear();
		memberPhoneNumberTextField.clear();
	}
	
	private void createMemberBtnHandler()
	{
		String firstName = memberFirstNameTextField.getText();
		String lastName = memberLastNameTextField.getText();
		String phoneNumber = memberPhoneNumberTextField.getText();
		String identifier = MemberRepository.create(firstName, lastName, phoneNumber);
		AdminRepository.addMember(new Member(identifier, firstName, lastName, phoneNumber));
		clearFields();
	}
	
	private void createNewBookBtnHandler()
	{
		String isbn = bookAuthorIsbnTextField.getText();
		String title = bookTitleTextField.getText();
		String authorFirstName = bookAuthorFirstNameTextField.getText();
		String authorLastName = bookAuthorLastNameTextField.getText();
		Book newBook = new Book(isbn,title,authorFirstName,authorLastName);
		BookRepository.createBook(newBook);
		AdminRepository.addBook(newBook);
		clearFields();
	}

	private void populateMembersTable()
	{
		MemberRepository.getRepository().entrySet().stream().forEach(entry -> {
			memberRecords.add(entry.getValue());
		});
	}
	
	private void initialiseMembersTable()
	{
		membersTable.setEditable(true);
		memberFirstNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getFirstName()));
		memberFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		memberFirstNameColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setFirstName(e.getNewValue());
			Member updatedMember = e.getTableView().getItems().get(e.getTablePosition().getRow());
			MemberRepository.update(updatedMember);
		});
		memberLastNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLastName()));
		memberLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		memberLastNameColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setLastName(e.getNewValue());
			Member updatedMember = e.getTableView().getItems().get(e.getTablePosition().getRow());
			MemberRepository.update(updatedMember);
		});
		memberPhoneNumberColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPhone()));
		memberPhoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		memberPhoneNumberColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setPhone(e.getNewValue());
			Member updatedMember = e.getTableView().getItems().get(e.getTablePosition().getRow());
			MemberRepository.update(updatedMember);
		});
		FilteredList<Member> filteredData = new FilteredList<>(memberRecords, p -> true);
		SortedList<Member> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(membersTable.comparatorProperty());
		membersTable.setItems(sortedData);
	}

	private void populateBooksTable()
	{
		BookRepository.getRepository().entrySet().stream().forEach(entry ->{
			bookRecords.add(entry.getValue());
		});
	}
	
	private void initialiseBooksTable()
	{
		booksTable.setEditable(true);
		bookIsbnColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIsbn()));
		bookTitleColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
		bookTitleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		bookTitleColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitle(e.getNewValue());
			Book updatedBook = e.getTableView().getItems().get(e.getTablePosition().getRow());
			BookRepository.update(updatedBook);
		});
		bookAuthorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		bookAuthorFirstNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAuthorFirstName()));		
		bookAuthorFirstNameColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setAuthorFirstName(e.getNewValue());
			Book updatedBook = e.getTableView().getItems().get(e.getTablePosition().getRow());
			BookRepository.update(updatedBook);
		});
		bookAuthorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		bookAuthorLastNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAuthorLastName()));
		bookAuthorLastNameColumn.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setAuthorLastName(e.getNewValue());
			Book updatedBook = e.getTableView().getItems().get(e.getTablePosition().getRow());
			BookRepository.update(updatedBook);
		});
		bookTotalCopiesColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTotalNumberOfTotalCopies().toString()));
		bookAvailableCopiesColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNumberOfAvailableCopies().toString()));
		bookBorrowedCopiesColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNumberOfBorrowedCopies().toString()));
		FilteredList<Book> filteredData = new FilteredList<>(bookRecords, p -> true);
		SortedList<Book> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(booksTable.comparatorProperty());
		booksTable.setItems(sortedData);		
	}
}
