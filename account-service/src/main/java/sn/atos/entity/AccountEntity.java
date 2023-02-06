package sn.atos.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import sn.atos.enums.CompteType;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private  Long accountNumber;
    private double amount;
    private CompteType compteType;


}
