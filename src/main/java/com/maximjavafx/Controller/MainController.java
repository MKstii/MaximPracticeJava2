package com.maximjavafx.Controller;

import com.maximjavafx.CellFactory.CheckboxCellFactory;
import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.Services.FormFactory;
import com.maximjavafx.Services.FormUrls;
import com.maximjavafx.Services.SaveLoadJsonService;
import com.maximjavafx.models.Document;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainController implements Initializable {
    private FormFactory formFactory;

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
        formFactory = new FormFactory();
        DocsRepository docsRepository = DocsRepository.getInstance();

        tableView_docs.setItems(docsRepository.getDocs());
        tableView_docs.setSelectionModel(null);

        column_checkbox.setCellFactory(new CheckboxCellFactory());
        column_docs.setCellValueFactory(aa ->
                new SimpleStringProperty(aa.getValue().toString()));
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

    @FXML
    private void viewDocument(ActionEvent e) throws IOException{
        var checkedDocs = getCheckedDocuments();
        if(checkedDocs.size() != 1){
            System.out.println("Select only 1 document");
            return;
        }
        var stage = formFactory.CreateInfo(checkedDocs.getFirst(), btn_invoice.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void deleteDocuments(){
        var checkedDocs = getCheckedDocuments();
        var docsRepos = DocsRepository.getInstance();
        docsRepos.deleteAll(checkedDocs);
    }

    @FXML
    private void saveDocuments() throws IOException {
        var checkedDocs = getCheckedDocuments();
        if(checkedDocs.isEmpty()){
            System.out.println("Не выбраны объекты");
            return;
        }
        var fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
        fileChooser.setTitle("Выберите место для сохранения");
        var selectedFile = fileChooser.showSaveDialog(btn_invoice.getScene().getWindow());

        if(selectedFile != null){
            var saveService = new SaveLoadJsonService();
            saveService.Save(checkedDocs, selectedFile.getPath());
        }
    }

    @FXML
    private void loadDocuments() throws IOException {
        var fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
        fileChooser.setTitle("Выберите файл с данными");
        var selectedFile = fileChooser.showOpenDialog(btn_invoice.getScene().getWindow());

        if(selectedFile != null){
            var saveService = new SaveLoadJsonService();
            saveService.Load(selectedFile.getPath());
        }
    }

    @FXML
    private void close() {
        Stage stage = (Stage) btn_invoice.getScene().getWindow();
        stage.close();
    }

    private void openForm(URL url, String formName) throws IOException {
        var form = formFactory.CreateForm(url, formName, btn_invoice.getScene().getWindow());
        form.showAndWait();
    }

    private List<Document> getCheckedDocuments(){
        return tableView_docs.getItems().stream()
                .filter(doc -> doc.getCheckBox().isSelected())
                .collect(Collectors.toList());
    }
}
