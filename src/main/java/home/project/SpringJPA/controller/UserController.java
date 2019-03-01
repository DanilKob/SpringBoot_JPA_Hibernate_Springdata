package home.project.SpringJPA.controller;

import home.project.SpringJPA.entity.User;
import home.project.SpringJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public void addUser(
            @RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(path = "/users/{login}", method = RequestMethod.GET)
    public User getUser(
            @PathVariable("login")
                    String login){
        return userService.getUser(login);
    }

    @RequestMapping(path = "/users", method = RequestMethod.PUT)
    public void updateUser(
            @RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }
}
