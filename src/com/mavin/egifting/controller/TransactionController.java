package com.mavin.egifting.controller;

import com.mavin.egifting.dto.TransactionDto;
import com.mavin.egifting.model.Transaction;
import com.mavin.egifting.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/services/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    Logger logger = Logger.getLogger(TransactionController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Transaction saveTransaction(@RequestBody Transaction transaction) {

        logger.info("Entering saveTransaction() - " + transaction);

        Transaction saved = transactionService.createTransaction(transaction);

        logger.info("Exiting saveTransaction() - " + saved);

        return saved;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public boolean updateTransaction(@RequestBody TransactionDto dto) {

        logger.info("Entering updateTransaction() - " + dto);

        // boolean saved = transactionService.insertTransaction(dto);

        logger.info("Exiting updateTransaction() - ");

        return true;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TransactionDto getTransaction(@PathVariable String id) {

        logger.info("Entering getTransaction() - " + id);

        TransactionDto dto = new TransactionDto();
        dto.setId("demo_test_id");
        dto.setCampaignId("db4d0f17-b9d7-47ed-8aec-1e0590a6fa3d");
        dto.setSenderName("demo_test_sender_name");
        dto.setSenderEmail("sender@email.co");
        dto.setRecipientName("demo_test_recipient_name");
        dto.setRecipientEmail("recipient@email.co");

        logger.info("Exiting getTransaction() - " + dto);

        return dto;
    }

}
