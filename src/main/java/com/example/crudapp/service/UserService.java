package com.example.crudapp.service;

import com.example.crudapp.dao.UserDao;
import com.example.crudapp.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void initializeDatabase() throws SQLException {
        userDao.createTable();
    }

    public void addUser(String name, String email) throws SQLException {
        userDao.addUser(new User(0, name, email));
    }
    public List<User> getUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    public void updateUser(int id, String name, String email) throws SQLException {
        userDao.updateUser(new User(id, name, email));
    }
    public void deleteUser(int id) throws SQLException {
        userDao.deleteUser(id);
    }
}
