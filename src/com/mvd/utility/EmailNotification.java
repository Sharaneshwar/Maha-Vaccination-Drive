package com.mvd.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mvd.dao.SelectOperations;

public class EmailNotification {
	public int send_notification(String username) {
		SelectOperations so = new SelectOperations();
		ArrayList<String> al = so.select_appointment_details(username);

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Date date = null;
		try {
			date = format1.parse(al.get(2));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		String message = String.format(
				"<html>"
				+ "<body>"
				+ "<div style = \"font-size: 16px\">Dear <b>%s</b>,<br>"
				+ "Your appointment for Covid-19 Vaccination using <b>%s</b> is confirmed.<br>"
				+ "It is scheduled on <b>%s</b> at <b>%s, Solapur</b>.<br>"
				+ "Your Appointment ID is <b>%s</b><br><br>"
				+ "Thank You!"
				+ "</div>"
				+ "</html>",
				so.select_user_name(username), al.get(3), format2.format(date), al.get(4), al.get(0));
		String subject = "Your Appointment Is Confirmed";
		String to = username;
		String from = "Maha Vaccination Drive <mvd.ssvp@gmail.com>";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
			protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mvd.ssvp@gmail.com", "eytyzcqrqjmchjph");
            }
        });

		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setContent(message, "text/html");
			Transport.send(m);
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}
