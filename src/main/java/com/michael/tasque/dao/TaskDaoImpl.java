package com.michael.tasque.dao;

import com.michael.tasque.model.Task;
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

    private static final String INSERT_QUERY = "INSERT INTO tasks(title, body) values(?, ?)";
    private static final String FETCH_QUERY = "SELECT id, title, body, completed FROM tasks";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM tasks WHERE id()";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Task create(final Task task) {


        KeyHolder holder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getBody());
            return ps;
        }, holder);
        int newTaskId = (int)holder.getKeys().get("id");
        task.setId(newTaskId);
        return task;
    }

    @Override
    public List find() {
        return this.jdbcTemplate.query(FETCH_QUERY, new TaskMapper());
    }

    @Override
    public Task findOne(int id) {
        return new Task();
    }

}

class TaskMapper implements RowMapper {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTitle(rs.getString("title"));
        task.setBody(rs.getString("body"));
        task.setCompleted(rs.getBoolean("completed"));
        return task;
    }
}
