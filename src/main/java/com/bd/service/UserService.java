package com.bd.service;

import com.bd.model.Lesson;
import com.bd.model.User;
import com.bd.repository.UserRep;
import com.bd.security.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRep userRep;
    PasswordEncryptor passwordEncryptor;

    @Autowired
    public UserService(UserRep userRep, PasswordEncryptor passwordEncryptor){
        this.userRep = userRep;
        this.passwordEncryptor = passwordEncryptor;
    }

    public void createUser(User user){
        user.setPassword(passwordEncryptor.encode(user.getPassword()));
        userRep.save(user);
    }
    public boolean isCredentialsValid(String login,String password){
        User user = getUserByLogin(login);
        if (user != null){
            return passwordEncryptor.decode(user.getPassword()).equals(password);
        }else {
            return false;
        }
    }

    public void saveUser(User user){
        user.setPassword(passwordEncryptor.encode(user.getPassword()));
        userRep.save(user);
    }

    public User getUserByLogin(String login){
        return userRep.findOneByLogin(login);
    }
}
