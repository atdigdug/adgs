package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mavin.egifting.model.CampaignSku;

public interface CampaignSkuMapper {

	final String INSERT = "INSERT INTO campaign_sku "
			+ "(id, campaign_id, campaign_template_sku_id, sku_id, name, price, create_dttm) "
			+ "values (#{id}, #{campaignId}, #{campaignTemplateSkuId}, #{skuId}, #{name}, #{price}, #{createDttm})";

	final String SELECT_BY_ID = "select id, campaign_id, campaign_template_sku_id, sku_id, name, price, create_dttm from campaign_sku WHERE id=#{id}";
	
	final String SELECT_BY_CAMPAIGN_ID = "select id, campaign_id, campaign_template_sku_id, sku_id, name, price, create_dttm "
			+ "from campaign_sku WHERE campaign_id=#{campaignId}";

	final String SELECT_ALL = "select idid, campaign_id, campaign_template_sku_id, sku_id, name, price, create_dttm from campaign_sku";

	@Insert(INSERT)
	int insertCampaignSku(CampaignSku campaignSku);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "campaignTemplateSkuId", column = "campaign_template_sku_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_BY_ID)
	CampaignSku findCampaignSkuById(String id);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "campaignTemplateSkuId", column = "campaign_template_sku_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_ALL)
	List<CampaignSku> findCampaignSkus();
	
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "campaignId", column = "campaign_id"),
			@Result(property = "campaignTemplateSkuId", column = "campaign_template_sku_id"),
			@Result(property = "skuId", column = "sku_id"), 
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"), 
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_BY_CAMPAIGN_ID)
	List<CampaignSku> findByCampaignId(String campaignId);
}
