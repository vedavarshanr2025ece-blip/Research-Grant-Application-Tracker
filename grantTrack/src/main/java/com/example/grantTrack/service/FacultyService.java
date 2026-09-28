package com.example.grantTrack.service;

import com.example.grantTrack.entity.Faculty;
import com.example.grantTrack.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // Register Faculty
    public Faculty registerFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Get All Faculty
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // Get Faculty by ID
    public Faculty getFacultyById(Integer id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    // Delete Faculty
    public void deleteFaculty(Integer id) {
        facultyRepository.deleteById(id);
    }

    public Faculty updateFaculty(Integer id, Faculty updatedFaculty){

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        faculty.setName(updatedFaculty.getName());
        faculty.setEmail(updatedFaculty.getEmail());
        faculty.setDepartment(updatedFaculty.getDepartment());
        faculty.setDesignation(updatedFaculty.getDesignation());
        faculty.setPassword(updatedFaculty.getPassword());
        faculty.setRole(updatedFaculty.getRole());

        return facultyRepository.save(faculty);
    }
}