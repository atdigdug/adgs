package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mavin.egifting.model.WebviewAnalytics;

public interface WebviewAnalyticsMapper {

	final String INSERT = "INSERT INTO webview_analytics " + "(id, cookie_guid, campaign_id, sender_landing_page_date)"
			+ "values (#{id}, #{cookieGuid}, #{campaignId}, #{senderLandingPageDate})";

	final String SELECT_BY_ID = "select id, cookie_guid, campaign_id, sender_landing_page_date from webview_analytics WHERE id=#{id}";
	
	final String SELECT_COUNT_BY_CAMPAIGN_ID = "select count(*) from webview_analytics where campaign_id=#{campaignId}";

	final String SELECT_ALL = "select id, cookie_guid, campaign_id, sender_landing_page_date from webview_analytics";

	final String UPDATE = "UPDATE webview_analytics set cookie_guid=#{cookieGuid}, campaign_id=#{campaignId}, sender_landing_page_date=#{senderLandingPageDate} where id=#{id}";

	@Select(SELECT_COUNT_BY_CAMPAIGN_ID)
	int findCountByCampaignId(String campaignId);
	
	@Update(UPDATE)
	int updateWebviewAnalytics(WebviewAnalytics webviewAnalytics);

	@Insert(INSERT)
	int insertWebviewAnalytics(WebviewAnalytics webviewAnalytics);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "cookieGuid", column = "cookie_guid"),
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "senderLandingPageDate", column = "sender_landing_page_date") })
	@Select(SELECT_BY_ID)
	WebviewAnalytics findWebviewAnalyticsById(String id);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "cookieGuid", column = "cookie_guid"),
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "senderLandingPageDate", column = "sender_landing_page_date") })
	@Select(SELECT_ALL)
	List<WebviewAnalytics> findAllWebviewAnalytics();

}
