package sn.atos.services;

import org.springframework.stereotype.Service;
import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;
import sn.atos.exceptions.ResourceNotFoundException;
import sn.atos.mappers.AccountMapper;
import sn.atos.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }


    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity getAccountById(String id) {
        Optional<AccountEntity> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()){
            throw new ResourceNotFoundException("Acount with id = "+id+"  is not found");
        }
        return optionalAccount.get();
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = accountMapper.toEntity(accountDTO);
        AccountEntity accountEntityCreated = accountRepository.save(accountEntity);
        AccountDTO accountDTOGETED = accountMapper.toDto(accountEntityCreated);
        return accountDTOGETED;
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account) {

        return null;
    }

    @Override
    public AccountEntity getAccountByAccountNumber(Long accountNumber) {
        return null;
    }
}
