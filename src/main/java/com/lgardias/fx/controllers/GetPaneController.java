package com.lgardias.fx.controllers;

import com.lgardias.fx.communication.ApacheClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GetPaneController implements Initializable{

    @FXML
    private ChoiceBox<?> getPropertyChoiceBox;

    @FXML
    private Button getButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configureButton();
    }

    private void configureButton() {
        getButton.setOnAction(event ->{
            ApacheClient apacheClient = new ApacheClient();
            apacheClient.getBooks();
        });
    }
}
