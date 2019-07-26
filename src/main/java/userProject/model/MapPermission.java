package userProject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(userProject.model.PermissionRoleKey.class)
public class MapPermission  {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_permission")
    private Integer id_permission;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Integer id_role;

    @Column(name = "mapped_by")
    private Integer mapped_by;

    @Column(name = "mapping_date")
    private Date mapping_date;

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

    public MapPermission(Integer id_permission, Integer id_role, Integer mapped_by, Date mapping_date) {
        this.id_permission = id_permission;
        this.id_role = id_role;
        this.mapped_by = mapped_by;
        this.mapping_date = mapping_date;
    }

    public MapPermission() {
    }
}
