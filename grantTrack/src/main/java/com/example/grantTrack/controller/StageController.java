package com.example.grantTrack.controller;

import com.example.grantTrack.entity.Stage;
import com.example.grantTrack.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stage")
@CrossOrigin(origins = "*")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @PostMapping("/add")
    public Stage addStage(@RequestBody Stage stage) {
        return stageService.addStage(stage);
    }

    @GetMapping
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("/find/{id}")
    public Stage getStage(@PathVariable Integer id) {
        return stageService.getStageById(id);
    }
}