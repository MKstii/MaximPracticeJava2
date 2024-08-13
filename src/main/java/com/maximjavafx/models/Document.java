package com.maximjavafx.models;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public abstract class Document {
    protected String number;
    protected LocalDate date;
    protected String username;
    protected Double sum;

    @Override
    public String toString(){
        var df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return GetDocumentName() + " от " + df.format(date) + " номер " + number;
    }

    public abstract String GetDocumentName();
}
