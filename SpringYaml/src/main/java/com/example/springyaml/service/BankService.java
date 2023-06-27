package com.example.springyaml.service;

import com.example.springyaml.entity.Bank;
import com.example.springyaml.repository.BankRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankService {

    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @PostConstruct
    @Transactional
    public void changeAllNamesBank(){
        List<Bank> banks = bankRepository.findAll();
        for (Bank bank: banks){
            bank.setName("Tinkoff");
            bankRepository.save(bank);
        }
    }
}
