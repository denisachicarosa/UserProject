package userProject.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Role")
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "map_permission" ,
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_permission"))
    private List<Permission> permissions = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(title, role.title) &&
                Objects.equals(users, role.users) &&
                Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, users, permissions);
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role() {
    }


}
