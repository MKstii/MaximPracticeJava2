package com.maximjavafx;

import com.maximjavafx.CellFactory.CheckboxCellFactory;
import com.maximjavafx.models.Document;
import com.maximjavafx.models.Invoice;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    //@FXML
    //private ListView<Document> listview_docs;

    @FXML
    private TableView<Document> tableView_docs;

    @FXML
    private TableColumn<Document, CheckBox> column_checkbox;

    @FXML
    private TableColumn<Document, String> column_docs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Document[] docs = new Document[50];

        Invoice invoice = new Invoice("A27", Calendar.getInstance().getTime(), "МИШУ", 2.3,
                "Рубль", 2.2, "Бананы", 3);

        for (int i = 0; i < 50; i++) {
            docs[i] = invoice;
        }

        column_checkbox.setCellFactory(new CheckboxCellFactory());
        column_docs.setCellValueFactory(aa -> {
            return new SimpleStringProperty(aa.getValue().toString());
        });

        tableView_docs.getItems().addAll(docs);
    }
}
