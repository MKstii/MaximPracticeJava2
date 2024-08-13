package com.maximjavafx.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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
}
