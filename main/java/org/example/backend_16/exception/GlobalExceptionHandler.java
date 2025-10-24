package org.example.backend_16.exception;


import org.example.backend_16.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, RuntimeException.class})
    public ResponseEntity<MessageDto> HandlerException(Exception e){
        return ResponseEntity.badRequest()
                .body(
                        MessageDto.builder()
                                .message(e.getMessage())
                                .timestamp(LocalDateTime.now().toString())
                                .status(false)
                                .build()
                );
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<MessageDto> HandlerNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        MessageDto.builder()
                                .message(e.getMessage())
                                .timestamp(LocalDateTime.now().toString())
                                .status(false)
                                .build()
                );
    }
}
