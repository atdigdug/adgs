package com.mavin.egifting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.model.DashboardUser;
import com.mavin.egifting.utils.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class DashboardUserServiceTest {

	@Autowired
	DashboardUserService dashboardUserService;

	@Test
	public void testDashboardUserCrud() {
		DashboardUser dashboardUser = new DashboardUser();
		dashboardUser.setEmail("mavin@mavin.com");
		dashboardUser.setStatus(Status.ACTIVE.toString());

		dashboardUser = dashboardUserService.createDashboardUser(dashboardUser);
		assertNotNull(dashboardUser);
		assertNotNull(dashboardUser.getId());
		assertEquals("mavin@mavin.com", dashboardUser.getEmail());
		
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
		
	}

}
