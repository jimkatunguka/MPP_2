package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import persistance.entities.Book;
import persistance.entities.BookCopy;
import persistance.entities.Member;
import persistance.entities.MemberCheckoutRecord;
import persistance.repository.BookRepository;
import persistance.repository.MemberCheckoutRecordRepository;
import persistance.repository.MemberRepository;

public class LibrarianPageController {
	@FXML
	private ComboBox<BookCopy> bookCopySelectBox;
	private ObservableList<BookCopy> bookCopySelectBoxData = FXCollections.observableArrayList();
	@FXML
	private ComboBox<Member> memberSelectBox;
	private ObservableList<Member> memberSelectBoxData = FXCollections.observableArrayList();
	@FXML
	private DatePicker returnDateField;
	@FXML
	private Button checkoutButton;
	@FXML
	private Button libLogoutButton;
	
	@FXML
	private Tab viewRecordsTab;
	@FXML
	private Button showAllBtn;	
	@FXML
	private Button showOverDueBtn;
	@FXML
	private TableView<MemberCheckoutRecord> checkoutRecordsTable;
	@FXML
	private TableColumn<MemberCheckoutRecord,String> bookColumn;
	@FXML
	private TableColumn<MemberCheckoutRecord,String> memberColumn;
	@FXML
	private TableColumn<MemberCheckoutRecord,String> checkoutDateColumn;
	@FXML
	private TableColumn<MemberCheckoutRecord,String> dueDateColumn;
	@FXML
	private TableColumn<MemberCheckoutRecord,Boolean> statusColumn;
	private ObservableList<MemberCheckoutRecord> checkoutRecords = FXCollections.observableArrayList();
	
	@FXML
    private void initialize() {		
    }
	
	public void loadPage() {
		// populate data
		populateBookCopySelectorData();
		populateMemberSelectorData();
		// initialise drop downs
		bookCopySelectBox.setItems(bookCopySelectBoxData);
		memberSelectBox.setItems(memberSelectBoxData);
		// define rendering for drop downs
		defineRenderingForBookCopySelectBox();
		defineRenderingForMemberSelectBox();
		//add button handlers
		checkoutButton.setOnAction(event -> {
			handleCheckoutButtonClick();
		});
		libLogoutButton.setOnAction(e -> {
			handleLogOutButton();
		});
		viewRecordsTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
			checkoutRecords.removeAll(checkoutRecords);
			populateMemberCheckoutRecordsTable();
        });
		
		populateMemberCheckoutRecordsTable();
		initialiseTableView();
	}
	
	private void populateMemberCheckoutRecordsTable()
	{
		MemberCheckoutRecordRepository.getRecords().entrySet().stream().forEach(entry -> {
			MemberCheckoutRecord record = entry.getValue();
			String bkIsbn = record.getBookIsbn();
			BookCopy bkCopy = record.getBookCopy();			
			Book bk = BookRepository.get(bkIsbn);
			bkCopy.setBook(bk);			
			record.setBookCopy(bkCopy);
			record.setMember(MemberRepository.get(record.getMemberId()));
			checkoutRecords.add(entry.getValue());
		});
	}
	
	FilteredList<MemberCheckoutRecord> filteredData;
	
	private void initialiseTableView()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Set values for the columns
		bookColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBookCopy().getId()+" : "+ cell.getValue().getBookCopy().getBook().getTitle()));
		memberColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMemberName()));
		checkoutDateColumn.setCellValueFactory(cell -> new SimpleStringProperty(sdf.format(cell.getValue().getCheckoutDate())));
		dueDateColumn.setCellValueFactory(cell -> new SimpleStringProperty(sdf.format(cell.getValue().getReturnDate())));
		statusColumn.setCellValueFactory(cell -> new SimpleBooleanProperty(cell.getValue().isDue()));
		
        	filteredData = new FilteredList<>(checkoutRecords, p -> true);
        
        showOverDueBtn.setOnAction(event -> {
        	showOverDueBtnHandler();
        });
        showAllBtn.setOnAction(event -> {  
        	checkoutRecords.removeAll(checkoutRecords);
        	populateMemberCheckoutRecordsTable();
        	filteredData.setPredicate(p -> true);
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<MemberCheckoutRecord> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(checkoutRecordsTable.comparatorProperty());
        
     // 5. Add sorted (and filtered) data to the table.
        checkoutRecordsTable.setItems(sortedData);
        
        
	}
	
	public void showOverDueBtnHandler(){
		checkoutRecords.removeAll(checkoutRecords);
		populateMemberCheckoutRecordsTable();
		filteredData.setPredicate(MemberCheckoutRecord::isDue);
	}
	
	private void populateBookCopySelectorData()
	{		
		BookRepository.getRepository().entrySet().stream().forEach(entry -> {
			Book bk = entry.getValue();
			if(bk.getNumberOfAvailableCopies() > 0)
			{
				for(BookCopy bkCpy : bk.getCopies().values())
				{
					if(bkCpy.isAvailable())
					{
						System.out.println("Copy : "+bkCpy.getId()+" availability : "+bkCpy.getBook().getIsbn());
						bookCopySelectBoxData.add(bkCpy);
					}
				}
			}
		});
	}
	
	private void populateMemberSelectorData()
	{
		MemberRepository.getRepository().entrySet().stream().forEach(entry -> {
			memberSelectBoxData.add(entry.getValue());
		});
	}

	private void handleCheckoutButtonClick()
	{
		BookCopy selectedBookCopy = bookCopySelectBox.getValue();
		Member selectedMember = memberSelectBox.getValue();
		LocalDate returnDate = returnDateField.getValue();
		MemberCheckoutRecordRepository.create(selectedBookCopy, selectedMember, new Date(), java.sql.Date.valueOf(returnDate));
		updateBookRepository(selectedBookCopy);
		refreshForm();
	}
	
	private void refreshForm()
	{
		bookCopySelectBoxData.removeAll(bookCopySelectBoxData);
		populateBookCopySelectorData();
		bookCopySelectBox.setValue(null);
		memberSelectBox.setValue(null);
		returnDateField.setValue(null);
	}
	
	private void updateBookRepository(BookCopy selectedBookCopy)
	{
		Book bk = BookRepository.get(selectedBookCopy.getBook().getIsbn());
		BookCopy bkCopy = bk.getCopies().get(selectedBookCopy.getId());
		bkCopy.setIsAvailable(false);
		bk.updateBookCopy(bkCopy);
		BookRepository.update(bk);
	}
	
	private void defineRenderingForMemberSelectBox()
	{
		memberSelectBox.setCellFactory((selectBox) -> {
			return new ListCell<Member>() {
				@Override
				protected void updateItem(Member item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item.getFirstName()+ " "+item.getLastName());
		            }
		        }
			};
		});
		memberSelectBox.setConverter(new StringConverter<Member>() {
		    @Override
		    public String toString(Member member) {
		        if (member == null) {
		            return null;
		        } else {
		            return member.getFirstName()+ " "+member.getLastName();
		        }
		    }

		    @Override
		    public Member fromString(String personString) {
		        return null; // No conversion fromString needed.
		    }
		});	
	}
	
	private void defineRenderingForBookCopySelectBox()
	{
		bookCopySelectBox.setCellFactory((selectBox) -> {
			return new ListCell<BookCopy>() {
				@Override
				protected void updateItem(BookCopy item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item.getId() + " : " + item.getBook().getTitle());
		            }
		        }
			};
		});
		bookCopySelectBox.setConverter(new StringConverter<BookCopy>() {
		    @Override
		    public String toString(BookCopy item) {
		        if (item == null) {
		            return null;
		        } else {
		        	return item.getId() + " : " + item.getBook().getTitle();
		        }
		    }

		    @Override
		    public BookCopy fromString(String personString) {
		        return null; // No conversion fromString needed.
		    }
		});		
	}

	private void handleLogOutButton()
	{
		try
		{
			Stage stage = (Stage)libLogoutButton.getScene().getWindow();
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
}
