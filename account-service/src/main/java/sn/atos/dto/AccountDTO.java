package sn.atos.dto;

import java.util.Date;

public class AccountDTO {
    private  String id;
    private Date creationDate;
    private  Long accountNumber;
    private double amount;

    public AccountDTO() {
    }

    public AccountDTO(String id, Date creationDate, Long accountNumber, double amount) {
        this.id = id;
        this.creationDate = creationDate;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
