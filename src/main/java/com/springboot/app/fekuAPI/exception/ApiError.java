package com.springboot.app.fekuAPI.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String description;

    public ApiError(LocalDateTime timestamp, HttpStatus status, String message, String description) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.description = description;
    }
}
