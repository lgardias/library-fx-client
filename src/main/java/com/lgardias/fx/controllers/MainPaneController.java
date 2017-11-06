package com.lgardias.fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

    @FXML
    private GetPaneController getPaneController;

    @FXML
    private PostPaneController postPaneController;

    @FXML
    private BookListPaneController bookListPaneController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
