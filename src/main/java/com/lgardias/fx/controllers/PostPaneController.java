package com.lgardias.fx.controllers;

import com.lgardias.fx.communication.ApacheClient;
import com.lgardias.fx.model.Book;
import com.lgardias.fx.model.ChoiceBoxProperties;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PostPaneController implements Initializable {

    private ChoiceBoxProperties choiceBoxPropertiesc = new ChoiceBoxProperties();

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
        configureChoiceBox();
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

    private void configureChoiceBox() {
        borrowedChoiceBox.setValue(choiceBoxPropertiesc.getFalseValuePP());
        borrowedChoiceBox.setItems(FXCollections.observableArrayList(choiceBoxPropertiesc.getFalseValuePP(), choiceBoxPropertiesc.getTrueValuePP()));
    }

    private String borrowedConverter(String value) {
        if (value.equals(choiceBoxPropertiesc.getFalseValuePP())) {
            return "false";
        } else {
            return "true";
        }
    }
}
