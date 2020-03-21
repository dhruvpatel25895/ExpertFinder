package mail;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.logging.LogWrapperFactory;

import sun.security.krb5.internal.LoginOptions;
import DAO.LoginDAO;
import DAO.StudentRegistrationDAO;
import DAO.TeacherRegistrationDAO;
import VO.LoginVO;

import VO.StudentRegistrationVO;
import VO.TeacherRegistrationVO;

import java.security.SecureRandom;
import java.math.BigInteger;

public class SendMailNoMain {

	public boolean sendMail(String to) {
		SessionIdentifierGenerator sig = new SessionIdentifierGenerator();
		String pwd = sig.nextSessionId();

		LoginVO loginVO = new LoginVO();
		loginVO.setEmail(to);

		LoginDAO loginDAO = new LoginDAO();
		List<LoginVO> emailList1 = loginDAO.searchByEmail(to);
		System.out.println("##### List Email " + emailList1.size());

		loginVO.setEmail(emailList1.get(0).getEmail());
		loginVO.setPassword(emailList1.get(0).getPassword());
		loginVO.setUserId(emailList1.get(0).getUserId());
		loginVO.setUserName(emailList1.get(0).getUserName());
		loginVO.setUsertype(emailList1.get(0).getUsertype());

		loginVO.setPassword(pwd);

		LoginDAO loginDAO1 = new LoginDAO();
		loginDAO1.update(loginVO);

		final String from = "aishashah535@gmail.com";
		final String password = "aishashah323";
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("ForgotPassword");
			// String s="patel";

			System.out.println("hiiiiiiiiiiiii");
			message.setText(" >> " + "New Password :: " + " << " + pwd);
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}
}
