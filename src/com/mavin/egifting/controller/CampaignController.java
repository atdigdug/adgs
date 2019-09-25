package com.mavin.egifting.controller;

import com.mavin.egifting.model.Campaign;
import com.mavin.egifting.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/services/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    Logger logger = Logger.getLogger(CampaignController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Campaign saveCampaign(@RequestBody Campaign campaign) {
        logger.info("Entering saveCampaign() - " + campaign);
        //TODO(SriramK) - Check pre conditions
        campaign = campaignService.createCampaign(campaign);
        logger.info("Exiting saveCampaign() - " + campaign);
        return campaign;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        logger.info("Entering updateCampaign() - " + campaign);
        campaign = campaignService.updateCampaign(campaign);
        logger.info("Exiting updateCampaign() - " + campaign);
        return campaign;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Campaign> getCampaigns() {
        logger.info("Entering getCampaigns()");
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        logger.info("Exiting updateCampaignTemplate() - " + campaigns);
        return campaigns;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Campaign getCampaigns(@PathVariable String templateId) {
        logger.info("Entering getCampaigns() - " + templateId);
        List<Campaign> campaigns = campaignService.getByCampaignTemplateId(templateId);
        logger.info("Exiting getCampaigns() - " + campaigns);
        if (campaigns != null && campaigns.size() > 0)
            return campaigns.get(0);
        return new Campaign();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Campaign getCampaign(@PathVariable String campaignId) {
        logger.info("Entering getCampaign() - " + campaignId);
        Campaign campaign = campaignService.getCampaignById(campaignId);
        logger.info("Exiting getCampaign() - " + campaign);
        return campaign;
    }

}
