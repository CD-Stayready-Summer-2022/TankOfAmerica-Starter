package com.codedifferently.tankofamerica.domain.user.repos;

import com.codedifferently.tankofamerica.domain.user.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
