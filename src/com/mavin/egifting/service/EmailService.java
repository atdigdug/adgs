package com.mavin.egifting.service;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.mavin.egifting.dto.EmailDto;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

//@Component
public class EmailService {

	@Autowired
	JavaMailSender emailSender;
	@Autowired
	Configuration fmConfiguration;

	Logger logger = Logger.getLogger(EmailService.class);

	public void sendEmail(EmailDto emailDto, String emailTemplateName) {
		fmConfiguration.setClassForTemplateLoading(this.getClass(), "/resources");

		try {
			Template emailTemplate = fmConfiguration.getTemplate(emailTemplateName);
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(emailTemplate, emailDto);
			MimeMessagePreparator mimeMessagePreparator = prepare(emailDto.getToEmail(), emailDto.getFromEmail(),
					emailDto.getEmailSubject(), text);
			emailSender.send(mimeMessagePreparator);

		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private MimeMessagePreparator prepare(final String to, final String from, final String subject, final String body) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(to);
				message.setFrom(from);
				message.setSubject(subject);
				message.setText(body, true);
			}
		};

		return preparator;
	}

}
