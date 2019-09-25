package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.DashboardUserPermissionsMapper;
import com.mavin.egifting.model.DashboardUserPermissions;

@Component
public class DashboardUserPermissionsService {
	
	Logger logger = Logger.getLogger(DashboardUserPermissionsService.class);

	@Autowired
	DashboardUserPermissionsMapper dashboardUserPermissionsMapper;

	public DashboardUserPermissions createDashboardUserPermissions(DashboardUserPermissions dashboardUserPermissions) {

		logger.info("Entering createDashboardUserPermissions() - " + dashboardUserPermissions);

		Preconditions.checkNotNull(dashboardUserPermissions);
		Preconditions.checkArgument(Strings.isNullOrEmpty(dashboardUserPermissions.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissions.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissions.getDashboardUserId()));

		dashboardUserPermissions.setId(UUID.randomUUID().toString());
		dashboardUserPermissions.setCreateDttm(System.currentTimeMillis());
		dashboardUserPermissions.setUpdateDttm(System.currentTimeMillis());

		int rows = dashboardUserPermissionsMapper.insertDashboardUserPermissions(dashboardUserPermissions);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create dashboard user permissions");
			return null;
		}

		logger.info("Exiting createDashboardUserPermissions() - " + dashboardUserPermissions);
		return dashboardUserPermissions;
	}

	public DashboardUserPermissions updateDashboardUserPermissions(DashboardUserPermissions dashboardUserPermissions) {
		logger.info("Entering updateDashboardUserPermissions() - " + dashboardUserPermissions);

		Preconditions.checkNotNull(dashboardUserPermissions);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissions.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissions.getApplicationId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissions.getDashboardUserId()));


		dashboardUserPermissions.setUpdateDttm(System.currentTimeMillis());

		int rows = dashboardUserPermissionsMapper.updateDashboardUserPermissions(dashboardUserPermissions);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to update dashboard user permissions");
			return null;
		}
		logger.info("Exiting updateDashboardUserPermissions() - " + dashboardUserPermissions);
		return dashboardUserPermissions;
	}

	public DashboardUserPermissions getDashboardUserPermissionsById(String dashboardUserPermissionsId) {
		logger.info("Entering getDashboardUserPermissionsById() - " + dashboardUserPermissionsId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserPermissionsId));
		DashboardUserPermissions dashboardUserPermissions = dashboardUserPermissionsMapper.findDashboardUserPermissionsById(dashboardUserPermissionsId);
		logger.info("Exiting getDashboardUserPermissionsById() - " + dashboardUserPermissions);
		return dashboardUserPermissions;
	}

	public List<DashboardUserPermissions> getAllDashboardUserPermissions() {
		logger.info("Entering getAllDashboardUserPermissions()");
		List<DashboardUserPermissions> dashboardUserPermissionsList = dashboardUserPermissionsMapper.findAllDashboardUserPermissions();
		logger.info("Exiting getAllDashboardUserPermissions() - " + dashboardUserPermissionsList);
		return dashboardUserPermissionsList;
	}

	public List<DashboardUserPermissions> getByDashboardUserId(String dashboardUserId) {
		logger.info("Entering getByDashboardUserId()");
		List<DashboardUserPermissions> dashboardUserPermissionsList = dashboardUserPermissionsMapper.findByDashbboardUserId(dashboardUserId);
		logger.info("Exiting getByDashboardUserId() - " + dashboardUserPermissionsList);
		return dashboardUserPermissionsList;
	}
}
