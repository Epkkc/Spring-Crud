package ru.epkkc.spring_mvc.dao;

import org.springframework.stereotype.Repository;
import ru.epkkc.spring_mvc.model.User;

import java.util.List;

public interface UserDaoInt {

    void add(User user);

    User getUserWithId(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void remove(long id);

}
