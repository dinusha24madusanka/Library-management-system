package com.Library_Management_System.Mini_Project.DTO;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private LocalDateTime timestamp;
    private int status;
    private String message;

    public ErrorResponseDTO(LocalDateTime timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
