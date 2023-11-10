package com.example.sf900jdbctemp.dao.impl;

import com.example.sf900jdbctemp.dao.UserRepository;
import com.example.sf900jdbctemp.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        final String INSERT_SQL = "INSERT INTO users(username, email, firstname, lastname, phonenumber,picurl) VALUES (?, ?, ?, ?, ?,?)";
        KeyHolder keyHolder= new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setString(1, user.getUsername());
                        ps.setString(2, user.getEmail());
                        ps.setString(3, user.getFirstname());
                        ps.setString(4, user.getLastname());
                        ps.setString(5, user.getPhonenumber());
                        ps.setString(6, user.getPicurl());
                        return ps;
                    }
                },keyHolder

        );
// ID'nin düzgün bir şekilde alınıp alınmadığını kontrol edin.
        if (keyHolder.getKey() == null || keyHolder.getKey().longValue() == 0) {
            throw new IllegalStateException("Insertion failed, no ID obtained.");
        }

        Long newUserId = keyHolder.getKey().longValue();


        return new User(newUserId, user.getUsername(), user.getEmail(), user.getFirstname(), user.getLastname(), user.getPhonenumber(),user.getPicurl());
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                    new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("phonenumber"),
                            rs.getString("picurl")
                    ));
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {

        String sql= "SELECT * FROM users";
        return jdbcTemplate.query(sql,(rs,rowNum)->
                new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("picurl")
                )

        );
    }

    @Override
    public void delete(Long id) {
        String sql="DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username=?, email=?, firstname=?, lastname=?, phonenumber=?,picurl=? WHERE id=?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getFirstname(), user.getLastname(), user.getPhonenumber(),user.getPicurl() ,user.getId());
    }
}
