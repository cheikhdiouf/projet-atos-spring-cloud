package sn.atos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.atos.enums.CompteType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private  String id;
    private Date creationDate;
    private  Long accountNumber;
    private double amount;
    private CompteType compteType;
}
