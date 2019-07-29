package userProject.service;

import org.springframework.stereotype.Service;
import userProject.model.Permission;

import java.util.List;

@Service
public interface PermissionServiceInterface {
    public Permission getPermission(Integer id);
    public List<Permission> getAll();
    public Permission addPermission(Permission permission);
    public Permission updatePermission(Integer id, Permission permission);
    public Permission deletePermission(Integer id);
}
