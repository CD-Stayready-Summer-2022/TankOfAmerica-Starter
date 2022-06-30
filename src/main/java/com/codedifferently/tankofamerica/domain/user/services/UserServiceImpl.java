package com.codedifferently.tankofamerica.domain.user.services;

import com.codedifferently.tankofamerica.domain.user.models.User;
import com.codedifferently.tankofamerica.domain.user.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User user){
        return userRepo.save(user);
    }

    public String getAllUsers(){
        StringBuilder builder = new StringBuilder();
        Iterable<User> users = userRepo.findAll();
        for (User user:users) {
            builder.append(user.toString() +"\n");
        }
        return builder.toString().trim();
    }

}
