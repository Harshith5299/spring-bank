package com.example.bank2.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto implements Dto{

    private boolean senderAccountStatus;

    @NotNull(message = "accountId cannot be Null")
    @Min(value = 1, message = "accountId cannot be less than 1")
    private long senderAccountId;

    private String senderFirstName;

    private String senderLastName;

    private String senderEmail;

    private boolean receiverAccountStatus;

    @NotNull(message = "accountId cannot be Null")
    @Min(value = 1, message = "accountId cannot be less than 1")
    private long receiverAccountId;

    private String receiverFirstName;

    private String receiverLastName;

    private String receiverEmail;

    @NotNull(message = "cashTransfer cannot be Null")
    @DecimalMax(value = "25000.00", message = "cashTransfer max limit is 25000.00")
    private double transferAmount;


}
