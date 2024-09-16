package pkg1.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	@Autowired
	private JavaMailSender jms;
	@Value("${spring.mail.username}")
	private String username;
	
	@PostMapping("/send/email")
	public String sendEmail(@RequestBody MailModel mm) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(username);
		smm.setTo(mm.getTo());
		smm.setSubject(mm.getSubject());
		smm.setText(mm.getBodyContent());
		jms.send(smm);
		return "Mail Sent Successfully";
	}
	
}
