package com.example.exo1_tp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

// extension de la classe Application pour créer une application JavaFX
public class exo1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Méthode d’initialisation de la scène
    public void start(Stage primaryStage) {
        // définition de la fenêtre (taille, et titre)
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Fenêtre JavaFX");

        // définition d’un conteneur VBox qui arrange les sous-composants sur une seule colonne.
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // définition d’un texte
        Text text = new Text("Exemple de Code Java pur");
        text.setFill(Color.BROWN);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        // Ajout du texte dans le conteneur vbox
        vbox.setMargin(text, new Insets(20, 50, 20, 50));
        vbox.getChildren().addAll(text);

        //Ajout d'une zone de saisie avec TextField
        TextField textfield = new TextField("Zone de saisie");
        vbox.getChildren().add(textfield);

        //Hbox pour aligner horizontalement les boutons
        HBox hbox = new HBox();
        vbox.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);

        //Il faut sppécifier un groupe de boutons
        ToggleGroup group = new ToggleGroup();

        //Bouton JavaFx
        RadioButton button1 = new RadioButton("JavaFX");
        button1.setToggleGroup(group);
        hbox.getChildren().add(button1);

        //Bouton Swing
        RadioButton button2 = new RadioButton("Swing");
        button2.setToggleGroup(group);
        hbox.getChildren().add(button2);

        //Bouton Autre
        RadioButton button3 = new RadioButton("Autre");
        button2.setToggleGroup(group);
        hbox.getChildren().add(button3);


        // Ajout d’un bouton dans le conteneur vbox
        Button button = new Button("Compris !");
        vbox.getChildren().addAll(button);

        // spécification de la scène avec la Xbox
        primaryStage.setScene(new Scene(vbox));

        // rendre la fenêtre visible
        primaryStage.show();
    }
}
