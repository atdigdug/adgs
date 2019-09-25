package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.Transaction;

public interface TransactionMapper {
	
	final String INSERT = "INSERT INTO transactions "
			+ "(id, campaign_id, sender_name, sender_email, recipient_name, recipient_email, campaign_sku_id, "
			+ "application_code_provider_id, payment_provider_id, recipient_activated_email, sender_payment_status, "
			+ "recipient_clicked_email_link_date, recipient_activation_success_date, sender_payment_date, create_dttm, update_dttm) "
			+ "values (#{id}, #{campaignId}, #{senderName}, #{senderEmail}, #{recipientName}, "
			+ "#{recipientEmail}, #{campaignSkuId},#{applicationCodeProviderId}, #{paymentProviderId}, "
			+ "#{recipientActivatedEmail}, #{senderPaymentStatus}, #{recipientClickedEmailLinkDate}, #{recipientActivationSuccessDate}, "
			+ "#{senderPaymentDate}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, campaign_id, sender_name, sender_email, recipient_name, "
			+ "recipient_email, campaign_sku_id, application_code_provider_id, payment_provider_id, "
			+ "recipient_activated_email, sender_payment_status, recipient_clicked_email_link_date, "
			+ "recipient_activation_success_date, sender_payment_date, create_dttm, update_dttm "
			+ "from transactions WHERE id=#{id}";
	
	final String SELECT_BY_CAMPAIGN_ID = "select id, campaign_id, sender_name, sender_email, recipient_name, "
			+ "recipient_email, campaign_sku_id, application_code_provider_id, payment_provider_id, "
			+ "recipient_activated_email, sender_payment_status, recipient_clicked_email_link_date, "
			+ "recipient_activation_success_date, sender_payment_date, create_dttm, update_dttm "
			+ "from transactions WHERE campaign_id=#{campaignId}";

	final String SELECT_ALL = "select id, campaign_id, sender_name, sender_email, recipient_name, "
			+ "recipient_email, campaign_sku_id, application_code_provider_id, payment_provider_id, "
			+ "recipient_activated_email, sender_payment_status, recipient_clicked_email_link_date, "
			+ "recipient_activation_success_date, sender_payment_date, create_dttm, update_dttm "
			+ "from transactions";

	final String UPDATE = "UPDATE transactions set campaign_id=#{campaignId}, sender_name=#{senderName}, sender_email=#{senderEmail}, "
			+ "recipient_name=#{recipientName}, recipient_email=#{recipientEmail}, "
			+ "campaign_sku_id=#{campaignSkuId}, application_code_provider_id=#{applicationCodeProviderId}, "
			+ "payment_provider_id=#{paymentProviderId}, recipient_activated_email=#{recipientActivatedEmail}, "
			+ "recipient_clicked_email_link_date=#{recipientClickedEmailLinkDate}, recipient_activation_success_date=#{recipientActivationSuccessDate}, "
			+ "sender_payment_status=#{senderPaymentStatus}, sender_payment_date=#{senderPaymentDate}, update_dttm=#{updateDttm} where id=#{id}";

	@Update(UPDATE)
	int updateTransaction(Transaction transaction);

	@Insert(INSERT)
	int insertTransaction(Transaction transaction);

	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "senderName", column = "sender_name"),
			@Result(property = "senderEmail", column = "sender_email"),
			@Result(property = "recipientName", column = "recipient_name"),
			@Result(property = "recipientEmail", column = "recipient_email"),
			@Result(property = "campaignSkuId", column = "campaign_sku_id"), 
			@Result(property = "applicationCodeProviderId", column = "application_code_provider_id"),
			@Result(property = "paymentProviderId", column = "payment_provider_id"),
			@Result(property = "recipientActivatedEmail", column = "recipient_activated_email"),
			@Result(property = "senderPaymentStatus", column = "sender_payment_status"),
			@Result(property = "recipientClickedEmailLinkDate", column = "recipient_clicked_email_link_date"),
			@Result(property = "recipientActivationSuccessDate", column = "recipient_activation_success_date"),
			@Result(property = "senderPaymentDate", column = "sender_payment_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_ID)
	Transaction findTransactionById(String id);

	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "senderName", column = "sender_name"),
			@Result(property = "senderEmail", column = "sender_email"),
			@Result(property = "recipientName", column = "recipient_name"),
			@Result(property = "recipientEmail", column = "recipient_email"),
			@Result(property = "campaignSkuId", column = "campaign_sku_id"), 
			@Result(property = "applicationCodeProviderId", column = "application_code_provider_id"),
			@Result(property = "paymentProviderId", column = "payment_provider_id"),
			@Result(property = "recipientActivatedEmail", column = "recipient_activated_email"),
			@Result(property = "senderPaymentStatus", column = "sender_payment_status"),
			@Result(property = "recipientClickedEmailLinkDate", column = "recipient_clicked_email_link_date"),
			@Result(property = "recipientActivationSuccessDate", column = "recipient_activation_success_date"),
			@Result(property = "senderPaymentDate", column = "sender_payment_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_ALL)
	List<Transaction> findTransactions();
	
	@Results(value = { @Result(property = "id", column = "id"), 
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "senderName", column = "sender_name"),
			@Result(property = "senderEmail", column = "sender_email"),
			@Result(property = "recipientName", column = "recipient_name"),
			@Result(property = "recipientEmail", column = "recipient_email"),
			@Result(property = "campaignSkuId", column = "campaign_sku_id"), 
			@Result(property = "applicationCodeProviderId", column = "application_code_provider_id"),
			@Result(property = "paymentProviderId", column = "payment_provider_id"),
			@Result(property = "recipientActivatedEmail", column = "recipient_activated_email"),
			@Result(property = "senderPaymentStatus", column = "sender_payment_status"),
			@Result(property = "recipientClickedEmailLinkDate", column = "recipient_clicked_email_link_date"),
			@Result(property = "recipientActivationSuccessDate", column = "recipient_activation_success_date"),
			@Result(property = "senderPaymentDate", column = "sender_payment_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm") })
	@Select(SELECT_BY_CAMPAIGN_ID)
	List<Transaction> findByCampaignId(String campaignId);

}
