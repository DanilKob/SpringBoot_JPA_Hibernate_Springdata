package home.project.SpringJPA.dao.impl.spring.data;

import home.project.SpringJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    ALL SIMPLE TEMPLATE CRUD OPERATION ARE IMPLEMENTED BY SPRING
 */
@Repository
public interface UserDAOSpringDataCRUD extends JpaRepository<User, Integer> {

}
