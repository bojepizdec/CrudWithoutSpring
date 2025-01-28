package com.example.crudapp.service;

import com.example.crudapp.dao.UserDao;
import com.example.crudapp.model.User;
import com.example.crudapp.validator.UserValidator;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void initializeDatabase() throws SQLException {
        userDao.createTable();
    }

    public void addUser(String name, String email) throws SQLException {
        User user = new User(0, name, email);
        try {
            UserValidator.validate(user);
            userDao.addUser(user);
            System.out.println("User added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error:" +e.getMessage());
        }
    }
    public List<User> getUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    public void updateUser(int id, String name, String email) throws SQLException {
       User user = new User(id , name, email);
       try {
           UserValidator.validate(user);
           userDao.updateUser(user);
           System.out.println("User updated successfully");
       } catch (IllegalArgumentException e) {
           System.out.println("Validation error:" +e.getMessage());
       }
    }
    public void deleteUser(int id) throws SQLException {
        userDao.deleteUser(id);
    }
}
