package com.mavin.egifting.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mavin.egifting.controller.reports.FunnelData;
import com.mavin.egifting.service.ReportsService;

@ComponentScan
@RestController
@RequestMapping("/services/reports")
public class ReportsController {

    Logger logger = Logger.getLogger(ReportsController.class);

    @Autowired
    ReportsService reportsService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/funnel/{campaignId}", method = RequestMethod.GET)
    public FunnelData[] getReportFunnelData(@PathVariable String campaignId) {
        logger.info("Entering getReportFunnelData() - " + campaignId);
        FunnelData[] funnelData = reportsService.getFunnelReportData(campaignId);
        logger.info("Exiting getReportFunnelData() - " + funnelData);
        return funnelData;
    }

}
