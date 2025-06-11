package klu.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {

	@Autowired
	JavaMailSender JMS;
	
	public String sendEmail(String toEmailAddress, String subject, String message)
	{
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("kpn.research@gmail.com");
			mailMessage.setTo(toEmailAddress);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			
			JMS.send(mailMessage); //Send Email
			return "200::Password has been sent to registered email";
		}catch(Exception e)
		{
			return "404::" + e.getMessage();
		}
	}
}
