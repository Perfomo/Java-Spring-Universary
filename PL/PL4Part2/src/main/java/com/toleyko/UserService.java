package com.toleyko;

import java.util.List;
public interface UserService {
    User findUser(int id);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    List<User> findAllUsers();
    Auto findAutoById(int id);
}