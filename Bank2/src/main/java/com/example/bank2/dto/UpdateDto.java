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
public class UpdateDto implements Dto{

    private boolean accountStatus;

    long accountId;

    @NotNull(message = "firstName cannot be Null")
    @Pattern(regexp ="[a-zA-Z]+")
    String firstName;

    @NotNull(message = "lastName cannot be Null")
    @Pattern(regexp ="[a-zA-Z]+")
    String lastName;

    @Email(message = "email must be valid")
    @NotNull(message = "email cannot be Null")
    String email;

    @Null(message = "As balance cannot be changed using Update, keep it as null")
    Double balance;


}
