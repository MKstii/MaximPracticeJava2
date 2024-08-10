package com.maximjavafx;

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
        Invoice invoice = new Invoice("A27", Calendar.getInstance().getTime(), "МИШУ", 2.3,
                "Рубль", 2.2, "Бананы", 3);

        column_checkbox.setCellFactory(new Callback<TableColumn<Document, CheckBox>, TableCell<Document, CheckBox>>() {
            @Override
            public TableCell<Document, CheckBox> call(TableColumn<Document, CheckBox> param) {
                return new TableCell<Document, CheckBox>() {
                    private final CheckBox checkBox = new CheckBox();

                    @Override
                    protected void updateItem(CheckBox item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(checkBox);
                        }
                    }
                };
            }
        });
        column_docs.setCellValueFactory(aa -> {
            return new SimpleStringProperty(aa.getValue().toString());
        });

        tableView_docs.getItems().add(invoice);
    }
}
