package com.example.grantTrack.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stageId;

    @Column(nullable = false, length = 50)
    private String stageName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer orderNo;
}