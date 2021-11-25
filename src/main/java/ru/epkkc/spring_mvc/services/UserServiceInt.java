package ru.epkkc.spring_mvc.services;

import ru.epkkc.spring_mvc.model.User;

import java.util.List;

public interface UserServiceInt {

    void add(User user);

    User getUserWithId(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void remove(long id);
}
