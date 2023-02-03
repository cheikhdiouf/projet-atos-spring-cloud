package sn.atos.services;

import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();
    AccountEntity getAccountById(String code);
    AccountDTO createAccount(AccountDTO accountDTO);
    void deleteAccount(String code);
    AccountEntity updateAccount(AccountEntity account);
    AccountEntity getAccountByAccountNumber(Long accountNumber);
}
