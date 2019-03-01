package home.project.SpringJPA.dao;

import home.project.SpringJPA.entity.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUser(String login);
    void updateUser(User user);
    List<User> getAll();
}
