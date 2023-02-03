package sn.atos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.atos.dto.AccountDto;
import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;
import sn.atos.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Repository
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){
        UserDto userCreated = userService.save(userDto);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }
    
 // list des account pa rapport a id user RestTemplate
    @GetMapping("/account/{userId}")
    public List<AccountDto>accountDtos(@PathVariable Long userId){
    	return userService.getAccountDto(userId);
    }
}
