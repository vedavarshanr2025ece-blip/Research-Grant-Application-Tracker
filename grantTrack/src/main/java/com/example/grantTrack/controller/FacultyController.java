package com.example.grantTrack.controller;

import com.example.grantTrack.entity.Faculty;
import com.example.grantTrack.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "*")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/register")
    public Faculty register(@RequestBody Faculty faculty) {
        return facultyService.registerFaculty(faculty);
    }

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping("/find/{id}")
    public Faculty getFaculty(@PathVariable Integer id) {
        return facultyService.getFacultyById(id);
    }
    @PutMapping("/edit/{id}")
    public Faculty updateFaculty(@PathVariable Integer id,
                                 @RequestBody Faculty faculty){
        return facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/del/{id}")
    public String deleteFaculty(@PathVariable Integer id) {
        facultyService.deleteFaculty(id);
        return "Faculty deleted successfully";
    }
}