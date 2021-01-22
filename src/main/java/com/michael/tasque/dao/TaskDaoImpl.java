package com.michael.tasque.dao;

import com.michael.tasque.model.Task;
import com.michael.tasque.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final String INSERT_QUERY = "INSERT INTO tasks(name, body, completed) values(?, ?, ?)";
    private final String FETCH_QUERY = "SELECT id, name, body, completed FROM tasks";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Task create(final Task task) {

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, task.getName());
                ps.setString(2, task.getBody());
                ps.setBoolean(3, task.isCompleted());
                return ps;
            }
        }, holder);
        int newTaskId = holder.getKey().intValue();
        task.setId(newTaskId);
        return task;
    }

    @Override
    public List find() {
        return jdbcTemplate.query(FETCH_QUERY, new TaskMapper());
    }

}

class TaskMapper implements RowMapper {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setName(rs.getString("name"));
        task.setBody(rs.getString("body"));
        task.setCompleted(rs.getBoolean("completed"));
        return task;
    }
}
