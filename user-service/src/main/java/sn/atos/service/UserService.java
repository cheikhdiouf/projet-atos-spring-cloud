package sn.atos.service;

import sn.atos.dto.AccountDto;
import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;

import java.util.List;

public interface UserService {


    List<UserEntity> findAll();

    UserDto save(UserDto userDto);

    UserDto findById(Integer id);

   // List<UserDto> findUserByFirstNameAndLastName(String firstName, String lastName);

    //List<UserDto> findByEmail(String firstName, String lastName);

    void delete(Integer id);

    UserDto update(UserDto userDto, Integer id);
    
    //restTemplate list account by user
    ///List<AccountDto> getAccountDto(Long userId);
    
}
