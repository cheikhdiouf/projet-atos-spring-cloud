package sn.atos.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;
import sn.atos.exception.EntityNotFoundException;
import sn.atos.service.UserService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
  public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    // Test to list all users
    @Test
   public void shouldFindAllUserWithSuccess() {
        List<UserEntity> allUser = userService.findAll();
        assertNotNull(allUser);
    }

    // Test to add a new user if successful
    @Test
    public void shouldSaveWithSuccess() {

     final UserDto expectedUser = new UserDto();
        expectedUser.setFirstName("Firstname test");
        expectedUser.setLastName("Lastname test");
        expectedUser.setEmail("name@test.com");
        expectedUser.setAddress("Address test");
        expectedUser.setPhoneNumber(1234);

        UserDto savedUser = userService.save(expectedUser);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(expectedUser.getFirstName(), savedUser.getFirstName());
        assertEquals(expectedUser.getLastName(), savedUser.getLastName());
        assertEquals(expectedUser.getEmail(), savedUser.getEmail());
        assertEquals(expectedUser.getAddress(), savedUser.getAddress());
        assertEquals(expectedUser.getPhoneNumber(), savedUser.getPhoneNumber());
    }

    // Test to add a new user if throw invalid exception
    @Test
    public void shouldThrowInvalidUserEntity() throws IOException {

        final UserDto expectedUser = new UserDto();
        URL url = new URL("http://localhost:8082/api/users");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        int statusCode = http.getResponseCode();

        assertEquals(HttpStatus.BAD_REQUEST.value(), statusCode);

    }

    // Test to find a user if succesful
    @Test
    public void shouldFindByIdWithSuccess() {
        UserDto expectedUser = userService.findById(1);

        assertNotNull(expectedUser);
        assertEquals("Mamadou", expectedUser.getFirstName());
        assertEquals("Sylla", expectedUser.getLastName());
        assertEquals("sylla@gmail.com", expectedUser.getEmail());
    }

    // Test to find a user if throw invalid exception
    @Test
    public void shouldThrowUserEntityNotFound() throws IOException {

        EntityNotFoundException expectedUser = assertThrows(EntityNotFoundException.class, () -> userService.findById(0));
        URL url = new URL("http://localhost:8082/api/users/id/"+10000);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        int statusCode = http.getResponseCode();

        assertEquals("User ID not found", expectedUser.getMessage());
        assertEquals(HttpStatus.NOT_FOUND.value(), statusCode);
    }

    // Test to find a user with firstname and lastname
    @Test
   public void shouldFindUserByFirstNameAndLastNameWithSuccess() {
      UserDto expectedUser = userService.findUserByFirstNameAndLastName("Mamadou", "Sylla");
      UserDto testUser = userService.findById(1);

      assertNotNull(expectedUser);
      assertEquals(testUser.getId(), expectedUser.getId());
      assertEquals("sylla@gmail.com", expectedUser.getEmail());
    }

      @Test
    public void shouldFindByEmailWithSuccess() {
    }

    // Test to delete a user by id
    @Test
    public void shouldDeleteWithSuccess() throws IOException {
        UserDto expectedUser = userService.delete(2);

        URL url = new URL("http://localhost:8082/api/id/"+expectedUser.getId());
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("DELETE");
        int statusCode = http.getResponseCode();

        assertNull(expectedUser);
        assertEquals(HttpStatus.NO_CONTENT.value(), statusCode);
    }

    // Test to update a
    @Test
    public void shouldUpdateWithSuccess() {

    final UserDto expectedUser = new UserDto();
        expectedUser.setFirstName("Firstname test");
        expectedUser.setLastName("Lastname test");
        expectedUser.setEmail("name@test.com");
        expectedUser.setAddress("Address test");
        expectedUser.setPhoneNumber(1234);

        UserDto savedUser = userService.save(expectedUser);


        UserDto userToUpdate = savedUser;

        userToUpdate.setFirstName("Firstname test update");
        userToUpdate.setLastName("Lastname test update");
        userToUpdate.setEmail("nameudate@test.com");
        userToUpdate.setAddress("Address test update");
        userToUpdate.setPhoneNumber(123456789);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(userToUpdate.getLastName(), savedUser.getLastName());
        assertEquals(userToUpdate.getEmail(), savedUser.getEmail());
        assertEquals(userToUpdate.getAddress(), savedUser.getAddress());
        assertEquals(userToUpdate.getPhoneNumber(), savedUser.getPhoneNumber());
    }
}