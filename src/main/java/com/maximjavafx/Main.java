package com.maximjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL location = getClass().getResource("/Main.fxml");
        System.out.println("HERE");
        System.out.println(location);
        //assert location != null;
        Parent root = FXMLLoader.load(location);
        //var root = new Group();
        var scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(900);
        stage.setMinWidth(900);
        stage.setHeight(700);
        stage.setMinHeight(700);
        stage.show();
    }
}