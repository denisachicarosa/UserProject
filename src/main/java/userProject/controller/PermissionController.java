package userProject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import userProject.exception.PermissionNotFoundException;
import userProject.model.Role;
import userProject.model.Permission;
import userProject.service.PermissionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PermissionController {

    static Logger log = Logger.getLogger(RoleController.class.getName());

    @Autowired
    public PermissionService permissionService;
    @RequestMapping(value = "permissions", method = RequestMethod.GET)
    public List<Permission> list() {
        System.out.println("RequestMethod.GET, go to permissionRepository.findAll()");
        log.info("RequestMethod.GET, go to permissionRepository.findAll() ");
        return permissionService.getAll();
    }

    @RequestMapping(value = "permissions/id", method = RequestMethod.POST)
    public Permission create(@RequestBody Permission permission) {
        System.out.println("create Note - > Post Mapping");
        return permissionService.addPermission(permission);
    }

    @RequestMapping(value = "permissions/{id}", method = RequestMethod.GET)
    public Permission get(@PathVariable("id") Integer id) throws PermissionNotFoundException {
        log.debug("getMethod with id = " + id +" id type is " + id.getClass());
        return permissionService.getPermission(id);
//                .orElseThrow(() -> new PermissionNotFoundException(permissionId));
    }


    @RequestMapping(value = "permissions/{id}", method = RequestMethod.PUT)
    public Permission update(@PathVariable Integer id, @RequestBody Permission permission) {
        return permissionService.updatePermission(id, permission);
    }

    @RequestMapping(value = "permissions/{id}", method = RequestMethod.DELETE)
    public Permission delete(@PathVariable("id") Integer id) {
        return permissionService.deletePermission(id);
    }

}
