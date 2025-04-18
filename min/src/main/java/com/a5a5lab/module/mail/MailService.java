package com.a5a5lab.module.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import jakarta.mail.internet.MimeMessage;


@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	

//	회원가입 축하 메일
    public void sendMailWelcome() throws Exception{

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setFrom("kmboy1210@gmail.com"); 
    	mimeMessageHelper.setTo("kmboy1997@naver.com"); 
    	mimeMessageHelper.setSubject("가입을 축하합니다.");
    	mimeMessageHelper.setText("축하염", true); 
    	javaMailSender.send(mimeMessage);
    	
    }

}
