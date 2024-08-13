package com.maximjavafx.Services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.URL;

//TODO: баг, если через отмену закрыть форму, то instance не меняется. Либо отказаться, либо пофиксить
public class FormFactory {
    private Stage instance;

    public Stage CreateForm(URL viewPath, String formName) throws IOException {
        if(instance == null){
            Parent root = FXMLLoader.load(viewPath);
            var scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(formName);

            stage.setOnCloseRequest(event -> {
                // TODO: думаю что лучше: убивать полностью окно или очищать поля?
                // вернемся позже
                instance = null;
            });

            instance = stage;
        }
        return instance;
    }
}
