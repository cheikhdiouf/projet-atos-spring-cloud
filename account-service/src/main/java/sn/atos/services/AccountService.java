package sn.atos.services;

import sn.atos.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();
    AccountEntity getAccountById(String code);
    AccountEntity createAccount(AccountEntity account);
    void deleteAccount(String code);
    AccountEntity updateAccount(AccountEntity account);
}
