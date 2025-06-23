package com.example.bank2.mapper;

import com.example.bank2.dto.*;
import com.example.bank2.entity.AccountEntity;

public class Mapper {

    public static Dto mapToDto(AccountEntity accountEntity){
        return new baseDto(accountEntity.isAccountStatus(), accountEntity.getAccountId(), accountEntity.getFirstName(), accountEntity.getLastName(),
                accountEntity.getEmail(), accountEntity.getBalance());
    }



//    public static AccountEntity maptoAccountEntity(UpdateDto updateDto){
//        return new AccountEntity(updateDto.getFirstName(), updateDto.getLastName(),
//                updateDto.getEmail(), updateDto.getBalance());
//    }

}
