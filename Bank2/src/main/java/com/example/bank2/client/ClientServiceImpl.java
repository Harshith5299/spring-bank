package com.example.bank2.client;

import com.example.bank2.dto.DepositDto;
import com.example.bank2.dto.Dto;
import com.example.bank2.dto.TransferDto;
import com.example.bank2.dto.WithdrawDto;
import com.example.bank2.exception.BadRequestException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService{

    @Override
    public ResponseEntity<?> withdrawRequest(TransferDto transferDto){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8087/bank2/withdrawMoney";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer token");

        // Sending a specific type of Dto as request entity due to explicit controller configuration for validation purposes
        HttpEntity<WithdrawDto> requestEntity = new HttpEntity<>(new WithdrawDto(transferDto.isSenderAccountStatus(),
                transferDto.getSenderAccountId(), transferDto.getSenderFirstName(), transferDto.getSenderLastName(),
                transferDto.getSenderEmail(), transferDto.getTransferAmount()), headers);

        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, WithdrawDto.class);
        return response;

    }

    @Override
    public ResponseEntity<?> depositRequest(TransferDto transferDto){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8087/bank2/depositMoney";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer token");

        HttpEntity<DepositDto> requestEntity = new HttpEntity<>(new DepositDto(transferDto.isReceiverAccountStatus(),
                transferDto.getReceiverAccountId(), transferDto.getReceiverFirstName(), transferDto.getReceiverLastName(),
                transferDto.getReceiverEmail(), transferDto.getTransferAmount()), headers);

        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, DepositDto.class);
        return response;
    }

}

