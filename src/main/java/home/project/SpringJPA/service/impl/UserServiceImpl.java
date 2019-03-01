package home.project.SpringJPA.service.impl;

import home.project.SpringJPA.dao.UserDAO;
import home.project.SpringJPA.dao.impl.ImplBeanNames;
import home.project.SpringJPA.entity.User;
import home.project.SpringJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    /*
        USE DATASOURCE
        WITHOUT ORM
        EVERYTHING IMPLEMENT BY HANDS
     */
    @Qualifier(ImplBeanNames.USER_DAO_DATASOURCE_BEAN)
    /*
        USING JPA BASED ONLY ON JPA SPECIFICATION
        AND IMPLEMENTATION ORM CAN BE SIMPLY CHANGED
     */
    //@Qualifier(value = ImplBeanNames.USER_DAO_jPA_IMPL_BEAN)

    /*
        HIBERNATE SPECIFIC IMPLEMENTATION
        CAN NOT CHANGE ANOTHER ORM
        BUT USE A LOT OF HIBERNATE ONLY FEATURES
     */
    //@Qualifier(value = ImplBeanNames.USER_DAO_HIBERNATE_BEAN)

    /*
        ALL SIMPLE TEMPLATE CRUD OPERATION ARE IMPLEMENTED BY SPRING
        ADDITIONAL NEEDED METHODS IMPLEMENTED USING JPA SPECIFICATION
     */
    //@Qualifier(value = ImplBeanNames.USER_DAO_SPRING_DATA_BEAN)
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
