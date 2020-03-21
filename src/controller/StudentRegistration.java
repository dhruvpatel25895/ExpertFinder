package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import DAO.CityDAO;
import DAO.LoginDAO;
import DAO.StudentRegistrationDAO;
import VO.CityVO;
import VO.LoginVO;
import VO.StudentRegistrationVO;

/**
 * Servlet implementation class studentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRegistration() {
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

		String flag = request.getParameter("flag");

		if (flag.equals("searchStudentProfile")) {
			searchStudentProfile(request, response);
		}
		
		if (flag.equals("searchUserForAdmin")) {
			searchUserForAdmin(request, response);
		}
		

		if (flag.equals("editStudentRegistration")) {
			editStudentRegistration(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");

		if (flag.equals("insertStudentDetails")) {
			insertStudentDetails(request, response);
		}

		if (flag.equals("updateStudentDetails")) {
			updateStudentDetails(request, response);
		}

	}

	protected void insertStudentDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("firstName");
		String s2 = request.getParameter("middleName");
		String s3 = request.getParameter("lastName");
		String s4 = request.getParameter("userName");
		String s5 = request.getParameter("password");
		String s6 = request.getParameter("email");

		Long i7 = Long.parseLong(request.getParameter("phone"));

		String startdate = request.getParameter("birthDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String s9 = request.getParameter("gender");
		String s10 = request.getParameter("address");

		String s12 = request.getParameter("city");
		String s13 = request.getParameter("country");
		Integer i14 = Integer.parseInt(request.getParameter("postcode"));
		String s15 = "Student";

		LoginVO loginVO = new LoginVO();
		loginVO.setUserName(s4);
		loginVO.setPassword(s5);
		loginVO.setUsertype(s15);
		loginVO.setEmail(s6);

		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
		studentRegistrationDAO.insertUserPassword(loginVO);

		StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
		studentRegistrationVO.setFirstName(s1);
		studentRegistrationVO.setLastName(s3);
		studentRegistrationVO.setMiddleName(s2);
		/* studentRegistrationVO.setEmail(s6); */
		studentRegistrationVO.setPhone(i7);
		studentRegistrationVO.setBirthDate(d3);
		studentRegistrationVO.setGender(s9);
		studentRegistrationVO.setAddress(s10);

		studentRegistrationVO.setCity(s12);
		studentRegistrationVO.setCountry(s13);
		studentRegistrationVO.setPostcode(i14);
		studentRegistrationVO.setLoginVO(loginVO);

		studentRegistrationDAO.insertStudentDetails(studentRegistrationVO);

		response.sendRedirect("user/studentRegistration.jsp");

	}

	protected void searchStudentProfile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchUserDetails(loginVO);

		StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
		studentRegistrationVO.setLoginVO(loginVO);

		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
		List list = studentRegistrationDAO.searchStudentDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("StudentProfileList", list);

		HttpSession session1 = request.getSession();
		session1.setAttribute("userDetailList", ls);

		response.sendRedirect("user/studentProfile.jsp");

	}

	protected void editStudentRegistration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchUserDetails(loginVO);

		StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
		studentRegistrationVO.setLoginVO(loginVO);

		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
		List list = studentRegistrationDAO.searchStudentDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("StudentProfileList", list);

		HttpSession session1 = request.getSession();
		session1.setAttribute("userDetailList", ls);

		response.sendRedirect("user/editStudentProfile.jsp");

	}

	protected void updateStudentDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();

		int studentRegistrationId = Integer.parseInt(request
				.getParameter("studentRegistrationId"));

		System.out.println("hii" + studentRegistrationId);

		String s1 = request.getParameter("firstName");
		String s2 = request.getParameter("middleName");
		String s3 = request.getParameter("lastName");
		String s4 = request.getParameter("userName");
		String s5 = request.getParameter("password");
		String s6 = request.getParameter("email");

		Long i7 = Long.parseLong(request.getParameter("phone"));

		String startdate = request.getParameter("birthDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String s9 = request.getParameter("gender");
		String s10 = request.getParameter("address");

		String s12 = request.getParameter("city");
		String s13 = request.getParameter("country");
		Integer i14 = Integer.parseInt(request.getParameter("postcode"));
		String s15 = "Student";

		StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
		studentRegistrationVO.setStudentRegistrationId(studentRegistrationId);
		studentRegistrationVO.setFirstName(s1);
		studentRegistrationVO.setMiddleName(s2);
		studentRegistrationVO.setLastName(s3);
		studentRegistrationVO.setPhone(i7);
		studentRegistrationVO.setBirthDate(d3);
		studentRegistrationVO.setGender(s9);
		studentRegistrationVO.setAddress(s10);
		studentRegistrationVO.setCountry(s13);
		studentRegistrationVO.setCity(s12);
		studentRegistrationVO.setPostcode(i14);

		loginVO.setUserId(loginId);
		loginVO.setUserName(s4);
		loginVO.setPassword(s5);
		loginVO.setUsertype(s15);
		loginVO.setEmail(s6);

		studentRegistrationVO.setLoginVO(loginVO);

		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
		studentRegistrationDAO.updateStudentRegistration(studentRegistrationVO);

		LoginDAO loginDAO = new LoginDAO();
		loginDAO.update(loginVO);

		searchStudentProfile(request, response);

	}
	
	protected void searchUserForAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		List list = loginDAO.searchAllUser();
		

		HttpSession session = request.getSession();
		session.setAttribute("userList", list);

		response.sendRedirect("admin/searchUser.jsp");
	}

}
