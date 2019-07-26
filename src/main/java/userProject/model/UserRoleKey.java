package userProject.model;


import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserRoleKey implements Serializable {
    @Id
    @Column(name = "id_user")
    private Integer id_user;

    @Id
    @Column(name = "id_role")
    private Integer id_role;

    public UserRoleKey() {
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public UserRoleKey(Integer id_user, Integer id_role) {
        this.id_user = id_user;
        this.id_role = id_role;
    }


}
