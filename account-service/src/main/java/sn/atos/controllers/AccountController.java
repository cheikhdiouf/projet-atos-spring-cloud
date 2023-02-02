package sn.atos.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.atos.entity.AccountEntity;
import sn.atos.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public AccountEntity  addRestaurant(@RequestBody  AccountEntity account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<AccountEntity> getRestaurants() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountEntity getRestaurant(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

}
