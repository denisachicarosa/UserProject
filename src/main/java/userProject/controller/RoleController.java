package userProject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userProject.exception.UserNotFoundException;
import userProject.model.Role;
import userProject.model.User;
import userProject.repository.RoleRepository;
import userProject.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class RoleController {

    static Logger log = Logger.getLogger(RoleController.class.getName());


    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    public List<Role> list() {
        System.out.println("RequestMethod.GET, go to roleRepository.findAll()");
        log.info("RequestMethod.GET, go to roleRepository.findAll() ");
        return roleService.getRoles();
    }

    @PostMapping("roles/{id}")
    public Role create(@RequestBody Role role) {
        System.out.println("create Note - > Post Mapping");
        return roleService.addRole(role);
    }

    @GetMapping("roles/{id}")
    public Role get(@PathVariable("id") Integer roleId) throws UserNotFoundException {
        return roleService.getRoleById(roleId);
//                .orElseThrow(() -> new UserNotFoundException(userId));
    }


//    @RequestMapping(value = "roles/{id}", method = RequestMethod.PUT)
//    public Role update(@PathVariable("id") Integer id, @RequestBody Role role) {
//        Role existingRole = roleRepository.getOne(id);
//        BeanUtils.copyProperties(role, existingRole);
//        return roleRepository.saveAndFlush(existingRole);
//    }
//
//    @RequestMapping(value = "roles/{id}", method = RequestMethod.DELETE)
//    public Role delete(@PathVariable Integer id) {
//        Role existingRole = roleRepository.getOne(id);
//        roleRepository.delete(existingRole);
//        return existingRole;
//    }
}