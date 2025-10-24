package org.example.backend_16.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.backend_16.model.Status;

@Data
@Builder
@AllArgsConstructor
public class TodoCreateDto {
    private String title;
    private String description;

}
