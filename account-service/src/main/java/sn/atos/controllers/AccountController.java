package sn.atos.controllers;

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
    public AccountDTO getAccountById(@PathVariable String id) {

        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable String id) {

        accountService.deleteAccount(id);
    }

    @GetMapping("/{accountNumber}")
    public AccountDTO getAccountByAccountNumber(@PathVariable Long accountNumber) {

        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @PutMapping ("/{id}")
    public AccountDTO  updateAccount(@PathVariable String id ,@RequestBody AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }

}
