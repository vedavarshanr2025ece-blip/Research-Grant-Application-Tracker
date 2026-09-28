package com.example.grantTrack.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestDTO {

    // Faculty
    private String name;
    private String email;
    private String department;
    private String designation;
    private String password;
    private String role;

    // Stage
    private String stageName;
    private String description;
    private Integer orderNo;

    // Application
    private String title;
    private String abstractText;
    private BigDecimal requestedAmount;
    private LocalDate submittedDate;
    private String status;
    private Integer facultyId;
    private Integer stageId;

    // Expenditure
    private BigDecimal amount;
    private LocalDate dateIncurred;
    private Boolean isApproved;
    private Integer applicationId;
}