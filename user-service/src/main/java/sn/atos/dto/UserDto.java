package sn.atos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sn.atos.entity.RoleEntity;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    @NotNull(message = "Firstname cannot be empty!")
    @NotBlank(message = "Firstname required !")
    @Size(min = 2, max = 50, message = "Firstname size must between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Lastname cannot be empty!")
    @NotBlank(message = "Lastname required !")
    @Size(min = 2, max = 50, message = "Lastname size must between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Email cannot be empty!")
    @NotBlank(message = "Email required !")
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;

    @NotNull(message = "Address cannot be empty!")
    @NotBlank(message = "Address required !")
    @Size(min = 2, max = 100, message = "Lastname size must between 2 and 50 characters")
    private String address;

    @NotNull(message = "Password cannot be empty!")
    @NotBlank(message = "Password required !")
    @Size(min = 2, max = 100, message = "Password size must between 2 and 50 characters")
    private String password;

    @NotNull(message = "Phone number cannot be empty!")
    private Integer phoneNumber;

    private List<RoleEntity> roles = new ArrayList<>();
}
