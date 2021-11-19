package ru.epkkc.spring_mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private short yearOfBirth;

    public User() {
    }

    public User(String name, String lastname, short yearOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User: id = " + id
                + ", name = " + name
                + ", lastname = " + lastname
                + ", year = " + yearOfBirth;
    }

    public void updateUser(User user){
        if (!user.getName().isEmpty()) this.name = user.getName();
        if (!user.getLastname().isEmpty()) this.lastname = user.getLastname();
        if (user.getYearOfBirth() > 0) this.yearOfBirth = user.getYearOfBirth();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(short yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
