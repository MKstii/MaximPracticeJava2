package com.maximjavafx.models;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public abstract class Document {
    protected String number;
    protected Date date;
    protected String username;
    protected Double sum;

    @Override
    public String toString(){
        var df = new SimpleDateFormat("dd.MM.yyyy");
        return GetDocumentName() + " от " + df.format(date) + " номер " + number;
    }

    public abstract String GetDocumentName();
}
