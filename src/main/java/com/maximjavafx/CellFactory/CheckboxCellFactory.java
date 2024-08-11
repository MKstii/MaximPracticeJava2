package com.maximjavafx.CellFactory;

import com.maximjavafx.models.Document;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.awt.*;

public class CheckboxCellFactory implements Callback<TableColumn<Document, CheckBox>, TableCell<Document, CheckBox>> {

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
}
