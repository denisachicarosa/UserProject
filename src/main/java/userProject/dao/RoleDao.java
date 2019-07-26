package userProject.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import userProject.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class RoleDao {

    private JdbcTemplate template;
    static Logger log = Logger.getLogger(RoleDao.class.getName());


    public void setJdbcTemplate(JdbcTemplate template) { this.template = template; }

    public List<Role> getAllRolesRowMapper() {
        log.info("Get all Roles method");

        return template.query("select * from company.roles", new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                log.debug("select method is running");

                Role u = new Role();
                u.setId(resultSet.getInt(1));
                u.setTitle(resultSet.getString(2));

                log.info("result: id = " + u.getId() + " title = " + u.getTitle());

                return u;
            }
        });
    }

    public List<Role> getById(Integer id) {
        log.info("Get Role By Id method");

        return template.query
                ("SELECT * FROM company.roles WHERE ID = ?",
                        new Object[]{id}, new RowMapper<Role>() {
                            @Override
                            public  Role mapRow(ResultSet resultSet, int i) throws SQLException {
                                log.debug("select role by id is running");
                                Role u = new Role();
                                u.setId(resultSet.getInt(1));
                                u.setTitle(resultSet.getString(2));
                                log.debug("result: id = " + u.getId() + " title = " + u.getTitle());
                                return u;
                            }
                        });
    }

}
