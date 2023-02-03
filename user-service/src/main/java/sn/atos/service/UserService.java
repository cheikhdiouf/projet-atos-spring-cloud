package sn.atos.service;

import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;

import java.util.List;

public interface UserService {


    List<UserEntity> findAll();

    UserDto save(UserDto userDto);

    UserDto findById(Integer id);

    UserDto findUserByFirstNameAndLastName(String firstName, String lastName);

    UserDto findByEmail(String email);

    void delete(Integer id);

    UserDto update(UserDto userDto, Integer id);
}
