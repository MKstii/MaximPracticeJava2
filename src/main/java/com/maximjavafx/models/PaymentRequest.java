package com.maximjavafx.models;

import javafx.scene.control.ListView;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class PaymentRequest extends Document{
    private String partner;
    private String currency;
    private Double exchangeRate;
    private Double commission;

    @Override
    public String GetDocumentName() {
        return "Заявка на оплату";
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
        listViewItems.add("Валюта: " + currency);
        listViewItems.add("Курс валюты: " + exchangeRate);
        listViewItems.add("Контрагент: " + partner);
        listViewItems.add("Комиссия: " + commission);
    }
}
