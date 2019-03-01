package home.project.SpringJPA.dao.impl;

import home.project.SpringJPA.dao.UserDAO;
import home.project.SpringJPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository(ImplBeanNames.USER_DAO_DATASOURCE_BEAN)
public class UserDAODataSourceImpl implements UserDAO {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user " +
                    "(user.login, user.firstname, user.lastname) " +
                    "values" +
                    "(?, ?, ?);");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(String login) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select " +
                    "user.id, user.login, user.firstname, user.lastname " +
                    "from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while(resultSet.next()){
                user = new User();
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                user.setId(id);
                user.setLogin(login);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
