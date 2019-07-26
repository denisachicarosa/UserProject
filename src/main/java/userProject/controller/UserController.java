package userProject.controller;


import userProject.exception.UserNotFoundException;
import userProject.model.Role;
import userProject.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userProject.repository.UserRepository;
import org.apache.log4j.Logger;
import userProject.service.UserService;
import org.springframework.data.util.Pair;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    static Logger log = Logger.getLogger(UserController.class.getName());


    @Autowired
    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list() {
        System.out.println("RequestMethod.GET, go to userRepository.findAll()");
        log.info("RequestMethod.GET, go to userRepository.findAll() ");
        return userService.getAll();
    }

    @RequestMapping(value = "users/id", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        System.out.println("create Note - > Post Mapping");
        return userService.addUser(user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Integer id) throws UserNotFoundException {
        log.debug("getMethod with id = " + id +" id type is " + id.getClass());
        return userService.getUser(id);
//                .orElseThrow(() -> new UserNotFoundException(userId));
    }


    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Integer id, @RequestBody User user) {
       return userService.updateUser(id, user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") Integer id) {
       return userService.deleteUser(id);
    }

    @RequestMapping(value = "user_and_roles/{id}", method = RequestMethod.GET)
    public Pair<User, List<Role>> gerUserRoles(@PathVariable("id") Integer id) {
        log.debug(" in controlles, method getUserRoles with id = " + id);
        return userService.getRolesForUser(id);
    }

}

