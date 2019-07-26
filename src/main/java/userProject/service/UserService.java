package userProject.service;

import org.springframework.data.util.Pair;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userProject.controller.UserController;
import userProject.dao.UserDao;
import userProject.model.Role;
import userProject.model.User;
import userProject.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    static Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(Integer id) {
       return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser);
        return userRepository.saveAndFlush(existingUser);
    }

    @Override
    public User deleteUser(Integer id) {
        log.debug("Enter in the delete method with id = " + id);
        User existingUser = userRepository.getOne(id);
        log.debug("Get the user with id = " + existingUser.getId() + ", username = " + existingUser.getUsername() + ", password = " + existingUser.getPassword());
        userRepository.delete(existingUser);
        log.debug("exit userRepository.delete(existingUser)");
        return existingUser;
    }

    @Override
    public Pair<User, List<Role>>  getRolesForUser(Integer id) {
        log.debug("get roles for user in UserService");
        User user = getUser(id);
        List<Role> roles = userDao.getRolesForUser(id);
        log.debug(" received list of roles ");

        Pair<User, List<Role>> pair = Pair.of(user, roles);
        return pair;
    }

}
