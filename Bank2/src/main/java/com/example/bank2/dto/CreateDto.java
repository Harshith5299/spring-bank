package com.example.bank2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDto implements Dto {

    private boolean accountStatus;

    long accountId;

    @NotNull(message = "FirstName cannot be empty")
    @Pattern(regexp ="[a-zA-Z]+")
    String firstName;

    @NotNull(message = "LastName cannot be Null")
    @Pattern(regexp ="[a-zA-Z]+")
    String lastName;

    @Email(message = "Email must be valid")
    @NotNull(message = "Email cannot be Null")
    String email;

    @NotNull(message = "balance cannot be Null")
    @DecimalMin(value = "1500.00", message = "balance cannot be less than 1500.00 to create account")
    @DecimalMax(value = "25000.00", message = "balance max limit is 25000.00")
    double cashDeposit;

}
