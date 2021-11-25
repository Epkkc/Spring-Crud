package ru.epkkc.spring_mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.epkkc.spring_mvc.dao.UserDaoInt;
import ru.epkkc.spring_mvc.model.User;

import java.util.List;

@Service
public class UserService implements UserServiceInt{

    private UserDaoInt userDao;

    @Autowired
    public UserService(UserDaoInt userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getUserWithId(long id) {
        return userDao.getUserWithId(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        User userForUpdate = getUserWithId(user.getId());
        System.out.println(user);
        if (!user.getName().isEmpty()) userForUpdate.setName(user.getName());
        if (!user.getLastname().isEmpty()) userForUpdate.setLastname(user.getLastname());
        if (user.getYearOfBirth() > 0) userForUpdate.setYearOfBirth(user.getYearOfBirth());
        userDao.updateUser(userForUpdate);
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }
}
