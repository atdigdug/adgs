package com.mavin.egifting.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.controller.reports.FunnelData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class ReportsServiceTest {

	@Autowired
	ReportsService reportsService;
	
	@Test
	public void testGetFunnelReportData() {
		FunnelData[] funnelData = reportsService.getFunnelReportData("1ef7a32c-5cfe-4266-b09d-2ea574615fe6");
		assertEquals(30, funnelData[0].getValue());
		assertEquals(9, funnelData[1].getValue());
		assertEquals(8, funnelData[2].getValue());
		assertEquals(6, funnelData[3].getValue());
	}

}
