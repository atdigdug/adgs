package com.mavin.egifting.controller;

import com.mavin.egifting.model.ApplicationSku;
import com.mavin.egifting.model.CampaignSku;
import com.mavin.egifting.model.CampaignTemplateSku;
import com.mavin.egifting.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/services")
public class SkuController {

    @Autowired
    ApplicationSkuService applicationSkuService;
    @Autowired
    CampaignSkuService campaignSkuService;
    @Autowired
    CampaignTemplateSkuService campaignTemplateSkuService;

    Logger logger = Logger.getLogger(SkuController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/application/sku/list/{applicationId}", method = RequestMethod.GET)
    public List<ApplicationSku> getApplicationSkus(@PathVariable String applicationId) {
        logger.info("Entering getApplicationSKUs()");
        List<ApplicationSku> skus = applicationSkuService.getByApplicationId(applicationId);
        logger.info("Exiting getApplicationSKUs() - " + skus);
        return skus;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/application/sku/update", method = RequestMethod.POST)
    public List<ApplicationSku> updateApplicationSkus(@RequestBody List<ApplicationSku> applicationSkus) {
        logger.info("Entering updateApplicationSkus() - " + applicationSkus);
        List<ApplicationSku> createdSkus = new ArrayList<>();
        for (ApplicationSku sku : applicationSkus) {
            if (sku.getId() == null) {
                createdSkus.add(applicationSkuService.createApplicationSku(sku));
            }
        }
        logger.info("Exiting updateApplicationSkus() - " + createdSkus);
        return createdSkus;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/campaign/template/skus/create", method = RequestMethod.POST)
    public List<CampaignTemplateSku> createCampaignTemplateSkus(@RequestBody List<CampaignTemplateSku> skus) {
        logger.info("Entering createCampaignTemplateSkus()");
        List<CampaignTemplateSku> created = campaignTemplateSkuService.createCampaignTemplateSkus(skus);
        logger.info("Exiting createCampaignTemplateSkus() - " + created);
        return created;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/campaign/template/sku/update", method = RequestMethod.PUT)
    public boolean updateTemplateSkus(@RequestBody List<CampaignTemplateSku> templateSkus) {
        logger.info("Entering updateTemplateSkus()");
        for (CampaignTemplateSku sku : templateSkus) {
            campaignTemplateSkuService.createCampaignTemplateSku(sku);
        }
        logger.info("Exiting updateTemplateSkus()");
        return true;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/campaign/template/sku/list/{campaignTemplateId}", method = RequestMethod.GET)
    public List<CampaignTemplateSku> getCampaignTemplateSkus(@PathVariable String campaignTemplateId) {
        logger.info("Entering getCampaignTemplateSkus()");
        List<CampaignTemplateSku> skus = campaignTemplateSkuService.getByCampaignTemplateId(campaignTemplateId);
        logger.info("Exiting getCampaignTemplateSkus() - " + skus);
        return skus;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/campaign/template/skus/delete", method = RequestMethod.POST)
    public int deleteCampaignTemplateSkus(@RequestBody List<CampaignTemplateSku> skus) {
        logger.info("Entering deleteCampaignTemplateSkus()");
        int numDeleted = campaignTemplateSkuService.deleteCampaignTemplateSkus(skus);
        logger.info("Exiting deleteCampaignTemplateSkus() - " + numDeleted);
        return numDeleted;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/campaign/sku/list/{campaignId}", method = RequestMethod.GET)
    public List<CampaignSku> getCampaignSkus(@PathVariable String campaignId) {
        logger.info("Entering getCampaignSkus()");
        List<CampaignSku> skus = campaignSkuService.getByCampaignId(campaignId);
        logger.info("Exiting getCampaignSkus() - " + skus);
        return skus;
    }

}
