package sn.atos.services;

import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();
    AccountDTO getAccountById(String code);
    AccountDTO createAccount(AccountDTO accountDTO);
    void deleteAccount(String id);
    AccountDTO updateAccount(String id, AccountDTO accountDTO);
    AccountDTO getAccountByAccountNumber(Long accountNumber);
}
