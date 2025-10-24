package org.example.backend_16.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend_16.mapper.TodoMapper;
import org.example.backend_16.model.Status;
import org.example.backend_16.model.Todo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;




    public void save (Todo todo){

            String query = "INSERT INTO todo (title, description, status) VALUES (?,?,?)";
            jdbcTemplate.update(query, todo.getTitle(), todo.getDescription(), todo.getStatus().toString());

    }


    public Todo getById(Long id){

           String query = "SELECT * FROM todo WHERE id = ?";
           Object[] args = {id};
           return jdbcTemplate.queryForObject (query, args , new TodoMapper());


    }


    public List<Todo> getAll(){

            String query ="SELECT * FROM todo";
            return jdbcTemplate.query(query, new TodoMapper());

    }

    public void updateStatus(Status newStatus, Long id) {

           String query = "UPDATE  todo set status = ? WHERE id = ?";
           Object[] args = {newStatus.name(), id};
           jdbcTemplate.update(query, args);

    }

    public void deleteTodo(Long id) {


           String query = "DELETE FROM todo where id = ?";
           Object[] args = {id};
           jdbcTemplate.update(query, args);

    }

    public boolean existsById(Long id) {
        String query = "SELECT EXISTS(SELECT 1 FROM todo WHERE id = ?) ";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(query, args, Boolean.class);
    }
}
