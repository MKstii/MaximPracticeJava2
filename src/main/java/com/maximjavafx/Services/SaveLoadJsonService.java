package com.maximjavafx.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.maximjavafx.Repository.DocsRepository;
import com.maximjavafx.models.Document;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveLoadJsonService implements SaveLoadService{
    private final ObjectMapper objectMapper;

    public SaveLoadJsonService() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    // Очень странно себя ведет Jackson при попытке сохранения массива. Просто не сохраняет тип.
    // Надо придумать что-то получше
    public void Save(List<Document> docs, String saveFilePath) throws IOException {
        StringBuilder jsonSB = new StringBuilder("[ ");
        for(var doc: docs){
            jsonSB.append(objectMapper.writeValueAsString(doc)).append(",");
        }
        jsonSB.deleteCharAt(jsonSB.length()-1);
        jsonSB.append("]");
        var fileW = new FileWriter(saveFilePath);
        fileW.write(jsonSB.toString());
        fileW.close();
    }

    public void Load(String filePath) throws IOException {
        try {
            List<Document> loadedDocuments = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });
            var docsRepos = DocsRepository.getInstance();
            docsRepos.addAll(loadedDocuments);
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Некорректный файл");
            alert.setContentText("Содержание файла некорректно");
            alert.showAndWait();
        }

    }
}
