package com.ssi.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ssi")
public class ProjectConfig {

	
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl jms=new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");
		jms.setPort(587);
		jms.setUsername("ssiedu123@gmail.com");
		jms.setPassword("ssiindore");
		Properties properties=new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		jms.setJavaMailProperties(properties);
		return jms;
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		vr.setPrefix("/WEB-INF/views/");
		return vr;
	}
	
	
	
	
	
	
}
