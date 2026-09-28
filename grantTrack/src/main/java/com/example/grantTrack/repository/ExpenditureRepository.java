package com.example.grantTrack.repository;

import com.example.grantTrack.entity.Application;
import com.example.grantTrack.entity.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Integer> {

    List<Expenditure> findByApplication(Application application);

}