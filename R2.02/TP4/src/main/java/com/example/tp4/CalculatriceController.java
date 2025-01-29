package com.example.tp4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatriceController {
    @FXML
    private TextField tfCalc;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btnEt;
    @FXML
    private Button btnOu;
    @FXML
    private Button btnEgal;
    private Calculatrice calculatrice = new Calculatrice();

    @FXML
    public void onBtn0Clicked(){
        tfCalc.setText(tfCalc.getText() + " 0 ");
        calculatrice.setOperande(0);
    }
    @FXML
    public void onBtn1Clicked(){
        tfCalc.setText(tfCalc.getText() + " 1 ");
        calculatrice.setOperande(1);
    }
    @FXML
    public void onBtnOuClicked(){
        tfCalc.setText(tfCalc.getText() + " ou ");
        calculatrice.setOperation("ou");
    }
    @FXML
    public void onBtnEtClicked(){
        tfCalc.setText(tfCalc.getText() + " et ");
        calculatrice.setOperation("et");
    }
    @FXML
    public void onBtnEgalClicked(){
        tfCalc.setText(tfCalc.getText() + " = " + calculatrice.getResultat());
    }

}
