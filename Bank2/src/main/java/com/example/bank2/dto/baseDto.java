package com.example.bank2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class baseDto implements Dto{


    private boolean accountStatus;

    long accountId;

    String firstName;

    String lastName;

    String email;

    Double balance;
}
