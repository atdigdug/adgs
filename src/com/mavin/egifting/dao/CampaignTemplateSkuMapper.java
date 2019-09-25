package com.mavin.egifting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mavin.egifting.model.CampaignTemplateSku;

public interface CampaignTemplateSkuMapper {

	final String INSERT = "INSERT INTO campaign_template_sku "
			+ "(id, application_sku_id, campaign_template_id, create_dttm) "
			+ "values (#{id}, #{applicationSkuId}, #{campaignTemplateId},#{createDttm})";

	final String SELECT_BY_ID = "select id, application_sku_id, campaign_template_id, create_dttm from campaign_template_sku WHERE id=#{id}";
	
	final String DELETE_BY_ID = "delete from campaign_template_sku WHERE id=#{id}";
	
	final String SELECT_BY_CAMPAIGN_TEMPLATE_ID = "select id, application_sku_id, campaign_template_id, create_dttm "
			+ "from campaign_template_sku WHERE campaign_template_id=#{campaignTemplateId}";

	final String SELECT_ALL = "select id, application_sku_id, campaign_template_id, create_dttm from campaign_template_sku";

	@Insert(INSERT)
	int insertCampaignTemplateSku(CampaignTemplateSku campaignTemplateSku);
	
	@Insert(DELETE_BY_ID)
	int deleteCampaignTemplateSku(String id);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applicationSkuId", column = "application_sku_id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_BY_ID)
	CampaignTemplateSku findCampaignTemplateSkuById(String id);

	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applicationSkuId", column = "application_sku_id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_ALL)
	List<CampaignTemplateSku> findCampaignTemplateSkus();
	
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "applicationSkuId", column = "application_sku_id"),
			@Result(property = "campaignTemplateId", column = "campaign_template_id"),
			@Result(property = "createDttm", column = "create_dttm") })
	@Select(SELECT_BY_CAMPAIGN_TEMPLATE_ID)
	List<CampaignTemplateSku> findByCampaignTemplateId(String campaignTemplateId);

}
