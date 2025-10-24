package org.example.backend_16.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.backend_16.dto.MessageDto;
import org.example.backend_16.dto.TodoCreateDto;
import org.example.backend_16.model.Todo;
import org.example.backend_16.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>>getAll() {
    List<Todo>  body = todoService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(body);

    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        Todo todo = todoService.getById(id);
        return ResponseEntity.ok(todo);
    }



    @PostMapping("/todos")
    public ResponseEntity<MessageDto> createTodo(@RequestParam String title, @RequestParam String description){
        todoService.saveTodo(new TodoCreateDto(title, description));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                MessageDto
                        .builder()
                        .message("Status success created")
                        .status(true)
                        .timestamp(LocalDateTime.now().toString())
                        .build()

        );
    }


    @PostMapping("/todos/status/{id}")
    public ResponseEntity<?> updateStatus(@RequestParam("status") String status, @PathVariable Long id){
        todoService.updateStatus(status, id);
        return ResponseEntity.ok(
                MessageDto
                        .builder()
                        .message("Status success updated")
                        .status(true)
                        .timestamp(LocalDateTime.now().toString())
                        .build()
        );
    }

    @DeleteMapping("todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                MessageDto
                        .builder()
                        .message("Todo success deleted")
                        .status(true)
                        .timestamp(LocalDateTime.now().toString())
                        .build()
        );
    }


}
