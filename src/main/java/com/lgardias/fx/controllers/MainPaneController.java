package com.lgardias.fx.controllers;

import com.lgardias.fx.communication.ApacheClient;
import com.lgardias.fx.model.Book;
import com.lgardias.fx.model.BookProperty;
import com.lgardias.fx.model.Converter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

    private Button getButton;
    private ChoiceBox<String> propoertyChoiceBox;
    private TableColumn<BookProperty, String> titleColumn;
    private TableColumn<BookProperty, String> authorColumn;
    private TableColumn<BookProperty, String> borrowedColumn;

    private TableView<BookProperty> bookListTableView;

    @FXML
    private GetPaneController getPaneController;

    @FXML
    private PostPaneController postPaneController;

    @FXML
    private BookListPaneController bookListPaneController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureChoiceBox();
        configureButton();
    }

    private void configureChoiceBox() {
        propoertyChoiceBox = getPaneController.getGetPropertyChoiceBox();
    }

    private void configureButton() {

        getButton = getPaneController.getGetButton();
        getButton.setOnAction(event ->{
            ApacheClient apacheClient = new ApacheClient();
            List<Book> books = Converter.JsonToBooks(apacheClient.getBooks(), propoertyChoiceBox.getValue());

            configureBookListPane(books);
        });
    }

    private void configureBookListPane(List<Book> books) {

        bookListTableView = bookListPaneController.getBookTableViev();
        titleColumn = bookListPaneController.getTitleColumn();
        authorColumn = bookListPaneController.getAuthorColumn();
        borrowedColumn = bookListPaneController.getBorrowedColumn();

        ObservableList<BookProperty> selectedBooks = FXCollections.observableArrayList();

        for(Book book : books){
            selectedBooks.add(new BookProperty(book));
        }

        titleColumn.setCellValueFactory(new PropertyValueFactory<BookProperty, String >("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookProperty, String>("author"));
        borrowedColumn.setCellValueFactory(new PropertyValueFactory<BookProperty, String>("borrowed"));

        bookListTableView.setItems(selectedBooks);


    }
}
