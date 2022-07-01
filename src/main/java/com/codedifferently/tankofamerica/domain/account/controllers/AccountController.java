package com.codedifferently.tankofamerica.domain.account.controllers;

import com.codedifferently.tankofamerica.domain.account.models.Account;
import com.codedifferently.tankofamerica.domain.account.services.AccountService;
import com.codedifferently.tankofamerica.domain.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ShellMethod("Create new Account")
    public String createNewAccount (@ShellOption({"-U","--user"}) Long id,
                                     @ShellOption({"-N", "--name"}) String name){
        try {
            Account account = new Account(name);
            account = accountService.create(id, account);
            return account.toString();
        } catch (UserNotFoundException e) {
            return "The User Id is invalid";
        }
    }

    @ShellMethod("Get User Accounts")
    public String userAccounts(@ShellOption({"-U","--user"}) Long id){

        try{
            String accounts = accountService.getAllFromUser(id);
            return accounts;
        }catch (UserNotFoundException e){
            return "The User Id is invalid";
        }

    }
}
