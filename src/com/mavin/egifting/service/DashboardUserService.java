package com.mavin.egifting.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.dao.DashboardUserMapper;
import com.mavin.egifting.model.DashboardUser;
import com.mavin.egifting.utils.Status;

@Component
public class DashboardUserService {

	Logger logger = Logger.getLogger(DashboardUserService.class);

	@Autowired
	DashboardUserMapper dashboardUserMapper;

	public DashboardUser createDashboardUser(DashboardUser dashboardUser) {

		logger.info("Entering createDashboardUser() - " + dashboardUser);

		Preconditions.checkNotNull(dashboardUser);
		Preconditions.checkArgument(Strings.isNullOrEmpty(dashboardUser.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUser.getEmail()));

		dashboardUser.setId(UUID.randomUUID().toString());
		dashboardUser.setCreateDttm(System.currentTimeMillis());
		dashboardUser.setUpdateDttm(System.currentTimeMillis());
		dashboardUser.setStatus(Status.ACTIVE.toString());

		int rows = dashboardUserMapper.insertDashboardUser(dashboardUser);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to create dashboard user");
			return null;
		}

		logger.info("Exiting createDashboardUser() - " + dashboardUser);
		return dashboardUser;
	}

	public DashboardUser updateDashboardUser(DashboardUser dashboardUser) {
		logger.info("Entering updateDashboardUser() - " + dashboardUser);

		Preconditions.checkNotNull(dashboardUser);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUser.getId()));
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUser.getEmail()));

		dashboardUser.setUpdateDttm(System.currentTimeMillis());

		int rows = dashboardUserMapper.updateDashboardUser(dashboardUser);

		if (1 != rows) {
			// TODO (SriramK) - Throw proper exception
			logger.error("Failed to update dashboard user");
			return null;
		}
		logger.info("Exiting updateDashboardUser() - " + dashboardUser);
		return dashboardUser;
	}

	public DashboardUser getDashboardUserById(String dashboardUserId) {
		logger.info("Entering getDashboardUserById() - " + dashboardUserId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(dashboardUserId));
		DashboardUser dashboardUser = dashboardUserMapper.findDashboardUserById(dashboardUserId);
		logger.info("Exiting getDashboardUserById() - " + dashboardUser);
		return dashboardUser;
	}

	public List<DashboardUser> getAllDashboardUsers() {
		logger.info("Entering getAllDashboardUsers()");
		List<DashboardUser> dashboardUsers = dashboardUserMapper.findAllDashboardUsers();
		logger.info("Exiting getAllDashboardUsers() - " + dashboardUsers);
		return dashboardUsers;
	}

	public List<DashboardUser> getDashboardUsersByEmail(String email) {
		logger.info("Entering getDashboardUsersByEmail()");
		List<DashboardUser> dashboardUsers = dashboardUserMapper.findByEmail(email);
		logger.info("Exiting getDashboardUsersByEmail() - " + dashboardUsers);
		return dashboardUsers;
	}

}
