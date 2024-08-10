package com.maximjavafx.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
}
