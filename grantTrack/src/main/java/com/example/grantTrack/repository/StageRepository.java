package com.example.grantTrack.repository;

import com.example.grantTrack.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StageRepository extends JpaRepository<Stage, Integer> {

    Optional<Stage> findByStageName(String stageName);

}