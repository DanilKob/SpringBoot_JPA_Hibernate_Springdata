package home.project.SpringJPA.dao.impl.spring.data;

import home.project.SpringJPA.dao.UserDAO;
import home.project.SpringJPA.dao.impl.ImplBeanNames;
import home.project.SpringJPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/*
    ADDITIONAL NEEDED METHODS IMPLEMENTED USING JPA SPECIFICATION
 */
@Repository(ImplBeanNames.USER_DAO_SPRING_DATA_BEAN)
public class UserDAOSpringDataCustomImpl implements UserDAO {

    private UserDAOSpringDataCRUD userDAOSpringDataCRUD;

    private EntityManager entityManager;

    @Autowired
    public void setUserDAOSpringDataCRUD(UserDAOSpringDataCRUD userDAOSpringDataCRUD) {
        this.userDAOSpringDataCRUD = userDAOSpringDataCRUD;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        userDAOSpringDataCRUD.save(user);
    }

    @Override
    public User getUser(String login) {
        TypedQuery<User> query = entityManager.createQuery(
                "select user from User user" +
                        " where user.login = :login",
                User.class);
        query.setParameter("login", login);
        User user = query.getSingleResult();
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDAOSpringDataCRUD.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDAOSpringDataCRUD.findAll();
    }
}
