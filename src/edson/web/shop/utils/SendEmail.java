package edson.web.shop.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail extends Thread{

	/**
	 * 
	 * 创建线程发送邮件
	 * @param to	邮件接收者账号
	 * @param code	帐号激活码
	 * @throws MessagingException
	 */
	public void sendEmail(String to, String code) throws MessagingException {
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.sohu.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		
		Session session=Session.getInstance(props);
		session.setDebug(true);
		
		Transport ts=session.getTransport();
		ts.connect(session.getProperty("mail.host"), "edson121@sohu.com", "147258369xy");
		
		MimeMessage message=new MimeMessage(session);
		
		message.setFrom(new InternetAddress("edson121@sohu.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		
		message.setSubject("网上商城账号验证信息");
		message.setContent("<h1>欢迎注册网上商城</h1><h3>您已注册成功，请点击<a href='http://www.localhost:8080/SSH_Shop/user/user_activateAccount?code="+code+"'>激活帐户</a></h3>", "text/html;charset=UTF-8");
		
		ts.sendMessage(message,message.getAllRecipients());
		
		
		ts.close();
		
	}
	
}
