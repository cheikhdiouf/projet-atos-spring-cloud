package sn.atos.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.atos.dto.AccountDTO;
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
    public AccountDTO  createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @GetMapping
    public List<AccountEntity> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountEntity getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

    @PutMapping ("/{id}")
    public AccountDTO  updateAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

}
