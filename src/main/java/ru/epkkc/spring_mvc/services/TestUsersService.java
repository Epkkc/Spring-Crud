package ru.epkkc.spring_mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.epkkc.spring_mvc.dao.UserDaoInt;
import ru.epkkc.spring_mvc.model.User;

import javax.annotation.PostConstruct;

@Service
public class TestUsersService {

    private UserServiceInt userService;

    @Autowired
    public TestUsersService(UserServiceInt userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct() {
        userService.add(new User("name1", "lastname1", (short) 2001));
        userService.add(new User("name2", "lastname2", (short) 2002));
        userService.add(new User("name3", "lastname3", (short) 2003));
        userService.add(new User("name4", "lastname4", (short) 2004));
    }
}
