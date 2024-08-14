package com.maximjavafx.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maximjavafx.models.Document;

import java.io.IOException;
import java.util.List;

public interface SaveLoadService {
    public void Save(List<Document> docs, String saveFilePath) throws IOException;
    public void Load(String filePath) throws IOException;
}
