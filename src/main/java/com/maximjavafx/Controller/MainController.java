package com.maximjavafx.Controller;

import com.maximjavafx.CellFactory.CheckboxCellFactory;
import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.Services.FormFactory;
import com.maximjavafx.Services.FormUrls;
import com.maximjavafx.Services.StageService;
import com.maximjavafx.models.Document;
import com.maximjavafx.models.Invoice;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private StageService stageService;
    private FormFactory formFactory;
    @Setter
    private Stage stage;

    @FXML
    private TableView<Document> tableView_docs;

    @FXML
    private TableColumn<Document, CheckBox> column_checkbox;

    @FXML
    private TableColumn<Document, String> column_docs;

    @FXML
    private Button btn_invoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageService = new StageService();
        formFactory = new FormFactory();
        DocsRepository docsRepository = DocsRepository.getInstance();

        tableView_docs.setItems(docsRepository.getDocs());

        column_checkbox.setCellFactory(new CheckboxCellFactory());
        column_docs.setCellValueFactory(aa -> {
            return new SimpleStringProperty(aa.getValue().toString());
        });
    }

    @FXML
    private void openInvoiceForm(ActionEvent e) throws IOException {
        openForm(FormUrls.INVOICE, "Накладная");
    }

    @FXML
    private void openPaymentOrderForm(ActionEvent e) throws IOException {
        openForm(FormUrls.PAYMENT_ORDER, "Платёжка");
    }

    @FXML
    private void openPaymentRequestForm(ActionEvent e) throws IOException {
        openForm(FormUrls.PAYMENT_REQUEST, "Заявка на оплату");
    }

    public void onClose(){
        stageService.CloseAllStages();
    }

    private void openForm(URL url, String formName) throws IOException {
        var form = formFactory.CreateForm(url, formName);
        stageService.AddStage(form);
        form.show();
    }

}
