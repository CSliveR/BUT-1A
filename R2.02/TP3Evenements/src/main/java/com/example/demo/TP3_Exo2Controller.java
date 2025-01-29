package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TP3_Exo2Controller {
    @FXML
    public Label labelNom;
    @FXML
    public Label labelPrenom;
    @FXML
    public Label labelLogin;
    @FXML
    public Label labelMdP;
    @FXML
    public TextField tfNom;
    @FXML
    public TextField tfPrenom;
    @FXML
    public Label leLogin;
    @FXML
    public PasswordField pfMdP;
    @FXML
    public TextArea txtArea;
    @FXML
    public Stage stage;

    @FXML
    private void resetButtonAction(ActionEvent event) {
        tfNom.setText("");
        tfPrenom.setText("");
        leLogin.setText("");
        pfMdP.setText("");
        txtArea.setText("");
    }

    @FXML
    private void verifierButtonAction(ActionEvent event) {
        if(tfNom.getText().isEmpty()){
            labelNom.setStyle("-fx-text-fill: red;");
        }else{
            labelNom.setStyle("-fx-text-fill: black;");
        }

        if(tfPrenom.getText().isEmpty()){
            labelPrenom.setStyle("-fx-text-fill: red;");
        }
        else {
            labelPrenom.setStyle("-fx-text-fill: black;");
        }

        if(pfMdP.getText().length() < 8){
            labelMdP.setStyle("-fx-text-fill: red;");
        }
        else{
            labelMdP.setStyle("-fx-text-fill: black;");
        }
    }

    @FXML
    private void quitterButtonAction(ActionEvent event) {
        stage.close();
    }










}