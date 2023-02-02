package sn.atos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Integer id;

    @NotNull(message = "Firstname required !")
    @NotBlank(message = "Firstname required !")
    @Size(min = 2, max = 50, message = "The firstname of characters must be between 2 and 30")
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private Integer phoneNumber;
    
}
