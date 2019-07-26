package userProject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(UserRoleKey.class)
public class MapRole implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Integer id_role;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Integer id_user;

    @Column(name = "mapped_by")
    private Integer mapped_by;

    @Column(name = "mapping_date")
    private Date mapping_date;

    public MapRole() {
    }
    public MapRole(Integer id_role, Integer id_user, Integer mapped_by, Date mapping_date) {
        this.id_role = id_role;
        this.id_user = id_user;
        this.mapped_by = mapped_by;
        this.mapping_date = mapping_date;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getMapped_by() {
        return mapped_by;
    }

    public void setMapped_by(Integer mapped_by) {
        this.mapped_by = mapped_by;
    }

    public Date getMapping_date() {
        return mapping_date;
    }

    public void setMapping_date(Date mapping_date) {
        this.mapping_date = mapping_date;
    }




}
