package biz.giftsub.daos;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import biz.giftsub.models.Organization;

public interface OrganizationMapper {

	final String SELECT_SNAPSHOT = ""
			+ "SELECT c.id, SUM(s.gift_value) AS revenue, COUNT(*) AS gifts_sold "
			+ "FROM sale AS s, campaign AS c "
			+ "WHERE c.organization_id=#{organizationId} AND "
			+ "s.campaign_id=c.id "
			+ "GROUP BY c.organization_id";	
	final String SELECT_ACTIVE_CAMPAIGN_ID = ""
			+ "SELECT id "
			+ "FROM campaign "
			+ "WHERE organization_id=#{organizationId} AND STATUS='ACTIVE'";
	final String SELECT_DISTINCT_REPORT_CAMPAIGNS = ""
			+ "SELECT DISTINCT id "
			+ "FROM campaign "
			+ "WHERE status != 'DRAFT' AND organization_id=#{organizationId}";
	final String SELECT_BY_PATH = ""
			+ "SELECT id,name,text_color,background_color "
			+ "FROM organization "
			+ "WHERE website_path=#{path}";
	final String SELECT_BY_CAMPAIGNID = ""
			+ "SELECT o.id,o.name,o.text_color,o.background_color "
			+ "FROM organization AS o, campaign "
			+ "WHERE o.id = campaign.organization_id AND campaign.id=#{campaignId}";

	@Results(value = { 
		@Result(property = "id", column = "id"),
		@Result(property = "revenue", column = "revenue"),
		@Result(property = "giftsSold", column = "gifts_sold")
	})
	@Select(SELECT_SNAPSHOT)
	Organization calculateRevenueAndGiftsSold(String organizationId);

	@Results(value = { 
		@Result(property = "activeCampaignId", column = "id")
	})
	@Select(SELECT_ACTIVE_CAMPAIGN_ID)
	Organization getActiveCampaign(String organizationId);
	
	@ResultType(value = String.class)
	@Select(SELECT_DISTINCT_REPORT_CAMPAIGNS)
	List<String> getDistinctCampaigns(String organizationId);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "textColor", column = "text_color"),
			@Result(property = "backgroundColor", column = "background_color")
		})
	@Select(SELECT_BY_PATH)
	Organization getOrganizationByPath(String path);

	@Results(value = { 
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "textColor", column = "text_color"),
			@Result(property = "backgroundColor", column = "background_color")
		})
	@Select(SELECT_BY_CAMPAIGNID)
	Organization getOrganizationByCampaignId(String campaignId);

}
