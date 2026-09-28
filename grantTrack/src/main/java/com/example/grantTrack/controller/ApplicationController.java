package com.example.grantTrack.controller;

import com.example.grantTrack.entity.Application;
import com.example.grantTrack.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/add/{facultyId}/{stageId}")
    public Application submitApplication(
            @RequestBody Application application,
            @PathVariable Integer facultyId,
            @PathVariable Integer stageId) {

        return applicationService.submitApplication(application, facultyId, stageId);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/find/faculty/{facultyId}")
    public List<Application> getFacultyApplications(@PathVariable Integer facultyId) {
        return applicationService.getFacultyApplications(facultyId);
    }

    @PutMapping("/edit/{applicationId}/stage/{stageId}")
    public Application updateStage(
            @PathVariable Integer applicationId,
            @PathVariable Integer stageId) {

        return applicationService.updateStage(applicationId, stageId);
    }

    @DeleteMapping("/del/{id}")
    public String deleteApplication(@PathVariable Integer id) {
        applicationService.deleteApplication(id);
        return "Application deleted successfully";
    }
}