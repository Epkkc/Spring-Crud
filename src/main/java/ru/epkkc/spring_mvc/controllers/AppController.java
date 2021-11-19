package ru.epkkc.spring_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.epkkc.spring_mvc.dao.UserDaoInt;
import ru.epkkc.spring_mvc.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class AppController {

    UserDaoInt dao;

    @Autowired
    public AppController(UserDaoInt dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String usersTable(ModelMap model) {
        List<User> allUsers = dao.getAllUsers();

        for (User user : allUsers) {
            System.out.println(user);
        }

        model.addAttribute("users_list", allUsers);
        model.addAttribute("user_add", new User());
        model.addAttribute("user_update", new User());
        return "users_table";
    }

    @PostMapping()
    public RedirectView addUser(@ModelAttribute(name = "user_add") User user) {
        dao.add(user);
        return new RedirectView("http://localhost:8080/users");
    }

    @PatchMapping()
    public RedirectView patchUser(@ModelAttribute(name = "user_update") User user) {
        dao.updateUser(user);
        return new RedirectView("http://localhost:8080/users");
    }

    @DeleteMapping()
    public RedirectView removeUser(@RequestParam(name = "user_id") Long id) {
        dao.remove(id);
        return new RedirectView("http://localhost:8080/users");
    }

}
