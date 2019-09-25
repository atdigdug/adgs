package com.mavin.egifting.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

//@Configuration
//@EnableWebMvc
//@MapperScan("com.mavin.egifting.dao")
public class ApplicationConfig {

	@Autowired
	DriverManagerDataSource dataSource;

	@Value("${tyrion.name}")
	private String name;
	@Value("${tyrion.freemarker.resourcedir}")
	private String fmResourceDir;
	@Value("${tyrion.mail.host}")
	private String mailHost;
	@Value("${tyrion.mail.username}")
	private String mailUsername;
	@Value("${tyrion.mail.password}")
	private String mailPassword;
	@Value("${tyrion.mail.port}")
	private String mailPort;
	@Value("${tyrion.mail.protocol}")
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
		fmConfigFactoryBean.setTemplateLoaderPath("classpath*:/" + fmResourceDir);
		return fmConfigFactoryBean;
	}

	@Bean
	public DataSource getDataSource() {
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory.getObject();
	}
}
