package com.example.bank2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.PrimaryKey;

import java.util.List;

@Entity
@Table(name = "BankAccounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Column(name = "accountStatus")
    private boolean accountStatus=true; //default value of an account is set to active, in case of a new Account
    // Entity instance

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    long accountId;

    @Column(name="firstName")
    String firstName;

    @Column(name="lastName")
    String lastName;

    @Column(name="email", unique = true) //Email must be unique in order to be used as an identifier
    String email;

    @Column(name="balance")
    double balance;

    @OneToMany(mappedBy = "senderAccountId") // column that stores all transaction entity instances in which this account
    // entity instance was a sender
    private List<TransactionEntity> sentTransactions;

    // column that stores all transaction entity instances in which this account
    // entity instance was a receiver
    @OneToMany(mappedBy = "receiverAccountId")
    private List<TransactionEntity> receivedTransactions;
    public AccountEntity(String firstName, String lastName, String email, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
    }

}
