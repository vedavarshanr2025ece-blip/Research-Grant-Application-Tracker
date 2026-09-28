package com.example.grantTrack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private boolean success;
    private String message;
    private Object data;
}