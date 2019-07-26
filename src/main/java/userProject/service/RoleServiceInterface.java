package userProject.service;


import org.springframework.stereotype.Service;
import userProject.model.Role;

import java.util.List;

@Service
public interface RoleServiceInterface {
    public List<Role> getRoles();
    public Role getRoleById(Integer id);
    public Role addRole(Role role);

}
