package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.SendMailNoMain;

import org.hibernate.usertype.UserVersionType;

import DAO.LoginDAO;
import DAO.StudentRegistrationDAO;
import DAO.TeacherRegistrationDAO;
import VO.LoginVO;
import VO.StudentRegistrationVO;
import VO.TeacherRegistrationVO;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("inside cont of fp");

		StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();

		TeacherRegistrationVO teacherRegistrationVO = new TeacherRegistrationVO();
		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();

		LoginVO loginVO = new LoginVO();
		LoginDAO loginDAO = new LoginDAO();

		String email = request.getParameter("email");

		loginVO.setEmail(email);

		Boolean isRightMailUser = loginDAO.isRightEmail(loginVO);

		if (isRightMailUser == true) {
			SendMailNoMain sendMailNoMain = new SendMailNoMain();
			Boolean mailSendStatus = sendMailNoMain.sendMail(email);
			System.out.println("Mail Sent Status :: " + mailSendStatus);
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		}

		else {
			System.out.println("Controller says, It's not a valid Email ID!");
			response.sendRedirect(request.getContextPath()
					+ "/admin/forgotPassword.jsp");
		}

	}

}
