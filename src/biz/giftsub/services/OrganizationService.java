package biz.giftsub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.giftsub.daos.OrganizationMapper;
import biz.giftsub.models.Organization;

@Component
public class OrganizationService {
	
	@Autowired
	OrganizationMapper organizationMapper;

	public Organization getSnapshot(String organizationId) {
		Organization org = organizationMapper.calculateRevenueAndGiftsSold(organizationId);

		Organization org2 = organizationMapper.getActiveCampaign(organizationId);
		org.setActiveCampaignId(org2.getActiveCampaignId());
		
		List<String> listOfCampaigns = organizationMapper.getDistinctCampaigns(organizationId);
		org.setTotalCampaigns(listOfCampaigns.size());

		return org;
	}

	public Organization getOrganizationByPath(String path) {
		return organizationMapper.getOrganizationByPath(path);
	}

	public Organization getOrganizationByCampaignId(String campaignId) {
		return organizationMapper.getOrganizationByCampaignId(campaignId);
	}

}
