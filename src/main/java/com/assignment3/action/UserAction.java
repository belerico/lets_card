package com.assignment3.action;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class UserAction extends ActionSupport {

    private UserFaker faker = new UserFaker();
    private String errorMsg;
    private List<User> users;
    private UserService userService;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date dateOfBirth;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String JSPRedirect() {
        return ActionSupport.SUCCESS;
    }

    public String createUserPage() {
        User user = faker.create();
        setName(user.getName());
        setSurname(user.getSurname());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setDateOfBirth(user.getDateOfBirth());
        return ActionSupport.SUCCESS;
    }

    public String showUsers() {
        userService = ServiceFactory.getInstance().getUserService();
        setUsers(userService.readAll());
        return ActionSupport.SUCCESS;
    }

    public String createUser() {
        User user = new User();
        user.setName(getName());
        user.setSurname(getSurname());
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setDateOfBirth(getDateOfBirth());
        userService = ServiceFactory.getInstance().getUserService();
        try {
            userService.create(user);
        } catch (PersistenceException p) {
            userService.getDao().rollback();
            addActionError(p.toString());
            return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }
}
