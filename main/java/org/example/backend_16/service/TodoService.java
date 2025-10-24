package org.example.backend_16.service;


import lombok.RequiredArgsConstructor;
import org.example.backend_16.dto.TodoCreateDto;
import org.example.backend_16.exception.NotFoundException;
import org.example.backend_16.model.Status;
import org.example.backend_16.model.Todo;
import org.example.backend_16.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public void saveTodo(TodoCreateDto dto) {
        if(dto.getTitle() == null || dto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(dto.getDescription() == null || dto.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        Todo todo= Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(Status.TODO)
                .created_at(LocalDateTime.now())
                .build();

        todoRepository.save(todo);


    }

    public List<Todo> getAll (){
        return todoRepository.getAll();
    }

    public Todo getById(Long id) {
        Todo todo = todoRepository.getById(id);
        if(todo == null) {
            throw new NotFoundException("Todo not found");
        }
        return todo;
    }

    public void updateStatus(String status, Long id) {
        Status newStatus = Status.fromString(status);
        todoRepository.updateStatus(newStatus,id);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)){
            throw new NotFoundException("Todo not found");
        }
        todoRepository.deleteTodo(id);

    }
}
