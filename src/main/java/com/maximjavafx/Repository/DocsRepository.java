package com.maximjavafx.Repository;

import com.maximjavafx.models.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DocsRepository {
    private static DocsRepository instance;
    private final ObservableList<Document> docs;

    private DocsRepository() {
        docs = FXCollections.observableArrayList();
    }

    public static DocsRepository getInstance(){
        if(instance == null){
            instance = new DocsRepository();
        }
        return instance;
    }

    public ObservableList<Document> getDocs(){
        return docs;
    }

    public void addDoc(Document doc){
        docs.add(doc);
    }

    public void addAll(List<Document> documents){
        docs.addAll(documents);
    }

    public void deleteAll(List<Document> documents){
        docs.removeAll(documents);
    }
}
