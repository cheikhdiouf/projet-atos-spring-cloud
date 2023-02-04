package sn.atos.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;
import sn.atos.exceptions.ResourceNotFoundException;
import sn.atos.repository.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll()
        .stream().map(el -> modelMapper.map(el, AccountEntity.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO getAccountById(String id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return modelMapper.map(accountEntity, AccountDTO.class);
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {

        AccountEntity accountEntity = modelMapper.map(accountDTO, AccountEntity.class);
        AccountEntity newAccount = accountRepository.save(accountEntity);
        return modelMapper.map(newAccount, AccountDTO.class);

    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO updateAccount(String id, AccountDTO accountDTO) {
        Optional <AccountEntity> user = accountRepository.findById(id);
        if(user.isPresent()){
            AccountEntity accountEntity = modelMapper.map(accountDTO, AccountEntity.class);
            accountEntity.setId(id);
            AccountEntity accountToUpdate = accountRepository.save(accountEntity);
            return modelMapper.map(accountToUpdate, AccountDTO.class);
        } else{
            throw new ResourceNotFoundException("Not found account with id ="+ id );
        }
    }

    @Override
    public AccountDTO getAccountByAccountNumber(Long accountNumber) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new ResourceNotFoundException("Account with account number "+accountNumber+" is not found"));
        return  modelMapper.map(accountEntity, AccountDTO.class);
    }
}
