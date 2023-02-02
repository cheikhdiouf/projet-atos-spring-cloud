package sn.atos.services;

import org.springframework.stereotype.Service;
import sn.atos.entity.AccountEntity;
import sn.atos.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity getAccountById(String id) {
        return null;
    }

    @Override
    public AccountEntity createAccount(AccountEntity account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account) {
        return null;
    }
}
