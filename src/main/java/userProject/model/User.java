package userProject.model;


import javax.persistence.*;
import java.util.*;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    /*
        ------------------------------------------------------------------------
        | @OneToMany( orphanRemoval = true, cascade = CascadeType.ALL)          | <- OneToMany version
        | @JoinColumn(name = "user_id_user")                                    |
        ------------------------------------------------------------------------
    */
    @ManyToMany ( cascade = CascadeType.ALL)
    @JoinTable(name = "map_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Role> roles = new ArrayList<>() ;


    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roles);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
