package com.maximjavafx;

import com.maximjavafx.Services.FormUrls;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var loader = new FXMLLoader(FormUrls.MAIN);
        Parent root = loader.load();
        var scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Документы");
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());

        stage.show();
    }
}