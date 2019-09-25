package com.mavin.egifting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mavin.egifting.dto.EGiftReceiverEmailDto;
import com.mavin.egifting.utils.StringConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:servlet-context.xml" })
@SpringBootTest
public class EmailServiceTest {

	@Autowired
	EmailService emailService;
	
	@Test
	public void testSendEmail() {
		EGiftReceiverEmailDto mailDto = new EGiftReceiverEmailDto();
		mailDto.setToEmail("skrovvidi@gmail.com");
		mailDto.setFromEmail("sriram@mavin.co");
		mailDto.setEmailSubject("Unit Testing");
		mailDto.setReceiverName("Krovvidi");
		mailDto.setSenderName("Sriram");
		mailDto.setCampaignSkuName("Saavn Pro 1 Month");
		mailDto.setLogoImageUrl("https://s3.amazonaws.com/imageworld/saavn-logo.png");
		mailDto.setClaimButtonUrl(StringConstants.CLAIM_GIFT_BUTTON_URL);
		mailDto.setMessage("Happy eGifting");
		String template = "EgiftingReceiverEmailTemplate.ftl";

		emailService.sendEmail(mailDto, template);
	}

}
