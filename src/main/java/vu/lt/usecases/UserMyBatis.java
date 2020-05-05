package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.UserMapper;
import vu.lt.mybatis.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class UserMyBatis {
    @Inject
    private UserMapper userMapper;

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
        this.userMapper.insert(userToCreate);
        return "users?faces-redirect=true";
    }

    private void loadAllUsers(){
        this.allUsers = userMapper.selectAll();
    }
}
