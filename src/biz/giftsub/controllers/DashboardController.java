package biz.giftsub.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import biz.giftsub.models.Campaign;
import biz.giftsub.models.DashboardCampaign;
import biz.giftsub.models.DashboardCampaignReport;
import biz.giftsub.models.DashboardEdges;
import biz.giftsub.models.DashboardNameIntegerValuePair;
import biz.giftsub.models.DashboardNodes;
import biz.giftsub.models.DashboardOrganizationSnapshot;
import biz.giftsub.models.Gift;
import biz.giftsub.models.Organization;
import biz.giftsub.models.ReportsDto;
import biz.giftsub.services.CampaignService;
import biz.giftsub.services.OrganizationService;

@ComponentScan
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:9000"})
@RequestMapping("/dashboard/v1")
public class DashboardController {

    @Autowired
    CampaignService campaignService;
    @Autowired
    OrganizationService organizationService;

    Logger logger = Logger.getLogger(DashboardController.class);

    @RequestMapping(value = "/organizations/{organizationId}/campaigns", method = RequestMethod.GET)
    public List<DashboardCampaign> getCampaigns(@PathVariable String organizationId) {
        List<Campaign> campaigns = campaignService.getAllCampaigns(organizationId);
        List<DashboardCampaign> dashboardCampaigns = copyFromCampaignsToDashboardCampaigns(campaigns);
        return dashboardCampaigns;
    }

    @RequestMapping(value = "/organizations/{organizationId}/snapshot", method = RequestMethod.GET)
    public DashboardOrganizationSnapshot getOrganizationSnapshot(@PathVariable String organizationId) {
    	Organization org = organizationService.getSnapshot(organizationId);
    	DashboardOrganizationSnapshot d = copyFromOrganizationToDashboardOrganizationSnapshot(org);
    	return d;
    }

	@RequestMapping(value = "/campaigns/{campaignId}", method = RequestMethod.GET)
    public DashboardCampaign getCampaign(@PathVariable String campaignId) {
        Campaign campaign = campaignService.getCampaignById(campaignId);
        DashboardCampaign d = copyFromCampaignToDashboardCampaign(campaign);
        return d;
    }

	@RequestMapping(value = "/campaigns/{campaignId}", method = RequestMethod.PUT)
    public DashboardCampaign updateCampaign(@PathVariable String campaignId, @RequestBody DashboardCampaign dashboardCampaign) {
		Preconditions.checkArgument(campaignId.equals(dashboardCampaign.getId()));
		Campaign campaignToUpdate = copyFromDashboardCampaignToCampaign(dashboardCampaign);
		Campaign campaign = campaignService.updateCampaign(campaignToUpdate);
		DashboardCampaign updatedDashboardCampaign = copyFromCampaignToDashboardCampaign(campaign);
		return updatedDashboardCampaign;
    }

	@RequestMapping(value = "/campaigns/{campaignId}/duplicate", method = RequestMethod.POST)
	public DashboardCampaign duplicateCampaign(@PathVariable String campaignId) {
		Campaign campaign = campaignService.duplicateCampaign(campaignId);
		DashboardCampaign dashboardCampaign = copyFromCampaignToDashboardCampaign(campaign);
		return dashboardCampaign;
	}

	@RequestMapping(value = "/campaigns/{campaignId}/stop", method = RequestMethod.PUT)
	public DashboardCampaign stopCampaign(@PathVariable String campaignId) {
		Campaign campaign = campaignService.stopCampaign(campaignId);
		DashboardCampaign dashboardCampaign = copyFromCampaignToDashboardCampaign(campaign);
		return dashboardCampaign;
	}

	@RequestMapping(value = "/campaigns/{campaignId}/start", method = RequestMethod.PUT)
	public DashboardCampaign startCampaign(@PathVariable String campaignId) {
		Campaign campaign = campaignService.startCampaign(campaignId);
		DashboardCampaign dashboardCampaign = copyFromCampaignToDashboardCampaign(campaign);
		return dashboardCampaign;
	}

	@RequestMapping(value = "/campaigns", method = RequestMethod.POST)
    public DashboardCampaign createCampaign(@RequestBody DashboardCampaign dashboardCampaign) {
    	Campaign campaignToCreate = copyFromDashboardCampaignToCampaign(dashboardCampaign);
    	campaignToCreate.setOrganizationId("G001");
    	Campaign campaign = campaignService.createCampaign(campaignToCreate);
    	DashboardCampaign createdDashboardCampaign = copyFromCampaignToDashboardCampaign(campaign);
    	return createdDashboardCampaign;
    }

	@RequestMapping(value = "/campaigns/{campaignId}/giftssold", method = RequestMethod.GET)
	public DashboardCampaignReport getCampaignGiftsSold(@PathVariable String campaignId) {
		List<ReportsDto> r = campaignService.getCampaignGiftsSold(campaignId);
		DashboardCampaignReport d = copyFromReportsDtoToDashboardCampaignReport(r);
		return d;
	}

	@RequestMapping(value = "/campaigns/{campaignId}/revenue", method = RequestMethod.GET)
	public DashboardCampaignReport getCampaignRevenue(@PathVariable String campaignId) {
		List<ReportsDto> r = campaignService.getCampaignRevenue(campaignId);
		DashboardCampaignReport d = copyFromReportsDtoToDashboardCampaignReport(r);
		return d;
	}

	@RequestMapping(value = "/campaigns/{campaignId}/funnel", method = RequestMethod.GET)
	public DashboardCampaignReport getCampaignFunnel(@PathVariable String campaignId) {
		ReportsDto r = campaignService.getCampaignFunnel(campaignId);
		DashboardCampaignReport d = mapFromReportsDtoToDashboardFunnel(r);
		return d;
	}

	@RequestMapping(value = "/campaigns/{campaignId}/network", method = RequestMethod.GET)
	public DashboardCampaignReport getCampaignNetworkGraph(@PathVariable String campaignId) {
		List<ReportsDto> r = campaignService.getCampaignNetworkGraph(campaignId);
		DashboardCampaignReport d = mapFromReportsDtoToDashboardNetworkGraph(r);
		return d;
	}

	private DashboardCampaign copyFromCampaignToDashboardCampaign(Campaign c) {
		DashboardCampaign d = new DashboardCampaign();
		BeanUtils.copyProperties(c, d);
		if (!Strings.isNullOrEmpty(c.getGift1Name())) addCampaignGiftToDashboardCampaign(c.getGift1Name(), c.getGift1Price(), d); 
		if (!Strings.isNullOrEmpty(c.getGift2Name())) addCampaignGiftToDashboardCampaign(c.getGift2Name(), c.getGift2Price(), d); 
		if (!Strings.isNullOrEmpty(c.getGift3Name())) addCampaignGiftToDashboardCampaign(c.getGift3Name(), c.getGift3Price(), d); 
		return d;
	}

	private Campaign copyFromDashboardCampaignToCampaign(DashboardCampaign d) {
		Campaign c = new Campaign();
		BeanUtils.copyProperties(d, c);
		if ((d.getGifts().size() > 0) && (null != d.getGifts().get(0))) {
			c.setGift1Name(d.getGifts().get(0).getName());
			c.setGift1Price(d.getGifts().get(0).getPrice());
		}
		if ((d.getGifts().size() > 1) && (null != d.getGifts().get(1))) {
			c.setGift2Name(d.getGifts().get(1).getName());
			c.setGift2Price(d.getGifts().get(1).getPrice());
		}
		if ((d.getGifts().size() > 2) && (null != d.getGifts().get(2))) {
			c.setGift3Name(d.getGifts().get(2).getName());
			c.setGift3Price(d.getGifts().get(2).getPrice());
		}
		return c;
	}

	private List<DashboardCampaign> copyFromCampaignsToDashboardCampaigns(List<Campaign> campaigns) {
    	List<DashboardCampaign> dashboardCampaigns = new ArrayList<DashboardCampaign>();
    	for (Campaign c : campaigns) {
    		dashboardCampaigns.add(copyFromCampaignToDashboardCampaign(c));
    	}
		return dashboardCampaigns;
	}

    private void addCampaignGiftToDashboardCampaign(String giftName, BigDecimal giftPrice, DashboardCampaign d) {
    	List<Gift> giftList = (null != d.getGifts()) ? d.getGifts() : new ArrayList<Gift>();
    	Gift gift = new Gift();
    	gift.setName(giftName);
    	gift.setPrice(giftPrice);
		giftList.add(gift);
		d.setGifts(giftList);
	}

    private DashboardOrganizationSnapshot copyFromOrganizationToDashboardOrganizationSnapshot(Organization org) {
    	DashboardOrganizationSnapshot snapshot = new DashboardOrganizationSnapshot();
    	BeanUtils.copyProperties(org, snapshot);
		return snapshot;
	}

	private DashboardCampaignReport copyFromReportsDtoToDashboardCampaignReport(List<ReportsDto> reportList) {
    	DashboardCampaignReport d = new DashboardCampaignReport();
    	d.setxAxisDataInEpochs(new ArrayList<Long>());
    	d.setSeriesDataInIntegers(new ArrayList<Integer>());
    	d.setSeriesDataInBigDecimal(new ArrayList<BigDecimal>());
    	for (ReportsDto r : reportList) {
    		d.getxAxisDataInEpochs().add(r.getEpoch());
    		d.getSeriesDataInIntegers().add(r.getIntegerData());
    		d.getSeriesDataInBigDecimal().add(r.getBigDecimalData());
    	}
		return d;
	}

	private DashboardCampaignReport mapFromReportsDtoToDashboardFunnel(ReportsDto r) {
    	DashboardCampaignReport d = new DashboardCampaignReport();
    	d.setNameIntegerValuePairs(new ArrayList<DashboardNameIntegerValuePair>());
    	d.setLegend(new ArrayList<String>());
    	d.getNameIntegerValuePairs().add(new DashboardNameIntegerValuePair("Purchases", r.getTotalSales()));
    	d.getLegend().add("Purchases");
    	d.getNameIntegerValuePairs().add(new DashboardNameIntegerValuePair("Emails Opened", r.getTotalEmailsOpened()));
    	d.getLegend().add("Emails Opened");
    	d.getNameIntegerValuePairs().add(new DashboardNameIntegerValuePair("Claims", r.getTotalClaims()));
    	d.getLegend().add("Claims");
    	d.setSeriesMaxInInteger(r.getTotalSales());
		return d;
	}

	private DashboardCampaignReport mapFromReportsDtoToDashboardNetworkGraph(List<ReportsDto> reportList) {
    	DashboardCampaignReport d = new DashboardCampaignReport();
    	d.setNodes(new ArrayList<DashboardNodes>());
    	d.setEdges(new ArrayList<DashboardEdges>());
    	List<String> nodeLabels = new ArrayList<String>();
    	for (ReportsDto r : reportList) {
    		d.getEdges().add(new DashboardEdges(r.getFromNode(), r.getToNode()));
    		if (!nodeLabels.contains(r.getFromNode())) {
    			d.getNodes().add(new DashboardNodes(r.getFromNode(), r.getFromNode()));
    			nodeLabels.add(r.getFromNode());
    		}
    		if (!nodeLabels.contains(r.getToNode())) {
    			d.getNodes().add(new DashboardNodes(r.getToNode(), r.getToNode()));
    			nodeLabels.add(r.getToNode());
    		}
    	}
		return d;
	}

}
