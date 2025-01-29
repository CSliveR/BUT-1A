package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TP3_Exo1App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Infos");
        VBox vbox = new VBox();
        vbox.setPrefWidth(350);
        vbox.setPrefHeight(300);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 20, 20, 20));
        gridPane.setAlignment(Pos.CENTER);


        Label labelNom = new Label("Nom : ");
        Label labelPrenom = new Label("Prénom : ");
        Label labelLogin = new Label("Login : ");
        Label labelMdP = new Label("Mot de passe : ");

        TextField tfNom = new TextField();
        TextField tfPrenom = new TextField();
        Label leLogin = new Label();
        PasswordField pfMdP = new PasswordField();

        gridPane.add(labelNom, 0, 0);
        gridPane.add(labelPrenom, 0, 1);
        gridPane.add(labelLogin, 0,2);
        gridPane.add(labelMdP, 0, 3);

        gridPane.add(tfNom, 1, 0);
        gridPane.add(tfPrenom, 1, 1);
        gridPane.add(leLogin, 1, 2);
        gridPane.add(pfMdP, 1, 3);


        Button btnReset = new Button("Reset");
        Button btnVerifier = new Button("Vérifier");
        Button btnQuitter = new Button("Quitter");

        HBox hboxBoutons = new HBox();
        hboxBoutons.setSpacing(30);
        hboxBoutons.setAlignment(Pos.CENTER);
        hboxBoutons.setPadding(new Insets(0,0,20,0));
        hboxBoutons.getChildren().addAll(btnReset, btnVerifier, btnQuitter);

        TextArea taCachee = new TextArea("Passez la souris ici !");
        taCachee.setEditable(false);

        //Ajoutez vos gestionnaires d'évènements
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfNom.setText("");
                tfPrenom.setText("");
                pfMdP.setText("");
                leLogin.setLabelFor(leLogin);
            }
        });

        tfNom.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                leLogin.setText(tfNom.getText().substring(0, Math.min(tfNom.getText().length(), 7))
                        + tfPrenom.getText().substring(0,Math.min(tfPrenom.getText().length(), 1)));
            }
        });

        tfPrenom.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                leLogin.setText(tfNom.getText().substring(0, Math.min(tfNom.getText().length(), 7))
                        + tfPrenom.getText().substring(0,Math.min(tfPrenom.getText().length(), 1)));
            }
        });

        btnVerifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
        });


        btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        taCachee.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                taCachee.setText(
                        "Nom: " + tfNom.getText() + "\n" +
                        "Prenom: " + tfPrenom.getText() + "\n" +
                        "Login: " + leLogin.getText() + "\n" +
                        "Mot de passe: " + pfMdP.getText()
                );
            }
        });

        taCachee.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                taCachee.setText("Survolez cette zone :)");
            }
        });

        vbox.getChildren().addAll(gridPane, hboxBoutons, taCachee);
        vbox.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}


