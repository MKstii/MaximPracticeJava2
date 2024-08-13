package com.maximjavafx.Controller;

import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.TextFormatFilter.NumberFilter;
import com.maximjavafx.models.PaymentRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentRequestController implements Initializable{
    @FXML
    private TextField commission_field;

    @FXML
    private TextField currencyRate_field;

    @FXML
    private TextField currency_field;

    @FXML
    private DatePicker date_field;

    @FXML
    private TextField number_field;

    @FXML
    private TextField partner_field;

    @FXML
    private TextField sum_field;

    @FXML
    private TextField user_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        commission_field.setTextFormatter(new TextFormatter<>(new NumberFilter()));
        currencyRate_field.setTextFormatter(new TextFormatter<>(new NumberFilter()));
        sum_field.setTextFormatter(new TextFormatter<>(new NumberFilter()));
    }

    @FXML
    private void add(ActionEvent event) {
        var request = new PaymentRequest();
        request.setCurrency(currency_field.getText());
        request.setNumber(number_field.getText());
        request.setDate(date_field.getValue());
        request.setSum(Double.parseDouble(sum_field.getText()));
        request.setExchangeRate(Double.parseDouble(currencyRate_field.getText()));
        request.setUsername(user_field.getText());
        request.setPartner(partner_field.getText());
        request.setCommission(Double.parseDouble(commission_field.getText()));
        DocsRepository.getInstance().addDoc(request);
        close();
    }

    @FXML
    private void cancel(ActionEvent event) {
        close();
    }

    private void close(){
        var stage = (Stage)commission_field.getScene().getWindow();
        stage.close();
    }
}
