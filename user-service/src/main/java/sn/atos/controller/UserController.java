package sn.atos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<UserDto> getUserByFisrtNameAndLastName(@PathVariable("firstName") String firstName,  @PathVariable String lastName){
        return new ResponseEntity(userService.findUserByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email){
        return new ResponseEntity(userService.findByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@Valid @RequestBody() UserDto userDto, @PathVariable("id") Integer id){
        UserDto updatedUser = userService.update(userDto, id);
        return new ResponseEntity(updatedUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Integer id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/account/{userid}")
    public List<AccountDto> getAccount(@PathVariable Long userId){
    	return userService.getAccountDto(userId);
    }
    
}
