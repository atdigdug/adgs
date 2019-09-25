package com.mavin.egifting.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.model.Application;
import com.mavin.egifting.model.DashboardUser;
import com.mavin.egifting.model.DashboardUserPermissions;
import com.mavin.egifting.utils.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class DashboardUserPermissionsServiceTest {
	
	@Autowired
	DashboardUserService dashboardUserService;
	@Autowired
	DashboardUserPermissionsService dashboardUserPermissionsService;
	@Autowired
	ApplicationService applicationService;

	@Test
	public void testDashboardUserPermissionsCrud() {
		Application application = new Application();
		application.setName("UT - Application Name");
		application.setWebsiteUrl("http://website/url");
		application.setCallbackApi("http://callback/api");
		application.setGoogleAppStoreUrl("http://google/appstore/url");
		application.setItunesUrl("http://itunes/url");
		application.setStatus("active");

		application = applicationService.createApplication(application);
		assertNotNull(application);
		assertNotNull(application.getId());

		assertEquals("active", application.getStatus());
		application.setStatus("inactive");
		application = applicationService.updateApplication(application);

		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("inactive", application.getStatus());

		application = applicationService.getApplicationById(application.getId());
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("inactive", application.getStatus());

		List<Application> applications = applicationService.getAllApplications();
		assertNotNull(applications);
		assertTrue(applications.size() > 0);
		
		DashboardUser dashboardUser = new DashboardUser();
		dashboardUser.setEmail(new Random().nextInt(50) + "mavin@mavin.com");
		dashboardUser.setStatus(Status.ACTIVE.toString());

		dashboardUser = dashboardUserService.createDashboardUser(dashboardUser);
		assertNotNull(dashboardUser);
		assertNotNull(dashboardUser.getId());
		assertEquals(Status.ACTIVE.toString(), dashboardUser.getStatus());
		
		dashboardUser.setStatus(Status.INACTIVE.toString());
		dashboardUser = dashboardUserService.updateDashboardUser(dashboardUser);
		assertNotNull(dashboardUser);
		assertNotNull(dashboardUser.getId());
		assertEquals(Status.INACTIVE.toString(), dashboardUser.getStatus());
		dashboardUser.setStatus(Status.ACTIVE.toString());
		
		dashboardUser = dashboardUserService.getDashboardUserById(dashboardUser.getId());
		assertNotNull(dashboardUser);
		assertNotNull(dashboardUser.getId());
		assertEquals(Status.INACTIVE.toString(), dashboardUser.getStatus());
		
		List<DashboardUser> dashboardUsers = dashboardUserService.getAllDashboardUsers();
		assertNotNull(dashboardUsers);
		assertTrue(dashboardUsers.size() > 0);
		
		List<DashboardUser> dashboardUsers1 = dashboardUserService.getDashboardUsersByEmail(dashboardUser.getEmail());
		assertNotNull(dashboardUsers1);
		assertTrue(dashboardUsers1.size() > 0);
		
		DashboardUserPermissions dashboardUserPermissions = new DashboardUserPermissions();
		dashboardUserPermissions.setApplicationId(application.getId());
		dashboardUserPermissions.setPermission("Permission");
		dashboardUserPermissions.setDashboardUserId(dashboardUser.getId());
		
		dashboardUserPermissions = dashboardUserPermissionsService.createDashboardUserPermissions(dashboardUserPermissions);
		assertNotNull(dashboardUserPermissions);
		assertNotNull(dashboardUserPermissions.getId());
		assertEquals("Permission", dashboardUserPermissions.getPermission());
		
		dashboardUserPermissions.setPermission("No Permission");
		dashboardUserPermissions = dashboardUserPermissionsService.updateDashboardUserPermissions(dashboardUserPermissions);
		assertNotNull(dashboardUserPermissions);
		assertNotNull(dashboardUserPermissions.getId());
		assertEquals("No Permission", dashboardUserPermissions.getPermission());
		
		dashboardUserPermissions = dashboardUserPermissionsService.getDashboardUserPermissionsById(dashboardUserPermissions.getId());
		assertNotNull(dashboardUserPermissions);
		assertNotNull(dashboardUserPermissions.getId());
		assertEquals("No Permission", dashboardUserPermissions.getPermission());
		
		List<DashboardUserPermissions> list = dashboardUserPermissionsService.getAllDashboardUserPermissions();
		assertNotNull(list);
		assertTrue(list.size() > 0);
		
		List<DashboardUserPermissions> moreLists = dashboardUserPermissionsService.getByDashboardUserId(dashboardUser.getId());
		assertNotNull(moreLists);
		assertTrue(moreLists.size() > 0);
		
	}

}
