package com.Demo.WenDemo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		// 创建一个程序与服务器会话对象session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", "smtp.sohu.com");
		props.setProperty("mail.smtp.auth", "true");

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tttzzztttzzz", "888666hy...");
			}
		};
		Session session = Session.getInstance(props, auth);

		// 创建一个message，相当于邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("tttzzztttzzz@sohu.com", "Admin", "UTF-8"));// 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email, "USER_CC", "UTF-8"));

		message.setSubject("用户激活");
		message.setContent(emailMsg, "Text/html;charset=utf-8");
		// 创建Transportyongyu 用于邮件发送
		Transport.send(message);
	}
}
