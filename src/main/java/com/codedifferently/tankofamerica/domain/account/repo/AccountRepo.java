package com.codedifferently.tankofamerica.domain.account.repo;

import com.codedifferently.tankofamerica.domain.account.models.Account;
import com.codedifferently.tankofamerica.domain.user.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepo extends CrudRepository<Account, UUID> {
    List<Account> findByOwner(User owner);
}
