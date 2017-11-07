package com.lgardias.fx.controllers;

import com.lgardias.fx.communication.ApacheClient;
import com.lgardias.fx.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PostPaneController implements Initializable{

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private ChoiceBox<String> borrowedChoiceBox;

    @FXML
    private Button postButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        borrowedChoiceBox.setValue("Na stanie");
        borrowedChoiceBox.setItems(FXCollections.observableArrayList("Na stanie","Wypożyczona"));

        configureButton();
    }

    private void configureButton() {

        postButton.setOnAction(event -> {
            Book book = new Book();
            book.setTitle(titleTextField.getText());
            book.setAuthor(authorTextField.getText());
            book.setBorrowed(borrowedConverter(borrowedChoiceBox.getValue()));
            System.out.println(book);

            ApacheClient apacheClient = new ApacheClient();
            apacheClient.createBook(book);

        });
    }

    private String borrowedConverter(String value){
        String result;
        if (value.equals("Na stanie")){
            return result = "false";
        }else{
            return result = "true";
        }
    }
}
