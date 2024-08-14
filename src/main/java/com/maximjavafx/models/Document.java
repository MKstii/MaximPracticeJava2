package com.maximjavafx.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Invoice.class, name = "invoice"),
        @JsonSubTypes.Type(value = PaymentOrder.class, name = "paymentOrder"),
        @JsonSubTypes.Type(value = PaymentRequest.class, name = "paymentRequest")
})
public abstract class Document {
    @JsonIgnore
    private CheckBox checkBox = new CheckBox();
    protected String number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate date;
    protected String username;
    protected Double sum;

    @Override
    public String toString(){
        var df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return GetDocumentName() + " от " + df.format(date) + " номер " + number;
    }

    public abstract String GetDocumentName();
    public abstract void FillListView(ListView<String> listView);
}
