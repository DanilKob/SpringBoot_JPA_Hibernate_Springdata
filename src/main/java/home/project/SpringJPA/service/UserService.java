package home.project.SpringJPA.service;

import home.project.SpringJPA.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUser(String login);
    void updateUser(User user);
    List<User> getAll();
}
