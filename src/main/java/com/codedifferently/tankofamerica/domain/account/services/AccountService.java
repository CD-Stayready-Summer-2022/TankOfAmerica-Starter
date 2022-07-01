package com.codedifferently.tankofamerica.domain.account.services;

import com.codedifferently.tankofamerica.domain.account.models.Account;
import com.codedifferently.tankofamerica.domain.user.exceptions.UserNotFoundException;

public interface AccountService {
    Account create(Long userId, Account account) throws UserNotFoundException;
    String getById(String id);
    String getAllFromUser(Long userId) throws UserNotFoundException;
    Account update(Account account);
    Boolean delete(String id);
}
