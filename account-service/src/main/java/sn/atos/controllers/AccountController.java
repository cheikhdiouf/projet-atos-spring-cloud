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
        return accountService.save(accountDTO);
    }

    @GetMapping
    public List<AccountDTO> getAccounts() {

        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable Long id) {

        return accountService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id) {

        accountService.delete(id);
    }

   
    @PutMapping ("/{id}")
    public AccountDTO  updateAccount(@PathVariable Long id ,@RequestBody AccountDTO accountDTO) {
        return accountService.update(accountDTO, id);

}
 
}
