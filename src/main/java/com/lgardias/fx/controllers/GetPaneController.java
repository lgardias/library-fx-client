package com.lgardias.fx.controllers;

import com.lgardias.fx.communication.ApacheClient;
import com.lgardias.fx.model.ChoiceBoxProperties;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.*;

public class GetPaneController implements Initializable {

    private ChoiceBoxProperties choiceBoxProperties = new ChoiceBoxProperties();

    @FXML
    private ChoiceBox<String> getPropertyChoiceBox;

    @FXML
    private Button getButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configureChoiceBox();
    }

    public Button getGetButton() {
        return getButton;
    }

    public ChoiceBox<String> getGetPropertyChoiceBox() {
        return getPropertyChoiceBox;
    }

    private void configureChoiceBox() {
        getPropertyChoiceBox.setValue(choiceBoxProperties.getAllBooksGP());
        getPropertyChoiceBox.setItems(FXCollections.observableArrayList(choiceBoxProperties.getGProperties()));
    }

}
