package ru.epkkc.spring_mvc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.epkkc.spring_mvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements UserDaoInt {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public User getUserWithId(long id) {
        TypedQuery<User> query = manager.createQuery("from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = manager.createQuery("from User", User.class).getResultList();
        return list == null ? new ArrayList<User>() : list;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        System.out.println(user);
        User userWithId = getUserWithId(user.getId());
        userWithId.updateUser(user);
        manager.flush();
//        Query query = manager.createQuery("update User u set " +
//                "u.name = :name, u.lastname = :lastname," +
//                " u.yearOfBirth = :yearOfBirth " +
//                "where u.id = :id")
//                .setParameter("name", user.getName())
//                .setParameter("lastname", user.getLastname())
//                .setParameter("yearOfBirth", user.getYearOfBirth())
//                .setParameter("id", user.getId());
//        query.executeUpdate();
    }

    @Transactional
    @Override
    public void remove(long id) {
        Query query = manager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id);
        query.executeUpdate();
    }
}
