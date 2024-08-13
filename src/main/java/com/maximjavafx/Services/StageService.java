package com.maximjavafx.Services;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class StageService {
    private final List<Stage> stageList = new ArrayList<>();

    public void CloseAllStages(){
        for(Stage stage: stageList) {
            stage.close();
        }
    }

    public void CloseStage(Stage stage){
        stageList.remove(stage);
        stage.close();
    }

    public void AddStage(Stage stage){
        stageList.add(stage);
    }
}
