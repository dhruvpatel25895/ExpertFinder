package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ApplyDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.DemoConfirmationDAO;
import DAO.DemoDAO;
import DAO.StudentRegistrationDAO;
import DAO.StudentRequirementDAO;
import DAO.SubCategoryDAO;
import VO.AcademicSubjectVO;
import VO.ApplyVO;
import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;

import VO.DemoVO;
import VO.LoginVO;
import VO.MediumVO;
import VO.NonAcademicSubjectVO;
import VO.StandardVO;
import VO.StdAcaRequirementMappingVO;
import VO.StdNonAcaRequirementMappingVO;
import VO.StudentRequirementVO;
import VO.SubCategoryVO;
import VO.TeacherRequirementVO;

/**
 * Servlet implementation class StudentRequirement
 */
@WebServlet("/StudentRequirement")
@MultipartConfig
public class StudentRequirement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRequirement() {
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

		if (flag.equals("search")) {
			search(request, response);
		}

		if (flag.equals("searchMedium")) {
			searchMedium(request, response);
		}

		if (flag.equals("searchStandard")) {
			searchStandard(request, response);
		}

		if (flag.equals("searchAcademicSubject")) {
			searchAcademicSubject(request, response);
		}

		if (flag.equals("searchNonAcademicSubject")) {
			searchNonAcademicSubject(request, response);
		}
		if (flag.equals("searchArea")) {
			searchArea(request, response);
		}

		if (flag.equals("applyDetails")) {
			applyDetails(request, response);
		}

		if (flag.equals("searchStudentRequirement")) {
			searchStudentRequirement(request, response);
		}

		if (flag.equals("searchStudentRequirementTeacherSide")) {
			searchStudentRequirementTeacherSide(request, response);
		}

		if (flag.equals("searchDemoDetails")) {
			searchDemoDetails(request, response);
		}

		if (flag.equals("searchDemoDetailsForStudent")) {
			searchDemoDetailsForStudent(request, response);
		}
		if (flag.equals("searchDemoDetailsForTeacher")) {
			searchDemoDetailsForTeacher(request, response);
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

		if (flag.equals("insert")) {
			insert(request, response);
		}

	}

	protected void search(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO();
		List l = categoryDAO.searchCategory();

		HttpSession session = request.getSession();
		session.setAttribute("categoryList", l);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchAcademicCategory();

		HttpSession session1 = request.getSession();
		session.setAttribute("academicCategoryList", l1);

		SubCategoryDAO subCategoryDAO2 = new SubCategoryDAO();
		List l2 = subCategoryDAO2.searchNonAcademicCategory();

		HttpSession session2 = request.getSession();
		session.setAttribute("nonAcademicCategoryList", l2);

		CityDAO cityDAO = new CityDAO();
		List l3 = cityDAO.searchCity();

		HttpSession session3 = request.getSession();
		session.setAttribute("cityList", l3);

		response.sendRedirect("user/studentRequirement.jsp");

	}

	protected void searchMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List l1 = studentRequirementDAO.searchMedium(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l1);

		response.sendRedirect("user/JSON/loadMedium.jsp");

	}

	protected void searchStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int mediumId = Integer.parseInt(request.getParameter("mediumId"));

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(mediumId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List l1 = studentRequirementDAO.searchStandard(mediumVO);

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l1);

		response.sendRedirect("user/JSON/loadStandard.jsp");

	}

	protected void searchAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int standardId = Integer.parseInt(request.getParameter("standardId"));

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(standardId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List l1 = studentRequirementDAO.searchAcademicSubject(standardVO);

		HttpSession session = request.getSession();
		session.setAttribute("academicSubjectList", l1);

		response.sendRedirect("user/JSON/loadAcademicSubject.jsp");

	}

	protected void searchNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List l1 = studentRequirementDAO.searchNonAcademicSubject(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicSubjectList", l1);

		response.sendRedirect("user/JSON/loadNonAcademicSubject.jsp");

	}

	protected void searchArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int cityId = Integer.parseInt(request.getParameter("cityId"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List l1 = studentRequirementDAO.searchArea(cityVO);

		HttpSession session = request.getSession();
		session.setAttribute("areaList", l1);

		response.sendRedirect("user/JSON/loadArea.jsp");

	}

	protected void insert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		String[] categoryName = request.getParameterValues("categoryName");
		String[] academicCategory = request.getParameterValues("academicName");
		String[] medium = request.getParameterValues("mediumName");
		String[] standard = request.getParameterValues("standardName");
		String[] academicSubject = request
				.getParameterValues("academicSubjectName");

		String[] category = request.getParameterValues("category");
		String[] nonAcademicCategory = request
				.getParameterValues("noneAcademicCategory");
		String[] nonAcademicSubject = request
				.getParameterValues("noneAcademicSubject");

		String city = request.getParameter("cityDrop");
		String area = request.getParameter("areaDrop");
		String time = request.getParameter("time");
		String day = request.getParameter("day");

		CityVO cityVO = new CityVO();
		cityVO.setCityId(Integer.parseInt(city));

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(Integer.parseInt(area));

		StudentRequirementVO studentRequirementVO = new StudentRequirementVO();
		studentRequirementVO.setAreaVO(areaVO);
		studentRequirementVO.setCityVO(cityVO);
		studentRequirementVO.setTime(time);
		studentRequirementVO.setDay(day);
		studentRequirementVO.setLoginVO(loginVO);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		studentRequirementDAO.insertStudentRequirement(studentRequirementVO);

		if (categoryName != null) {
			for (int i = 0; i < categoryName.length; i++) {
				Integer categoryId = Integer.parseInt(categoryName[i]);
				Integer academicNameId = Integer.parseInt(academicCategory[i]);
				Integer mediumId = Integer.parseInt(medium[i]);
				Integer standardId = Integer.parseInt(standard[i]);
				Integer academicSubjectId = Integer
						.parseInt(academicSubject[i]);

				CategoryVO categoryVO = new CategoryVO();
				categoryVO.setCategoryId(categoryId);

				SubCategoryVO subCategoryVO = new SubCategoryVO();
				subCategoryVO.setSubCategoryId(academicNameId);

				MediumVO mediumVO = new MediumVO();
				mediumVO.setMediumId(mediumId);

				StandardVO standardVO = new StandardVO();
				standardVO.setStandardId(standardId);

				AcademicSubjectVO academicSubjectVO = new AcademicSubjectVO();
				academicSubjectVO.setAcademicSubjectId(academicSubjectId);

				StdAcaRequirementMappingVO stdAcaRequirementMappingVO = new StdAcaRequirementMappingVO();
				stdAcaRequirementMappingVO.setCategoryVO(categoryVO);
				stdAcaRequirementMappingVO.setSubCategoryVO(subCategoryVO);
				stdAcaRequirementMappingVO.setMediumVO(mediumVO);
				stdAcaRequirementMappingVO.setStandardVO(standardVO);
				stdAcaRequirementMappingVO
						.setAcademicSubjectVO(academicSubjectVO);
				stdAcaRequirementMappingVO
						.setStudentRequirementVO(studentRequirementVO);
				stdAcaRequirementMappingVO.setLoginVO(loginVO);

				StudentRequirementDAO studentRequirementDAO2 = new StudentRequirementDAO();
				studentRequirementDAO2
						.insertAcademicStudentRequirementMapping(stdAcaRequirementMappingVO);

			}
		}
		if (category != null) {
			for (int i = 0; i < category.length; i++) {
				Integer categoryId = Integer.parseInt(category[i]);
				Integer nonAcademicCategoryId = Integer
						.parseInt(nonAcademicCategory[i]);
				Integer nonAcademicSubjectId = Integer
						.parseInt(nonAcademicSubject[i]);

				CategoryVO categoryVO2 = new CategoryVO();
				categoryVO2.setCategoryId(categoryId);

				SubCategoryVO subCategoryVO2 = new SubCategoryVO();
				subCategoryVO2.setSubCategoryId(nonAcademicCategoryId);

				NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
				nonAcademicSubjectVO
						.setNonAcademicSubjectId(nonAcademicSubjectId);

				StdNonAcaRequirementMappingVO stdNonAcaRequirementMappingVO = new StdNonAcaRequirementMappingVO();
				stdNonAcaRequirementMappingVO.setCategoryVO(categoryVO2);
				stdNonAcaRequirementMappingVO.setSubCategoryVO(subCategoryVO2);
				stdNonAcaRequirementMappingVO
						.setNonAcademicSubjectVO(nonAcademicSubjectVO);
				stdNonAcaRequirementMappingVO
						.setStudentRequirementVO(studentRequirementVO);
				stdNonAcaRequirementMappingVO.setLoginVO(loginVO);

				StudentRequirementDAO studentRequirementDAO3 = new StudentRequirementDAO();
				studentRequirementDAO3
						.insertNonAcademicStudentRequirementMapping(stdNonAcaRequirementMappingVO);

			}
		}
		searchStudentRequirement(request,response);

		
	}

	protected void searchStudentRequirementTeacherSide(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("studentId"));

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(studentId);

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List list = studentRequirementDAO.searchStudentRequirement(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("studentRequirementList", list);

		List list2 = studentRequirementDAO.searchStdAcaRequirement(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("stdAcaRequirementList", list2);

		StudentRequirementDAO studentRequirementDAO3 = new StudentRequirementDAO();
		List list3 = studentRequirementDAO3.searchStdNonAcaRequirement(loginVO);
		System.out.println("list3 :: " + list3.size());

		session.setAttribute("stdNonAcaRequirementList", list3);

		response.sendRedirect("user/viewStudentRequirementTeacherSide.jsp");

	}

	protected void searchStudentRequirement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		/*
		 * HttpSession session3 = request.getSession(); int req=
		 * session3.getAttribute("StudentRequirementId");
		 */

		StudentRequirementDAO studentRequirementDAO = new StudentRequirementDAO();
		List list = studentRequirementDAO.searchStudentRequirement(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("studentRequirementList", list);

		List list2 = studentRequirementDAO.searchStdAcaRequirement(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("stdAcaRequirementList", list2);

		StudentRequirementDAO studentRequirementDAO3 = new StudentRequirementDAO();
		List list3 = studentRequirementDAO3.searchStdNonAcaRequirement(loginVO);
		System.out.println("list3 :: " + list3.size());

		session.setAttribute("stdNonAcaRequirementList", list3);

		response.sendRedirect("user/viewStudentRequirement.jsp");

	}

	protected void applyDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Integer loginId = (Integer) request.getSession()
		 * .getAttribute("loginId"); LoginVO loginVO = new LoginVO();
		 * loginVO.setUserId(loginId);
		 */

		Integer loginId = (Integer) request.getSession().getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		
		int teacherRequirementId = Integer.parseInt(request.getParameter("teacherRequirementId"));

		Integer reqId = (Integer) request.getSession().getAttribute("StudentRequirementId");

		
		  System.out.println("hellooooDhruv" +reqId);
		 

		LoginVO loginVO1 = new LoginVO();
		loginVO1.setUserId(teacherId);
		
		TeacherRequirementVO teacherRequirementVO = new TeacherRequirementVO();
		teacherRequirementVO.setTeacherRequirementId(teacherRequirementId);

		StudentRequirementVO studentRequirementVO = new StudentRequirementVO();
		studentRequirementVO.setStudentRequirementId(reqId);

		ApplyVO applyVO = new ApplyVO();
		applyVO.setStudentId(loginVO);
		applyVO.setTeacherId(loginVO1);
		applyVO.setStudentRequirementId(studentRequirementVO);
		applyVO.setTeacherRequirementId(teacherRequirementVO);

		
		ApplyDAO applyDAO = new ApplyDAO();
		applyDAO.Apply(applyVO);
		
	
		
		

		response.sendRedirect("user/viewTeacher.jsp");

	}
	
	

	protected void searchDemoDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("studentId"));

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(studentId);

		StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
		List ls = studentRegistrationDAO.searchStudentDetails(loginVO);
		
		StudentRequirementDAO studentRequirementDAO=new StudentRequirementDAO();
		List ls1 = studentRequirementDAO.searchStudentRequirement(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("studentListForDemo", ls);
		HttpSession session1 = request.getSession();
		session1.setAttribute("studentRequirementList", ls1);

		response.sendRedirect("user/demoLecture.jsp");

	}

	protected void searchDemoDetailsForStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		DemoDAO demoDAO = new DemoDAO();
		List list = demoDAO.findDemoDetailsForStudent(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("demoList", list);

		PrintWriter out = response.getWriter();
		System.out.println("LSSSSS :" + list.size());

		response.sendRedirect("user/demoDetailsForStudent.jsp");

	}
	
	protected void searchDemoDetailsForTeacher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		DemoDAO demoDAO = new DemoDAO();
		List list = demoDAO.findDemoDetailsForTeacher(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("demoListForTeacher", list);

		PrintWriter out = response.getWriter();
		System.out.println("LSSSSS :" + list.size());

		response.sendRedirect("user/demoDetailsForTeacher.jsp");

	}


}
