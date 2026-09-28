package com.example.grantTrack.service;

import com.example.grantTrack.entity.Application;
import com.example.grantTrack.entity.Faculty;
import com.example.grantTrack.entity.Stage;
import com.example.grantTrack.repository.ApplicationRepository;
import com.example.grantTrack.repository.FacultyRepository;
import com.example.grantTrack.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final FacultyRepository facultyRepository;
    private final StageRepository stageRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              FacultyRepository facultyRepository,
                              StageRepository stageRepository) {
        this.applicationRepository = applicationRepository;
        this.facultyRepository = facultyRepository;
        this.stageRepository = stageRepository;
    }

    // Submit Application
    public Application submitApplication(Application application,
                                         Integer facultyId,
                                         Integer stageId) {

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(() -> new RuntimeException("Stage not found"));

        application.setFaculty(faculty);
        application.setStage(stage);
        application.setStatus(stage.getStageName());

        return applicationRepository.save(application);
    }

    // Get All Applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get Applications of One Faculty
    public List<Application> getFacultyApplications(Integer facultyId) {

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        return applicationRepository.findByFaculty(faculty);
    }

    // Update Stage
    public Application updateStage(Integer applicationId,
                                   Integer stageId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(() -> new RuntimeException("Stage not found"));

        application.setStage(stage);
        application.setStatus(stage.getStageName());

        return applicationRepository.save(application);
    }

    // Delete Application
    public void deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
    }
}