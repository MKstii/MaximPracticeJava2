package com.maximjavafx.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentOrder extends Document{
    private String employer;
    @Override
    public String GetDocumentName() {
        return "Платёжка";
    }
}
