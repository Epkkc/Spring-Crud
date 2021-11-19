package ru.epkkc.spring_mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.epkkc.spring_mvc.dao.UserDaoInt;
import ru.epkkc.spring_mvc.model.User;

import javax.annotation.PostConstruct;

@Service
public class TestUsersService {

    UserDaoInt dao;

    @Autowired
    public TestUsersService(UserDaoInt dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void postConstruct() {
        dao.add(new User("name1", "lastname1", (short) 2001));
        dao.add(new User("name2", "lastname2", (short) 2002));
        dao.add(new User("name3", "lastname3", (short) 2003));
        dao.add(new User("name4", "lastname4", (short) 2004));
    }
}
