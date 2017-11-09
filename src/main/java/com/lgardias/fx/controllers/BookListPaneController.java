package com.lgardias.fx.controllers;

import com.lgardias.fx.model.BookProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BookListPaneController implements Initializable{

    @FXML
    private TableView<BookProperty> bookTableViev;

    @FXML
    private TableColumn<BookProperty, String> titleColumn;

    @FXML
    private TableColumn<BookProperty, String> authorColumn;

    @FXML
    private TableColumn<BookProperty, String> borrowedColumn;

    public TableColumn<BookProperty, String> getAuthorColumn() {
        return authorColumn;
    }

    public TableColumn<BookProperty, String> getBorrowedColumn() {
        return borrowedColumn;
    }

    public TableColumn<BookProperty, String> getTitleColumn() {
        return titleColumn;
    }

    public TableView<BookProperty> getBookTableViev() {
        return bookTableViev;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
