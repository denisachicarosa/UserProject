package userProject.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userProject.controller.UserController;
import userProject.model.Permission;
import userProject.repository.PermissionRepository;

import java.util.List;

@Service
public class PermissionService implements PermissionServiceInterface{

    static Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission getPermission(Integer id) {
//        if(!permissionRepository.containsKey(id))
        return permissionRepository.getOne(id);
    }

    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission addPermission(Permission permission) {
        return permissionRepository.saveAndFlush(permission);
    }

    @Override
    public Permission updatePermission(Integer id, Permission permission) {
        Permission existingPermission = permissionRepository.getOne(id);
        BeanUtils.copyProperties(permission, existingPermission);
        return permissionRepository.saveAndFlush(existingPermission);
    }

    @Override
    public Permission deletePermission(Integer id) {
        log.debug("Enter in the delete method with id = " + id);
        Permission existingPermission = permissionRepository.getOne(id);
        log.debug("Get the permission with id = " + existingPermission.getID() + ", permissionname = " + existingPermission.getDescription());
        permissionRepository.delete(existingPermission);
        log.debug("exit PermissionRepository.delete(existingPermission)");
        return existingPermission;
    }

}
