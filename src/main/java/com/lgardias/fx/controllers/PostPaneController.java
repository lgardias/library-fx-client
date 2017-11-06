package com.lgardias.fx.controllers;

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
    private TextField AuthorTextField;

    @FXML
    private ChoiceBox<?> borrowedChoiceBox;

    @FXML
    private Button postButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
