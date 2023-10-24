package restassure.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class loanRequest {

    bankAccount bankAccount;
    String idNumber;
    String name;
    String surname;

    public void setBankAccount(bankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public bankAccount getBankAccount() {
        return bankAccount;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

}

class bankAccount {
    String accountNumber;
    String bankName;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

}
