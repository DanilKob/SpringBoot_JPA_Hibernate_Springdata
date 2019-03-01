package home.project.SpringJPA.dao.impl;

import home.project.SpringJPA.dao.UserDAO;
import home.project.SpringJPA.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/*
    HIBERNATE SPECIFIC IMPLEMENTATION
    CAN NOT CHANGE ANOTHER ORM
    BUT USE A LOT OF HIBERNATE ONLY FEATURES
 */
@Repository(ImplBeanNames.USER_DAO_HIBERNATE_BEAN)
public class UserDAONativeHibernateImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAONativeHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        // GETTING ORIGINAL HIBERNATE IMPLEMENTATION OF JPA ENTITY MANAGER
        Session session = entityManager.unwrap(Session.class);
        //session.getTransaction().begin();
        session.save(user);
        //session.getTransaction().commit();
    }

    @Override
    public User getUser(String login) {
        // GETTING ORIGINAL HIBERNATE IMPLEMENTATION OF JPA ENTITY MANAGER
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, login);
    }

    @Override
    public void updateUser(User user) {
        // GETTING ORIGINAL HIBERNATE IMPLEMENTATION OF JPA ENTITY MANAGER
        Session session = entityManager.unwrap(Session.class);
        session.update(user);
    }

    @Override
    public List<User> getAll() {

        // GETTING ORIGINAL HIBERNATE IMPLEMENTATION OF JPA ENTITY MANAGER
        Session session = entityManager.unwrap(Session.class);

        Query<User> userSQuery = session.createQuery("from User", User.class);
        return userSQuery.getResultList();
    }
}
