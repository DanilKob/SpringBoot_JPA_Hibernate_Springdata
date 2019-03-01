package home.project.SpringJPA.dao.impl;

import home.project.SpringJPA.dao.UserDAO;
import home.project.SpringJPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/*
   USING JPA BASED ONLY ON JPA SPECIFICATION
   AND IMPLEMENTATION ORM CAN BE SIMPLY CHANGED
*/
@Repository(ImplBeanNames.USER_DAO_jPA_IMPL_BEAN)
public class UserDAOJPAImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
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
        User mergedUser = entityManager.merge(user);
        user.setId(mergedUser.getId());
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("from User", User.class);
        List<User> users = userTypedQuery.getResultList();
        return users;
    }
}
