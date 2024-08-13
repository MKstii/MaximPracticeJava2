package com.maximjavafx.Controller;

import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.TextFormatFilter.NumberFilter;
import com.maximjavafx.models.PaymentOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentOrderController implements Initializable {
    @FXML
    private DatePicker date_field;

    @FXML
    private TextField emplyer_field;

    @FXML
    private TextField number_field;

    @FXML
    private TextField sum_field;

    @FXML
    private TextField user_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sum_field.setTextFormatter(new TextFormatter<>(new NumberFilter()));
    }

    @FXML
    private void add(ActionEvent event) {
        var paymentOrder = new PaymentOrder();
        paymentOrder.setDate(date_field.getValue());
        paymentOrder.setNumber(number_field.getText());
        paymentOrder.setSum(Double.parseDouble(sum_field.getText()));
        paymentOrder.setEmployer(emplyer_field.getText());
        paymentOrder.setUsername(user_field.getText());
        DocsRepository.getInstance().addDoc(paymentOrder);
        close();
    }

    @FXML
    private void cancel(ActionEvent event) {
        close();
    }

    private void close(){
        var stage = (Stage)date_field.getScene().getWindow();
        stage.close();
    }

}
