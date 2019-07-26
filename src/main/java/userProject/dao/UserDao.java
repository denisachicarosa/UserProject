package userProject.dao;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import userProject.model.Role;
import userProject.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {


    private JdbcTemplate template;
    static Logger log = Logger.getLogger(UserDao.class.getName());

    @Autowired
    public void setJdbcTemplate(JdbcTemplate template) { this.template = template; }

    public List<User> getAllUsersRowMapper() {
        log.info("Get all Users method");

        return template.query("select * from users", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                log.debug("select method is running");

                User u = new User();
                u.setId(resultSet.getInt(1));
                u.setUsername(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));

                log.info("result: id = " + u.getId() + " username = " + u.getUsername() + " password = " + u.getPassword());

                return u;
            }
        });
    }

    public List<User> getById(Integer id) {
        log.info("Get User By Id method");

        return template.query
                ("SELECT * FROM users WHERE ID = ?",
                        new Object[]{id}, new RowMapper<User>() {
                            @Override
                            public  User mapRow(ResultSet resultSet, int i) throws SQLException {
                                log.debug("select user by id is running");
                                User u = new User();
                                u.setId(resultSet.getInt(1));
                                u.setUsername(resultSet.getString(2));
                                u.setPassword(resultSet.getString(3));
                                log.debug("result: id = " + u.getId() + " username = " + u.getUsername()+" password = " + u.getPassword());
                                return u;
                            }
        });
    }

    public List<Role> getRolesForUser(Integer id) {
        log.info(" Get roles of a user by user id = " + id );
        return template.query(
                ("SELECT r.id_role, r.title FROM roles AS r JOIN map_role AS mr ON (mr.id_role = r.id_role) WHERE mr.id_user = ?"),
                new Object[]{id}, new RowMapper<Role>() {
                    @Override
                    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                        log.debug("select roles for user with given id ");
                        Role role = new Role();
                        role.setId(resultSet.getInt(1));
                        role.setTitle(resultSet.getString(2));
                        log.debug("result role id = " + role.getId() + " title = " + role.getTitle());
                        return role;
                    }
                }
        );
    }

}
