package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.TransactionMapper;
import com.mavin.egifting.model.Transaction;

@Component
public class TransactionService {

	Logger logger = Logger.getLogger(ApplicationService.class);

	@Autowired
	TransactionMapper transactionMapper;

	public Transaction createTransaction(Transaction transaction) {

		logger.info("Entering createTransaction() - " + transaction);
		Preconditions.checkNotNull(transaction);
		Preconditions.checkArgument(Strings.isNullOrEmpty(transaction.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getCampaignId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getCampaignSkuId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getApplicationCodeProviderId()));

		transaction.setId(UUID.randomUUID().toString());
		transaction.setCreateDttm(System.currentTimeMillis());
		transaction.setUpdateDttm(System.currentTimeMillis());
		int rows = transactionMapper.insertTransaction(transaction);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create transaction");
			return null;
		}
		logger.info("Exiting createTransaction() - " + transaction);
		return transaction;
	}

	public Transaction updateTransaction(Transaction transaction) {
		logger.info("Entering updateTransaction() - " + transaction);

		Preconditions.checkNotNull(transaction);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getCampaignId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getCampaignSkuId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transaction.getApplicationCodeProviderId()));

		transaction.setUpdateDttm(System.currentTimeMillis());
		int rows = transactionMapper.updateTransaction(transaction);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to update transaction");
			return null;
		}
		logger.info("Exiting updateTransaction() - " + transaction);
		return transaction;
	}

	public Transaction getTransactionById(String transactionId) {
		logger.info("Entering getTransactionById() - " + transactionId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(transactionId));
		Transaction transaction = transactionMapper.findTransactionById(transactionId);
		logger.info("Exiting getTransactionById() - " + transaction);
		return transaction;
	}

	public List<Transaction> getAllTransactions() {
		logger.info("Entering getAllTransactions()");
		List<Transaction> transactions = transactionMapper.findTransactions();
		logger.info("Exiting getAllTransactions() - " + transactions);
		return transactions;
	}

}
