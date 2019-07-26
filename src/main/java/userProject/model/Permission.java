package userProject.model;

import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Permission")
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_permission")
    private Integer id_permission;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id_permission, that.id_permission) &&
                Objects.equals(description, that.description) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_permission, description, roles);
    }


    public Permission(Integer id_permission, String methodName) {
        this.id_permission = id_permission;
        this.description = methodName;
    }

    public Integer getID() {
        return id_permission;
    }

    public void setID(Integer id_permission) {
        this.id_permission = id_permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String methodName) {
        this.description = methodName;
    }

    public Permission() {
    }

}
