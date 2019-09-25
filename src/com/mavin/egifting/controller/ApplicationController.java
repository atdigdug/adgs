package com.mavin.egifting.controller;

import com.mavin.egifting.model.Application;
import com.mavin.egifting.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/services/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    Logger logger = Logger.getLogger(ApplicationController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public Application getApplication(@PathVariable String applicationId) {
        logger.info("Entering getApplication() - " + applicationId);
        Application application = applicationService.getApplicationById(applicationId);
        logger.info("Exiting getApplication() - " + application);
        return application;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Application> getApplications() {
        logger.info("Entering getApplications()");
        List<Application> applications = applicationService.getAllApplications();
        logger.info("Exiting getApplications() - " + applications);
        return applications;
    }

}
