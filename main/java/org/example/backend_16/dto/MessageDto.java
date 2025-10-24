package org.example.backend_16.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.backend_16.model.Status;

@Data
@Builder
@AllArgsConstructor
public class MessageDto {
    private String message;
    private boolean status;
    private String timestamp;
}
