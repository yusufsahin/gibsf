package com.example.sf900jdbctemp.dao;

import com.example.sf900jdbctemp.dao.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);
    void update(User user);
}
