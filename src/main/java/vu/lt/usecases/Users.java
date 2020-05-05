package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.User;
import vu.lt.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Users {
    @Inject
    private UsersDAO usersDAO;

    @Getter
    @Setter
    private User userToCreate = new User();

    @Getter
    private List<User> allUsers;

    @PostConstruct
    public void init(){
        loadAllUsers();
    }

    @Transactional
    public String createUser(){
        this.usersDAO.persist(userToCreate);
        return "users?faces-redirect=true";
    }

    private void loadAllUsers(){
        this.allUsers = usersDAO.loadAll();
    }
}
