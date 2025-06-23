package com.example.bank2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name="Transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @ManyToOne
    @JoinColumn(name="senderAccountId")
    private AccountEntity senderAccountId;

    @ManyToOne
    @JoinColumn(name="receiverAccountId")
    private AccountEntity receiverAccountId;

    @Column(name="transferAmount")
    private double transferAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionId",unique = true)
    private long transactionId;

    @Column(name="transactionType")
    private String transactionType;

    @Column(name="uTCTimeStamp")
    private Instant timestamp;

}
