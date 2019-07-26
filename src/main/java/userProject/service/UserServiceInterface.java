package userProject.service;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import userProject.model.Role;
import userProject.model.User;

import java.util.List;

@Service
public interface UserServiceInterface {
    public User getUser(Integer id);
    public List<User> getAll();
    public User addUser(User user);
    public User updateUser(Integer id, User user);
    public User deleteUser(Integer id);
    public Pair<User, List<Role>> getRolesForUser(Integer id);
}
