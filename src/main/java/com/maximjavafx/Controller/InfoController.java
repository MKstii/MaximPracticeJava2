package com.maximjavafx.Controller;

import com.maximjavafx.models.Document;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.print.Doc;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoController {
    @FXML
    private Button btn_ok;

    @FXML
    private ListView<String> list_view;

    @FXML
    private void ok(ActionEvent event) {
        close();
    }

    private void close(){
        list_view.getItems().clear();
        var stage = (Stage)btn_ok.getScene().getWindow();
        stage.close();
    }

    public void loadDocument(Document document){
        document.FillListView(list_view);
    }
}
