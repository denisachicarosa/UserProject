package userProject.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PermissionRoleKey implements Serializable {
    @Id
    @Column(name = "id_permission")
    private Integer id_permission;

    @Id
    @Column(name = "id_role")
    private Integer id_role;

    public PermissionRoleKey() {
    }

    public Integer getId_permission() {
        return id_permission;
    }

    public void setId_permission(Integer id_permission) {
        this.id_permission = id_permission;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public PermissionRoleKey(Integer id_permission, Integer id_role) {
        this.id_permission = id_permission;
        this.id_role = id_role;
    }


}
