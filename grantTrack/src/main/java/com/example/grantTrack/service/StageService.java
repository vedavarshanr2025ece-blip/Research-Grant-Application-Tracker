package com.example.grantTrack.service;

import com.example.grantTrack.entity.Stage;
import com.example.grantTrack.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    private final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    // Add Stage
    public Stage addStage(Stage stage) {
        return stageRepository.save(stage);
    }

    // Get All Stages
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    // Get Stage by ID
    public Stage getStageById(Integer id) {
        return stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage not found"));
    }
}