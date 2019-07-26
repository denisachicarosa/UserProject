package userProject.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userProject.controller.UserController;
import userProject.dao.RoleDao;
import userProject.model.Role;
import userProject.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService implements RoleServiceInterface{

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleDao roleDao;

    static Logger log = Logger.getLogger(UserController.class.getName());

    public List<Role> getRoles() {
        log.info(" get roles method");
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id) {
        log.info(" get role by id ");
        return roleRepository.getOne(id);
    }

    public Role addRole(Role role) {
        log.info("add role with id " + role.getId() + "and title " + role.getTitle());
        return roleRepository.saveAndFlush(role);
    }

//    public Role


}
