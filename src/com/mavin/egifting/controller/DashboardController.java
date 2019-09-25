package com.mavin.egifting.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mavin.egifting.dto.TransactionDto;
import com.mavin.egifting.model.Application;
import com.mavin.egifting.model.ApplicationSku;
import com.mavin.egifting.model.Campaign;
import com.mavin.egifting.model.CampaignSku;
import com.mavin.egifting.model.CampaignTemplate;
import com.mavin.egifting.model.CampaignTemplateSku;
import com.mavin.egifting.model.Transaction;
import com.mavin.egifting.service.ApplicationService;
import com.mavin.egifting.service.ApplicationSkuService;
import com.mavin.egifting.service.CampaignService;
import com.mavin.egifting.service.CampaignSkuService;
import com.mavin.egifting.service.CampaignTemplateService;
import com.mavin.egifting.service.CampaignTemplateSkuService;
import com.mavin.egifting.service.TransactionService;

@ComponentScan
@RestController
@RequestMapping("/services")
public class DashboardController {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationSkuService applicationSkuService;
    @Autowired
    CampaignSkuService campaignSkuService;
    @Autowired
    CampaignTemplateSkuService campaignTemplateSkuService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    CampaignTemplateService campaignTemplateService;
    @Autowired
    CampaignService campaignService;

    Logger logger = Logger.getLogger(DashboardController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public boolean uploadImage(@RequestParam("image") MultipartFile image) {

        logger.info("Entering uploadImage() - " + image);
        
        logger.info("Convincing myself I'm not deluded: " + image.getSize() + " :: " + image.getContentType());

        logger.info("Exiting uploadImage() - " + image);

        return true;
    }

}
