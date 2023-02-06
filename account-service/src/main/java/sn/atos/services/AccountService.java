package sn.atos.services;

import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountDTO> findAll();

    AccountDTO save(AccountDTO accountDTO);

    AccountDTO findById(Long id);


    void delete(Long id);

    AccountDTO update(AccountDTO accountDTO, Long id);
    
}
