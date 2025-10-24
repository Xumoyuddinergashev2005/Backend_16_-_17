package org.example.backend_16.mapper;

import org.example.backend_16.model.Status;
import org.example.backend_16.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TodoMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String status = rs.getString("status");
        Timestamp created_at = rs.getTimestamp("created_at");

        return  Todo.builder()
                .id(id)
                .title(title)
                .description(description)
                .status(Status.fromString(status))
                .created_at(created_at.toLocalDateTime())
                .build();

    }
}
