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
import ru.epkkc.spring_mvc.model.User;
import ru.epkkc.spring_mvc.services.UserServiceInt;

import java.util.List;

@Controller
@RequestMapping("/users")
public class AppController {

    private UserServiceInt userService;

    @Autowired
    public AppController(UserServiceInt userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String usersTable(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();

        for (User user : allUsers) {
            System.out.println(user);
        }

        model.addAttribute("users_list", allUsers);
        model.addAttribute("user_add", new User());
        model.addAttribute("user_update", new User());
        return "users_table";
    }

    @PostMapping()
    public String addUser(@ModelAttribute(name = "user_add") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PatchMapping()
    public String patchUser(@ModelAttribute(name = "user_update") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String removeUser(@RequestParam(name = "user_id") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}
