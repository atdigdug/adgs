package biz.giftsub.daos;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import biz.giftsub.models.Campaign;
import biz.giftsub.models.ReportsDto;

public interface CampaignMapper {

	final String SELECT_ALL =
		  "select id, name, status, "
		+ "web_text, email_subject, email_body, "
		+ "gift_1_name, gift_1_price, gift_2_name, gift_2_price, gift_3_name, gift_3_price, "
		+ "status, start_date, end_date, "
		+ "create_timestamp, update_timestamp "
		+ "from campaign WHERE organization_id=#{organizationId}";

	final String SELECT_BY_ID =
		  "select id, organization_id, name, status, "
		+ "web_text, email_subject, email_body, "
		+ "gift_1_name, gift_1_price, gift_2_name, gift_2_price, gift_3_name, gift_3_price, "
		+ "status, start_date, end_date, "
		+ "create_timestamp, update_timestamp "
		+ "from campaign WHERE id=#{id}";
	
	final String SELECT_ACTIVE_BY_ORGPATH = ""
			+ "select campaign.id, campaign.name, "
			+ "web_text, email_subject, email_body, "
			+ "gift_1_name, gift_1_price, gift_2_name, gift_2_price, gift_3_name, gift_3_price, "
			+ "status, start_date, end_date "
			+ "from campaign,organization WHERE "
			+ "organization.website_path=#{organizationId} and "
			+ "organization.id=campaign.organization_id and "
			+ "status='ACTIVE'";
	
	final String UPDATE = 
			  "UPDATE campaign set "
			+ "name=#{name}, "
			+ "web_text=#{webText}, "
			+ "email_subject=#{emailSubject}, email_body=#{emailText}, "
			+ "status=#{status}, start_date=#{startTimestamp},  end_date=#{endTimestamp}, "
			+ "gift_1_name=#{gift1Name}, gift_1_price=#{gift1Price}, "
			+ "gift_2_name=#{gift2Name}, gift_2_price=#{gift2Price}, "
			+ "gift_3_name=#{gift3Name}, gift_3_price=#{gift3Price} "
			+ "where id=#{id}";

	final String INSERT = 
			  "INSERT INTO campaign ("
			+ "id, organization_id, name, web_text, "
			+ "email_subject, email_body, "
			+ "gift_1_name, gift_1_price, gift_2_name, gift_2_price, gift_3_name, gift_3_price, "
			+ "start_date, end_date, status"
			+ ") values ("
			+ "#{id}, #{organizationId}, #{name}, #{webText}, "
			+ "#{emailSubject}, #{emailText}, "
			+ "#{gift1Name}, #{gift1Price}, #{gift2Name}, #{gift2Price}, #{gift3Name}, #{gift3Price}, "
			+ "#{startTimestamp}, #{endTimestamp}, #{status}"
			+ ")";

	final String CALC_GIFTS_SOLD = ""
			+ "SELECT UNIX_TIMESTAMP(DATE(transaction_date))*1000 AS epoch_date, COUNT(*) AS gifts_sold "
			+ "FROM sale "
			+ "WHERE campaign_id=#{campaignId} "
			+ "GROUP BY epoch_date "
			+ "ORDER BY epoch_date";

	final String CALC_REVENUE = ""
			+ "SELECT daily.epoch_date, daily.daily_revenue, "
			+ " (@runtot := @runtot + daily.daily_revenue) AS total_revenue "
			+ "FROM ( "
			+ "	SELECT UNIX_TIMESTAMP(DATE(transaction_date))*1000 AS epoch_date, SUM(gift_value) AS daily_revenue "
			+ "	FROM sale "
			+ "	WHERE campaign_id=#{campaignId} "
			+ "	GROUP BY epoch_date "
			+ "	ORDER BY epoch_date "
			+ "	) AS daily, "
			+ "	(SELECT @runtot:=0) AS n";

	String CALC_FUNNEL = ""
			+ "SELECT COUNT(*) AS total_sales, COUNT(email_open_date) AS total_emails_opened, COUNT(gift_claim_date) AS total_claims "
			+ "FROM sale "
			+ "WHERE campaign_id=#{campaignId}";

	String CALC_NETWORK_GRAPH = ""
			+ "SELECT LOWER(sender_email) as sender_email, LOWER(recipient_email) as recipient_email "
			+ "FROM sale "
			+ "WHERE campaign_id=#{campaignId}";
	
	@Results(value = { 
		@Result(property = "id", column = "id"),
		@Result(property = "organizationId", column = "organization_id"),
		@Result(property = "name", column = "name"),
		@Result(property = "status", column = "status"),
		@Result(property = "startTimestamp", column = "start_date"),
		@Result(property = "endTimestamp", column = "end_date"),
		@Result(property = "webText", column = "web_text"),
		@Result(property = "emailSubject", column = "email_subject"),
		@Result(property = "emailText", column = "email_body"),
		@Result(property = "gift1Name", column = "gift_1_name"),
		@Result(property = "gift1Price", column = "gift_1_price"),
		@Result(property = "gift2Name", column = "gift_2_name"),
		@Result(property = "gift2Price", column = "gift_2_price"),
		@Result(property = "gift3Name", column = "gift_3_name"),
		@Result(property = "gift3Price", column = "gift_3_price"),
		@Result(property = "createTimestamp", column = "create_timestamp"),
		@Result(property = "updateTimestamp", column = "update_timestamp")
	})
	@Select(SELECT_ALL)
	List<Campaign> findAllCampaigns(String organizationId);
	
	@Results(value = { 
		@Result(property = "id", column = "id"),
		@Result(property = "organizationId", column = "organization_id"),
		@Result(property = "name", column = "name"),
		@Result(property = "status", column = "status"),
		@Result(property = "startTimestamp", column = "start_date"),
		@Result(property = "endTimestamp", column = "end_date"),
		@Result(property = "webText", column = "web_text"),
		@Result(property = "emailSubject", column = "email_subject"),
		@Result(property = "emailText", column = "email_body"),
		@Result(property = "gift1Name", column = "gift_1_name"),
		@Result(property = "gift1Price", column = "gift_1_price"),
		@Result(property = "gift2Name", column = "gift_2_name"),
		@Result(property = "gift2Price", column = "gift_2_price"),
		@Result(property = "gift3Name", column = "gift_3_name"),
		@Result(property = "gift3Price", column = "gift_3_price"),
		@Result(property = "createTimestamp", column = "create_timestamp"),
		@Result(property = "updateTimestamp", column = "update_timestamp")
	})
	@Select(SELECT_BY_ID)
	Campaign findCampaignById(String id);

	@Results(value = { 
		@Result(property = "id", column = "id"),
		@Result(property = "organizationId", column = "organization_id"),
		@Result(property = "name", column = "name"),
		@Result(property = "status", column = "status"),
		@Result(property = "startTimestamp", column = "start_date"),
		@Result(property = "endTimestamp", column = "end_date"),
		@Result(property = "webText", column = "web_text"),
		@Result(property = "emailSubject", column = "email_subject"),
		@Result(property = "emailText", column = "email_body"),
		@Result(property = "gift1Name", column = "gift_1_name"),
		@Result(property = "gift1Price", column = "gift_1_price"),
		@Result(property = "gift2Name", column = "gift_2_name"),
		@Result(property = "gift2Price", column = "gift_2_price"),
		@Result(property = "gift3Name", column = "gift_3_name"),
		@Result(property = "gift3Price", column = "gift_3_price"),
		@Result(property = "createTimestamp", column = "create_timestamp"),
		@Result(property = "updateTimestamp", column = "update_timestamp")
	})
	@Select(SELECT_ACTIVE_BY_ORGPATH)
	Campaign findActiveCampaignByOrganizationPath(String organizationPath);
	
	@Update(UPDATE)
	int updateCampaign(Campaign campaign);

	@Insert(INSERT)
	int insertCampaign(Campaign campaign);
	
	@Results(value = { 
			@Result(property = "epoch", column = "epoch_date"),
			@Result(property = "integerData", column = "gifts_sold")
		})
	@Select(CALC_GIFTS_SOLD)
	List<ReportsDto> calcGiftsSold(String campaignId);

	@Results(value = { 
			@Result(property = "epoch", column = "epoch_date"),
			@Result(property = "bigDecimalData", column = "total_revenue")
		})
	@Select(CALC_REVENUE)
	List<ReportsDto> calcRevenue(String campaignId);

	@Results(value = { 
			@Result(property = "totalSales", column = "total_sales"),
			@Result(property = "totalEmailsOpened", column = "total_emails_opened"),
			@Result(property = "totalClaims", column = "total_claims")
		})
	@Select(CALC_FUNNEL)
	ReportsDto calcFunnel(String campaignId);

	@Results(value = { 
			@Result(property = "fromNode", column = "sender_email"),
			@Result(property = "toNode", column = "recipient_email")
		})
	@Select(CALC_NETWORK_GRAPH)
	List<ReportsDto> calcNetworkGraph(String campaignId);

}
