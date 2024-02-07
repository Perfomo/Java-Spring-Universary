package com.toleyko;

import java.util.List;
public interface UserDao {
    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(int id);
    List<User> findAll();
}