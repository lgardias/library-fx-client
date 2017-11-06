package com.lgardias.fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BookListPaneController implements Initializable{

    @FXML
    private TableView<?> bookTableViev;

    @FXML
    private TableColumn<?, ?> titleTableColumn;

    @FXML
    private TableColumn<?, ?> authorTableColumn;

    @FXML
    private TableColumn<?, ?> borrowedTableColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
