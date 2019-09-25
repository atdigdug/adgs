package com.mavin.egifting.controller;

import com.mavin.egifting.model.CampaignTemplate;
import com.mavin.egifting.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/services/campaign/template")
public class TemplateController {

    @Autowired
    CampaignTemplateService campaignTemplateService;

    Logger logger = Logger.getLogger(TemplateController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CampaignTemplate saveCampaignTemplate(@RequestBody CampaignTemplate campaignTemplate) {
        logger.info("Entering saveCampaignTemplate() - " + campaignTemplate);
        //TODO(SriramK) - Check pre conditions
        campaignTemplate = campaignTemplateService.createCampaignTemplate(campaignTemplate);
        logger.info("Exiting saveCampaignTemplate() - " + campaignTemplate);
        return campaignTemplate;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public CampaignTemplate updateCampaignTemplate(@RequestBody CampaignTemplate campaignTemplate) {
        logger.info("Entering updateCampaignTemplate() - " + campaignTemplate);
        campaignTemplate = campaignTemplateService.updateCampaignTemplate(campaignTemplate);
        logger.info("Exiting updateCampaignTemplate() - " + campaignTemplate);
        return campaignTemplate;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list/{applicationId}", method = RequestMethod.GET)
    public List<CampaignTemplate> getCampaignTemplates(@PathVariable String applicationId) {
        logger.info("Entering getCampaignTemplates() - " + applicationId);
        List<CampaignTemplate> campaignTemplates = campaignTemplateService.getByApplicationId(applicationId);
        logger.info("Exiting updateCampaignTemplate() - " + campaignTemplates);
        return campaignTemplates;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CampaignTemplate getCampaignTemplate(@PathVariable String id) {
        logger.info("Entering getCampaignTemplate() - " + id);
        CampaignTemplate campaignTemplate = campaignTemplateService.getCampaignTemplateById(id);
        logger.info("Exiting getCampaignTemplate() - " + campaignTemplate);
        return campaignTemplate;
    }

}
