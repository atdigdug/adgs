package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.CampaignTemplate;

@Mapper
public interface CampaignTemplateMapper {

	final String INSERT = "INSERT INTO campaign_template "
			+ "(id, application_id, name, sender_web_text, sender_email_subject, sender_email_body, "
			+ "recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, email_logo, "
			+ "create_dttm, update_dttm) "
			+ "values (#{id}, #{applicationId}, #{name}, #{senderWebText}, #{senderEmailSubject}, "
			+ "#{senderEmailBody}, #{recipientWebText}, #{recipientEmailSubject}, "
			+ "#{recipientEmailBody}, #{webLogo}, #{emailLogo}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo,  create_dttm, update_dttm from campaign_template WHERE id=#{id}";
	
	final String SELECT_BY_APPLICATION_ID = "select id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo,  create_dttm, update_dttm from campaign_template WHERE application_id=#{applicationId}";

	final String SELECT_ALL = "select id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo, create_dttm, update_dttm from campaign_template";

	final String UPDATE = "UPDATE campaign_template set application_id=#{applicationId}, name=#{name}, "
			+ "sender_web_text=#{senderWebText}, sender_email_subject=#{senderEmailSubject}, "
			+ "sender_email_body=#{senderEmailBody},recipient_web_text=#{recipientWebText}, "
			+ "recipient_email_subject=#{recipientEmailSubject}, recipient_email_body=#{recipientEmailBody}, "
			+ "web_logo=#{webLogo}, email_logo=#{emailLogo} where id=#{id}";
	
	@Update(UPDATE)
	int updateCampaignTemplate(CampaignTemplate campaignTemplate);
	
	@Insert(INSERT)
	int insertCampaignTemplate(CampaignTemplate campaignTemplate);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "applicationId", column = "application_id"),
			@Result(property = "name", column = "name"),
			@Result(property = "senderWebText", column = "sender_web_text"),
			@Result(property = "senderEmailSubject", column = "sender_email_subject"),
			@Result(property = "senderEmailBody", column = "sender_email_body"),
			@Result(property = "recipientWebText", column = "recipient_web_text"),
			@Result(property = "recipientEmailSubject", column = "recipient_email_subject"),
			@Result(property = "recipientEmailBody", column = "recipient_email_body"),
			@Result(property = "webLogo", column = "web_logo"),
			@Result(property = "emailLogo", column = "email_logo"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_BY_ID)
	CampaignTemplate findCampaignTemplateById(String id);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "applicationId", column = "application_id"),
			@Result(property = "name", column = "name"),
			@Result(property = "senderWebText", column = "sender_web_text"),
			@Result(property = "senderEmailSubject", column = "sender_email_subject"),
			@Result(property = "senderEmailBody", column = "sender_email_body"),
			@Result(property = "recipientWebText", column = "recipient_web_text"),
			@Result(property = "recipientEmailSubject", column = "recipient_email_subject"),
			@Result(property = "recipientEmailBody", column = "recipient_email_body"),
			@Result(property = "webLogo", column = "web_logo"),
			@Result(property = "emailLogo", column = "email_logo"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_ALL)
	List<CampaignTemplate> findAllCampaignTemplates();
	
	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "applicationId", column = "application_id"),
			@Result(property = "name", column = "name"),
			@Result(property = "senderWebText", column = "sender_web_text"),
			@Result(property = "senderEmailSubject", column = "sender_email_subject"),
			@Result(property = "senderEmailBody", column = "sender_email_body"),
			@Result(property = "recipientWebText", column = "recipient_web_text"),
			@Result(property = "recipientEmailSubject", column = "recipient_email_subject"),
			@Result(property = "recipientEmailBody", column = "recipient_email_body"),
			@Result(property = "webLogo", column = "web_logo"),
			@Result(property = "emailLogo", column = "email_logo"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_BY_APPLICATION_ID)
	List<CampaignTemplate> findByApplicationId(String applicationId);
	
}
