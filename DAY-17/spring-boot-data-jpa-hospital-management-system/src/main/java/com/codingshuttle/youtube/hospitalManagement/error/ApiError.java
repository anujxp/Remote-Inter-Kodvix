package com.codingshuttle.youtube.hospitalManagement.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String message;

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus status) {
        this();
        this.message = message;
        this.status = status;
    }
}