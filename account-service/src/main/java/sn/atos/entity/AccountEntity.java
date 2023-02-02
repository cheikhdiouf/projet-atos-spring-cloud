package sn.atos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Document(collation = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity implements Serializable {

    @Id
    private  String id;
    private Date creationDate;
    private  Long accountNumber;
    private double amount;
}
