package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ApplyDAO;
import DAO.DemoDAO;
import DAO.FeedackDAO;
import DAO.LoginDAO;
import DAO.StudentRegistrationDAO;
import DAO.StudentRequirementDAO;
import DAO.TeacherRegistrationDAO;
import DAO.TeacherRequirementDAO;
import VO.ApplyVO;
import VO.DemoVO;
import VO.LoginVO;
import VO.NonAcademicSubjectVO;
import VO.StandardVO;
import VO.StudentRegistrationVO;
import VO.StudentRequirementVO;
import VO.SubCategoryVO;
import VO.TeacherRegistrationVO;
import VO.TeacherRequirementVO;

/**
 * Servlet implementation class TeacherRegistration
 */
@WebServlet("/TeacherRegistration")
@MultipartConfig
public class TeacherRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");

		if (flag.equals("searchTeacher")) {
			searchTeacher(request, response);
		}

		if (flag.equals("searchTeacherProfile")) {
			searchTeacherProfile(request, response);
		}

		if (flag.equals("searchTeacherForNonAcademicCategory")) {
			searchTeacherForNonAcademicCategory(request, response);
		}

		if (flag.equals("editTeacherRegistration")) {
			editTeacherRegistration(request, response);
		}

		if (flag.equals("applyCheck")) {
			applyCheck(request, response);
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

		if (flag != null && flag.equals("insertTeacherDetails")) {
			insertTeacherDetails(request, response);
		}

		if (flag.equals("insertDemoDetails")) {
			insertDemoDetails(request, response);
		}

		if (flag.equals("updateDemoDetails")) {
			updateDemoDetails(request, response);
		}

		if (flag != null && flag.equals("updateTeacherDetails")) {
			updateTeacherDetails(request, response);
		}

	}

	protected void insertTeacherDetails(HttpServletRequest request,
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
		String s15 = "Teacher";

		LoginVO loginVO = new LoginVO();
		loginVO.setUserName(s4);
		loginVO.setPassword(s5);
		loginVO.setUsertype(s15);
		loginVO.setEmail(s6);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		teacherRegistrationDAO.insertUserPassword(loginVO);

		TeacherRegistrationVO teacherRegistrationVO = new TeacherRegistrationVO();
		teacherRegistrationVO.setFirstName(s1);
		teacherRegistrationVO.setLastName(s2);
		teacherRegistrationVO.setMiddleName(s3);
		/* teacherRegistrationVO.setEmail(s6); */
		teacherRegistrationVO.setPhone(i7);
		teacherRegistrationVO.setBirthDate(d3);
		teacherRegistrationVO.setGender(s9);
		teacherRegistrationVO.setAddress(s10);

		teacherRegistrationVO.setCity(s12);
		teacherRegistrationVO.setCountry(s13);
		teacherRegistrationVO.setPostcode(i14);
		teacherRegistrationVO.setLoginVO(loginVO);

		teacherRegistrationDAO.insertTeacherDetails(teacherRegistrationVO);

		response.sendRedirect("user/teacherRegistration.jsp");

	}

	protected void searchTeacherProfile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchUserDetails(loginVO);

		TeacherRegistrationVO teacherRegistrationVO = new TeacherRegistrationVO();
		teacherRegistrationVO.setLoginVO(loginVO);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		List list = teacherRegistrationDAO.searchTeacherDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("TeacherProfileList", list);

		/* System.out.println("hii"+list.size()); */

		HttpSession session1 = request.getSession();
		session1.setAttribute("userDetailList", ls);

		response.sendRedirect("user/teacherProfile.jsp");

	}

	protected void editTeacherRegistration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchUserDetails(loginVO);

		TeacherRegistrationVO teacherRegistrationVO = new TeacherRegistrationVO();
		teacherRegistrationVO.setLoginVO(loginVO);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		List list = teacherRegistrationDAO.searchTeacherDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("TeacherProfileList", list);

		HttpSession session1 = request.getSession();
		session1.setAttribute("userDetailList", ls);

		response.sendRedirect("user/editTeacherProfile.jsp");

	}

	protected void searchTeacher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		int studentReqId = Integer.parseInt(request.getParameter("studentRequirementId"));

		HttpSession session = request.getSession();
		session.setAttribute("StudentRequirementId", studentReqId);

		PrintWriter out = response.getWriter();
		System.out.println("HIIIIIIIIIIIIIIIIIII" + studentReqId);

		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));
		int standardId = Integer.parseInt(request.getParameter("standardId"));

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(standardId);

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		List list = teacherRegistrationDAO.searchTeacherName(subCategoryVO,
				standardVO);

		System.out.println("hiii");
		System.out.println("hiii" + standardId);

		HttpSession session2 = request.getSession();
		session2.setAttribute("teacherList", list);
		
		/*FeedackDAO feedackDAO =new FeedackDAO();
		List ls= feedackDAO.searchRating(loginVO);
		System.out.println("hiiioooo" + ls.size());
		
		HttpSession session3 = request.getSession();
		session3.setAttribute("ratingList", list);*/
		
		
		
		applyCheck(request,response);

		response.sendRedirect("user/viewTeacher.jsp");

	}

	protected void applyCheck(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		ApplyVO applyVO = new ApplyVO();
		applyVO.setStudentId(loginVO);

		ApplyDAO applyDAO = new ApplyDAO();
		List list = applyDAO.searchApplyDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("applyList", list);

		StudentRequirementVO studentRequirementVO = new StudentRequirementVO();
		studentRequirementVO.setLoginVO(loginVO);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List list2 = studentRequirementDAO.searchStudentRequirement(loginVO);

		HttpSession session1 = request.getSession();
		session1.setAttribute("studentRequirementList", list2);

	}

	protected void searchTeacherForNonAcademicCategory(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		int studentReqId = Integer.parseInt(request
				.getParameter("studentRequirementId"));

		HttpSession session = request.getSession();
		session.setAttribute("StudentRequirementId", studentReqId);

		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));

		int nonAcademicSubjectId = Integer.parseInt(request
				.getParameter("nonAcademicSubjectId"));

		NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
		nonAcademicSubjectVO.setNonAcademicSubjectId(nonAcademicSubjectId);

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		List list = teacherRegistrationDAO
				.searchTeacherNameForNonAcademicCategory(nonAcademicSubjectVO);

		HttpSession session1 = request.getSession();
		session1.setAttribute("teacherList", list);

		applyCheck(request,response);
		
		response.sendRedirect("user/viewTeacher.jsp");

	}

	protected void insertDemoDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int teacherId = Integer.parseInt(request.getParameter("teacherId"));

		int studentId = Integer.parseInt(request.getParameter("studentId"));
		
		int studentRequirementId = Integer.parseInt(request.getParameter("studentRequirementId"));
		int teacherRequirementId = Integer.parseInt(request.getParameter("teacherRequirementId"));
		
		
		
		System.out.println("helloFenil"+studentRequirementId);
		System.out.println("helloFenilbhai"+teacherRequirementId);

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(teacherId);
		
		
		

		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserId(studentId);
		
		StudentRequirementVO studentRequirementVO  = new StudentRequirementVO();
		studentRequirementVO.setStudentRequirementId(studentRequirementId);
		
		TeacherRequirementVO teacherRequirementVO = new TeacherRequirementVO();
		teacherRequirementVO.setTeacherRequirementId(teacherRequirementId);

		String date = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d3 = null;
		try {
			d3 = sdf.parse(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String time = request.getParameter("time");

		String status = "No";

		DemoVO demoVO = new DemoVO();
		demoVO.setStudentId(loginVO2);
		demoVO.setTeacherId(loginVO);
		demoVO.setDate(d3);
		demoVO.setTime(time);
		demoVO.setStatus(status);
		demoVO.setStudentRequirementId(studentRequirementVO);
		demoVO.setTeacherRequirementId(teacherRequirementVO);
		
		

		DemoDAO demoDAO = new DemoDAO();
		demoDAO.InsertDemoDetail(demoVO);

		response.sendRedirect("user/appliedStudent.jsp");

	}

	protected void updateDemoDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int demoId = Integer.parseInt(request.getParameter("demoId"));

		HttpSession session = request.getSession();
		session.setAttribute("demoId", demoId);

		DemoVO demoVO = new DemoVO();
		demoVO.setDemoId(demoId);

		DemoDAO demoDAO = new DemoDAO();
		List<DemoVO> list = demoDAO.findDemoDetailsForTeacher(demoVO);

		String status = request.getParameter("choice");
		System.out.println("opps"+demoId);
		System.out.println("opps"+status);
		DemoVO demoVO1 = new DemoVO();
		demoVO1.setStatus(status);

		demoVO1.setDate(list.get(0).getDate());
		demoVO1.setStudentId(list.get(0).getStudentId());
		demoVO1.setTeacherId(list.get(0).getTeacherId());
		demoVO1.setStudentRequirementId(list.get(0).getStudentRequirementId());
		demoVO1.setTeacherRequirementId(list.get(0).getTeacherRequirementId());
		demoVO1.setTime(list.get(0).getTime());
		demoVO1.setDemoId(list.get(0).getDemoId());

		DemoDAO demoDAO2 = new DemoDAO();
		demoDAO2.updateDemoDetails(demoVO1);
		
		/*new code start*/
		/*DemoDAO demoDAO3 = new DemoDAO();
		List list2 = demoDAO3.searchDemoDetailsForStd(demoVO1);
		
		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);
		
		LoginDAO loginDAO = new LoginDAO();
		List<LoginVO> list3 = loginDAO.searchUserDetails(loginVO);
		
		*/
		
		
		/*new code end*/

		response.sendRedirect("user/demoDetailsForStudent.jsp");

	}

	protected void updateTeacherDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();

		int teacherRegistrationId = Integer.parseInt(request
				.getParameter("teacherRegistrationId"));

		System.out.println("hii" + teacherRegistrationId);

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

		TeacherRegistrationVO teacherRegistrationVO = new TeacherRegistrationVO();
		teacherRegistrationVO.setTeacherRegistrationId(teacherRegistrationId);
		teacherRegistrationVO.setFirstName(s1);
		teacherRegistrationVO.setMiddleName(s2);
		teacherRegistrationVO.setLastName(s3);
		teacherRegistrationVO.setPhone(i7);
		teacherRegistrationVO.setBirthDate(d3);
		teacherRegistrationVO.setGender(s9);
		teacherRegistrationVO.setAddress(s10);
		teacherRegistrationVO.setCountry(s13);
		teacherRegistrationVO.setCity(s12);
		teacherRegistrationVO.setPostcode(i14);

		loginVO.setUserId(loginId);
		loginVO.setUserName(s4);
		loginVO.setPassword(s5);
		loginVO.setUsertype(s15);
		loginVO.setEmail(s6);

		teacherRegistrationVO.setLoginVO(loginVO);

		TeacherRegistrationDAO teacherRegistrationDAO = new TeacherRegistrationDAO();
		teacherRegistrationDAO.updateTeacherRegistration(teacherRegistrationVO);

		LoginDAO loginDAO = new LoginDAO();
		loginDAO.update(loginVO);

		searchTeacherProfile(request, response);

	}

}
