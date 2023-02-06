package sn.atos.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;
import sn.atos.repository.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;



@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

	@Override
	public List<AccountDTO> findAll() {
		 return accountRepository.findAll()
	                .stream().map(el -> modelMapper.map(el, AccountDTO.class))
	                .collect(Collectors.toList());
	}

	@Override
	public AccountDTO save(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity = modelMapper.map(accountDTO, AccountEntity.class);
        AccountEntity savedUser = accountRepository.save(accountEntity);
        return modelMapper.map(savedUser, AccountDTO.class);
	}

	@Override
	public AccountDTO findById(Long id) {
		AccountEntity accountDTO = accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account ID not found"));
        return modelMapper.map(accountDTO, AccountDTO.class);
	}

	@Override
	public void delete(Long id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public AccountDTO update(AccountDTO accountDTO, Long id) {
		 Optional < AccountEntity> user = accountRepository.findById(id);
	        if(user.isPresent()){
	             AccountEntity  accountEntity = modelMapper.map(accountDTO,  AccountEntity.class);
	             accountEntity.setId(id);
	             AccountEntity updated = accountRepository.save( accountEntity);
	            return modelMapper.map(updated, AccountDTO.class);
	        } else{
	            throw new EntityNotFoundException("Account not found");
	        }
	}


    
}
