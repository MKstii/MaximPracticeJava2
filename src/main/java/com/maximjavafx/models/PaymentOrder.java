package com.maximjavafx.models;

import javafx.scene.control.ListView;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class PaymentOrder extends Document{
    private String employer;
    @Override
    public String GetDocumentName() {
        return "Платёжка";
    }

    @Override
    public void FillListView(ListView<String> listView) {
        var df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        var listViewItems = listView.getItems();
        listViewItems.clear();
        listViewItems.add("Номер: " + number);
        listViewItems.add("Дата: " + df.format(date));
        listViewItems.add("Пользователь: " + username);
        listViewItems.add("Сумма: " + sum);
        listViewItems.add("Работник: " + employer);
    }
}
