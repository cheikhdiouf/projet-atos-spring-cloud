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
public class RoleDto {

    private Integer id;

    @NotNull(message = "Libelle cannot be empty!")
    @NotBlank(message = "Libelle required !")
    private String libelle;
}
