package com.example.bank2.dto;

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
public class DepositDto {

    private boolean accountStatus;

    @NotNull(message = "AccountId cannot be Null")
    @Min(value = 1, message = "AccountId cannot be less than 1")
    long accountId;

    String firstName;

    String lastName;

    String email;

    @NotNull(message = "cashWithdrawal cannot be Null")
    double cashDepositAmount;

}
