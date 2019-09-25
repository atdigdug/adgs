package biz.giftsub.configs;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class EmailConfig {

	@Value("${giftsub.name}")
	private String name;
	@Value("${giftsub.freemarker.resourcedir}")
	private String fmResourceDir;
	@Value("${giftsub.mail.host}")
	private String mailHost;
	@Value("${giftsub.mail.username}")
	private String mailUsername;
	@Value("${giftsub.mail.password}")
	private String mailPassword;
	@Value("${giftsub.mail.port}")
	private String mailPort;
	@Value("${giftsub.mail.protocol}")
	private String mailProtocol;

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailHost);
		mailSender.setUsername(mailUsername);
		mailSender.setPassword(mailPassword);
		mailSender.setPort(465);
		mailSender.setProtocol(mailProtocol);

		Properties properties = new Properties();
		properties.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(properties);

		return mailSender;
	}

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
		fmConfigFactoryBean.setTemplateLoaderPath("classpath:/" + fmResourceDir);
		return fmConfigFactoryBean;
	}

}
