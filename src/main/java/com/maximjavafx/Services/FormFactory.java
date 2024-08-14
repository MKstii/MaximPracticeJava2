package com.maximjavafx.Services;

import com.maximjavafx.Controller.InfoController;
import com.maximjavafx.models.Document;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.URL;

public class FormFactory {
    private Stage createBaseForm(Parent root, String title, Window owner) {
        var scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(owner);
        return stage;
    }

    public Stage CreateForm(URL viewPath, String formName, Window mainWindow) throws IOException {
        Parent root = FXMLLoader.load(viewPath);
        return createBaseForm(root, formName, mainWindow);
    }

    public Stage CreateInfo(Document document, Window mainWindow) throws IOException {
        var loader = new FXMLLoader(FormUrls.INFO);
        Parent root = loader.load();

        Stage stage = createBaseForm(root, document.GetDocumentName(), mainWindow);

        InfoController controller = loader.getController();
        controller.loadDocument(document);

        return stage;
    }
}
