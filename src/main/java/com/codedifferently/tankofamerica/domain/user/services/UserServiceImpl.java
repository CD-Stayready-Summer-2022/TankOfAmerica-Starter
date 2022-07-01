package com.codedifferently.tankofamerica.domain.user.services;

import com.codedifferently.tankofamerica.domain.user.exceptions.UserNotFoundException;
import com.codedifferently.tankofamerica.domain.user.models.User;
import com.codedifferently.tankofamerica.domain.user.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


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

    @Override
    public User getById(Long id) throws UserNotFoundException {
        Optional<User> optional = userRepo.findById(id);
        if(optional.isEmpty())
            throw new UserNotFoundException(String.format("User with id {} not found", id));
        return optional.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserServiceImpl that = (UserServiceImpl) o;
        return Objects.equals(userRepo, that.userRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRepo);
    }
}
