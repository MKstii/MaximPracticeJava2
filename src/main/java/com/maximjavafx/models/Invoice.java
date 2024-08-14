package com.maximjavafx.models;

import javafx.scene.control.ListView;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class Invoice extends Document{
    private String currency;
    private Double exchangeRate;
    private String product;
    private Integer count;

    public Invoice(String number, LocalDate date, String username,
                   Double sum, String currency, Double exchangeRate,
                   String product, Integer count){
        this.number = number;
        this.date = date;
        this.username = username;
        this.sum = sum;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.product = product;
        this.count = count;
    }

    @Override
    public String GetDocumentName() {
        return "Накладная";
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
        listViewItems.add("Товар: " + product);
        listViewItems.add("Количество: " + count);
    }
}
