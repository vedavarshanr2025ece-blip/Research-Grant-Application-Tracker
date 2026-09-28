package com.example.grantTrack.repository;

import com.example.grantTrack.entity.Application;
import com.example.grantTrack.entity.Faculty;
import com.example.grantTrack.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByFaculty(Faculty faculty);

    List<Application> findByStage(Stage stage);

    List<Application> findByStatus(String status);

}