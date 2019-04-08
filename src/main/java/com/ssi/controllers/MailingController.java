package com.ssi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailingController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping("newmail")
	public String showMailSendingForm(){
		return "mailform";
	}
	@RequestMapping("sendmail")
	public ModelAndView sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("message") String message){
	
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
		ModelAndView mv=new ModelAndView("success");
		return mv;
	}

}
