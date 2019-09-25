package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.Campaign;

public interface CampaignMapper {

	final String INSERT = "INSERT INTO campaign "
			+ "(id, campaign_template_id, application_id, name, sender_web_text, sender_email_subject, sender_email_body, "
			+ "recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, email_logo, application_name, "
			+ "callback_api, website_url, itunes_url, google_play_store_url, status, start_date, end_date, create_dttm, update_dttm) "
			+ "values (#{id}, #{campaignTemplateId}, #{applicationId}, #{name}, #{senderWebText}, #{senderEmailSubject}, "
			+ "#{senderEmailBody}, #{recipientWebText}, #{recipientEmailSubject}, #{recipientEmailBody}, #{webLogo}, #{emailLogo}, "
			+ "#{applicationName}, #{callbackApi},#{websiteUrl},#{itunesUrl},#{googleAppStoreUrl},#{status}, #{startDate}, "
			+ "#{endDate}, #{createDttm}, #{updateDttm})";

	final String SELECT_BY_ID = "select id, campaign_template_id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo,  application_name, callback_api, website_url, itunes_url, google_play_store_url, status, start_date, "
			+ "end_date, create_dttm, update_dttm from campaign WHERE id=#{id}";
	
	final String SELECT_BY_CAMPAIGN_TEMPLATE_ID = "select id, campaign_template_id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo,  application_name, callback_api, website_url, itunes_url, google_play_store_url, status, start_date, "
			+ "end_date, create_dttm, update_dttm from campaign WHERE campaign_template_id=#{campaignTemplateId}";

	final String SELECT_BY_APPLICATION_ID = "select id, campaign_template_id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo,  application_name, callback_api, website_url, itunes_url, google_play_store_url, status, start_date, "
			+ "end_date, create_dttm, update_dttm from campaign WHERE application_id=#{applicationId}";
	
	final String SELECT_ALL = "select id, campaign_template_id, application_id, name, sender_web_text, sender_email_subject, "
			+ "sender_email_body, recipient_web_text, recipient_email_subject, recipient_email_body, web_logo, "
			+ "email_logo, application_name, callback_api, website_url, itunes_url, google_play_store_url, status, start_date, "
			+ "end_date, create_dttm, update_dttm from campaign";

	final String UPDATE = "UPDATE campaign set application_id=#{applicationId}, campaign_template_id=#{campaignTemplateId}, name=#{name}, "
			+ "sender_web_text=#{senderWebText}, sender_email_subject=#{senderEmailSubject}, "
			+ "sender_email_body=#{senderEmailBody},recipient_web_text=#{recipientWebText}, "
			+ "recipient_email_subject=#{recipientEmailSubject}, recipient_email_body=#{recipientEmailBody}, "
			+ "web_logo=#{webLogo}, email_logo=#{emailLogo}, application_name=#{applicationName}, callback_api=#{callbackApi}, website_url=#{websiteUrl}, "
			+ "itunes_url=#{itunesUrl}, google_play_store_url=#{googleAppStoreUrl}, status=#{status}, start_date=#{startDate},  end_date=#{endDate} where id=#{id}";

	@Update(UPDATE)
	int updateCampaign(Campaign campaign);
	
	@Insert(INSERT)
	int insertCampaign(Campaign campaign);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
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
			@Result(property = "applicationName", column = "application_name"),
			@Result(property = "callbackApi", column = "callback_api"),
			@Result(property = "websiteUrl", column = "website_url"),
			@Result(property = "itunesUrl", column = "itunes_url"),
			@Result(property = "googleAppStoreUrl", column = "google_play_store_url"),
			@Result(property = "status", column = "status"),
			@Result(property = "startDate", column = "start_date"),
			@Result(property = "endDate", column = "end_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_BY_ID)
	Campaign findCampaignById(String id);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
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
			@Result(property = "applicationName", column = "application_name"),
			@Result(property = "callbackApi", column = "callback_api"),
			@Result(property = "websiteUrl", column = "website_url"),
			@Result(property = "itunesUrl", column = "itunes_url"),
			@Result(property = "googleAppStoreUrl", column = "google_play_store_url"),
			@Result(property = "status", column = "status"),
			@Result(property = "startDate", column = "start_date"),
			@Result(property = "endDate", column = "end_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_ALL)
	List<Campaign> findAllCampaigns();
	
	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
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
			@Result(property = "applicationName", column = "application_name"),
			@Result(property = "callbackApi", column = "callback_api"),
			@Result(property = "websiteUrl", column = "website_url"),
			@Result(property = "itunesUrl", column = "itunes_url"),
			@Result(property = "googleAppStoreUrl", column = "google_play_store_url"),
			@Result(property = "status", column = "status"),
			@Result(property = "startDate", column = "start_date"),
			@Result(property = "endDate", column = "end_date"),
			@Result(property = "createDttm", column = "create_dttm"),
			@Result(property = "updateDttm", column = "update_dttm")
	})
	@Select(SELECT_BY_CAMPAIGN_TEMPLATE_ID)
	List<Campaign> findByCampaignTemplateId(String campaignTemplateId);
}
