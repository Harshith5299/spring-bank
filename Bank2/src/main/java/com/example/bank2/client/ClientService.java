package com.example.bank2.client;

import com.example.bank2.dto.DepositDto;
import com.example.bank2.dto.Dto;
import com.example.bank2.dto.TransferDto;
import com.example.bank2.dto.WithdrawDto;
import com.example.bank2.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ClientService {

    public ResponseEntity<?> withdrawRequest(TransferDto transferDto);

    public ResponseEntity<?> depositRequest(TransferDto transferDto);

}
