package com.maximjavafx.Controller;

import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.Services.FormFactory;
import com.maximjavafx.TextFormatFilter.NumberFilter;
import com.maximjavafx.models.Invoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InvoiceController implements Initializable {
    @FXML
    private TextField count_field;

    @FXML
    private TextField currency_field;

    @FXML
    private DatePicker datepicker_field;

    @FXML
    private TextField exchangeRate_field;

    @FXML
    private TextField number_field;

    @FXML
    private TextField product_field;

    @FXML
    private TextField sum_field;

    @FXML
    private TextField user_field;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var doubleFilter = new NumberFilter();
        var intFilter = new NumberFilter();
        intFilter.setPatternIsInteger();
        sum_field.setTextFormatter(new TextFormatter<>(doubleFilter));
        count_field.setTextFormatter(new TextFormatter<>(intFilter));
        exchangeRate_field.setTextFormatter(new TextFormatter<>(doubleFilter));
    }

    @FXML
    private void add(ActionEvent e){
        var invoice = new Invoice();
        invoice.setNumber(sum_field.getText());
        invoice.setCount(Integer.parseInt(count_field.getText()));
        invoice.setSum(Double.parseDouble(sum_field.getText()));
        invoice.setCurrency(currency_field.getText());
        invoice.setDate(datepicker_field.getValue());
        invoice.setUsername(user_field.getText());
        invoice.setProduct(product_field.getText());
        invoice.setExchangeRate(Double.parseDouble(exchangeRate_field.getText()));
        var docsRep = DocsRepository.getInstance();
        docsRep.addDoc(invoice);

        close();
    }

    @FXML
    private void cancel(ActionEvent e){
        close();
    }

    private void close(){
        var stage = (Stage)btn_cancel.getScene().getWindow();
        stage.close();
    }

}
