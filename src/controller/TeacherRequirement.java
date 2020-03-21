package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import VO.TeacherAcaRequirementMappingVO;
import VO.TeacherNonAcaRequirementMappingVO;
import VO.TeacherRequirementVO;
import DAO.AcademicSubjectDAO;
import DAO.ApplyDAO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.DemoDAO;
import DAO.MediumDAO;
import DAO.StandardDAO;
import DAO.StudentRegistrationDAO;
import DAO.StudentRequirementDAO;
import DAO.SubCategoryDAO;
import DAO.TeacherRequirementDAO;

/**
 * Servlet implementation class StudentRequirement
 */
@WebServlet("/TeacherRequirement")
@MultipartConfig
public class TeacherRequirement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherRequirement() {
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

		if (flag.equals("searchTeacherRequirement")) {
			searchTeacherRequirement(request, response);
		}

		if (flag.equals("appliedStudent")) {
			appliedStudent(request, response);
		}

		if (flag.equals("searchTeacherDetails")) {
			searchTeacherDetails(request, response);
		}

		if (flag.equals("searchMedium")) {
			searchMedium(request, response);
		}

		if (flag.equals("search")) {
			search(request, response);
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

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");

		if (flag.equals("insert")) {
			insert(request, response);
		}

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

		TeacherRequirementVO teacherRequirementVO = new TeacherRequirementVO();
		teacherRequirementVO.setAreaVO(areaVO);
		teacherRequirementVO.setCityVO(cityVO);
		teacherRequirementVO.setTime(time);
		teacherRequirementVO.setDay(day);
		teacherRequirementVO.setLoginVO(loginVO);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		teacherRequirementDAO.insertTeacherRequirement(teacherRequirementVO);

		if (categoryName != null) {
			for (int i = 0; i < categoryName.length; i++) {
				Integer categoryId = Integer.parseInt(categoryName[i]);
				Integer academicNameId = Integer.parseInt(academicCategory[i]);
				Integer mediumId = Integer.parseInt(medium[i]);
				Integer standardId = Integer.parseInt(standard[i]);
				Integer academicSubjectId = Integer
						.parseInt(academicSubject[i]);
				Integer academicFees = Integer.parseInt(request
						.getParameter("academicFees"));

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

				TeacherAcaRequirementMappingVO teacherAcaRequirementMappingVO = new TeacherAcaRequirementMappingVO();
				teacherAcaRequirementMappingVO.setCategoryVO(categoryVO);
				teacherAcaRequirementMappingVO.setSubCategoryVO(subCategoryVO);
				teacherAcaRequirementMappingVO.setMediumVO(mediumVO);
				teacherAcaRequirementMappingVO.setStandardVO(standardVO);
				teacherAcaRequirementMappingVO
						.setAcademicSubjectVO(academicSubjectVO);
				teacherAcaRequirementMappingVO
						.setTeacherRequirementVO(teacherRequirementVO);
				teacherAcaRequirementMappingVO.setAcademicFees(academicFees);
				teacherAcaRequirementMappingVO.setLoginVO(loginVO);

				TeacherRequirementDAO teacherRequirementDAO2 = new TeacherRequirementDAO();
				teacherRequirementDAO2
						.insertAcademicTeacherRequirementMapping(teacherAcaRequirementMappingVO);

			}
		}
		if (category != null) {
			for (int i = 0; i < category.length; i++) {
				Integer categoryId = Integer.parseInt(category[i]);
				Integer nonAcademicCategoryId = Integer
						.parseInt(nonAcademicCategory[i]);
				Integer nonAcademicSubjectId = Integer
						.parseInt(nonAcademicSubject[i]);
				Integer nonAcademicFees = Integer.parseInt(request
						.getParameter("nonAcademicFees"));

				CategoryVO categoryVO2 = new CategoryVO();
				categoryVO2.setCategoryId(categoryId);

				SubCategoryVO subCategoryVO2 = new SubCategoryVO();
				subCategoryVO2.setSubCategoryId(nonAcademicCategoryId);

				NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
				nonAcademicSubjectVO
						.setNonAcademicSubjectId(nonAcademicSubjectId);

				TeacherNonAcaRequirementMappingVO teacherNonAcaRequirementMappingVO = new TeacherNonAcaRequirementMappingVO();
				teacherNonAcaRequirementMappingVO.setCategoryVO(categoryVO2);
				teacherNonAcaRequirementMappingVO
						.setSubCategoryVO(subCategoryVO2);
				teacherNonAcaRequirementMappingVO
						.setNonAcademicSubjectVO(nonAcademicSubjectVO);
				teacherNonAcaRequirementMappingVO
						.setTeacherRequirementVO(teacherRequirementVO);
				teacherNonAcaRequirementMappingVO
						.setNonAcademicFees(nonAcademicFees);
				teacherNonAcaRequirementMappingVO.setLoginVO(loginVO);

				TeacherRequirementDAO teacherRequirementDAO2 = new TeacherRequirementDAO();
				teacherRequirementDAO2
						.insertNonAcademicTeacherRequirementMapping(teacherNonAcaRequirementMappingVO);

			}
		}

		searchTeacherRequirement(request, response);

	}

	protected void searchTeacherRequirement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List list = teacherRequirementDAO.searchTeacherRequirement(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("teacherRequirementList", list);

		List list2 = teacherRequirementDAO.searchTeacherAcaRequirement(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("teacherAcaRequirementList", list2);

		List list3 = teacherRequirementDAO
				.searchTeacherNonAcaRequirement(loginVO);
		System.out.println("list3 :: " + list3.size());

		session.setAttribute("teacherNonAcaRequirementList", list3);

		response.sendRedirect("user/viewTeacherRequirement.jsp");

	}

	protected void searchTeacherDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("hiii");
		int loginId = Integer.parseInt(request.getParameter("loginId"));

		System.out.println("hiieeeeeeeei");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List list = teacherRequirementDAO.searchTeacherRequirement(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("teacherRequirementList", list);

		List list2 = teacherRequirementDAO.searchTeacherAcaRequirement(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("teacherAcaRequirementList", list2);

		List list3 = teacherRequirementDAO
				.searchTeacherNonAcaRequirement(loginVO);
		System.out.println("list3 :: " + list3.size());

		session.setAttribute("teacherNonAcaRequirementList", list3);

		System.out.println("list2 :: " + loginId);
		System.out.println("hiiii..." + loginId);

		response.sendRedirect("user/viewTeacherRequirementStudentSide.jsp");

	}

	protected void appliedStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		ApplyDAO applyDAO = new ApplyDAO();
		List ls = applyDAO.findAppliedStudent(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("studentList", ls);

		/*
		 * DemoVO demoVO = new DemoVO(); demoVO.setTeacherId(loginVO);
		 */

		DemoDAO demoDAO = new DemoDAO();
		List list = demoDAO.searchDemoDetails(loginVO);

		System.out.println("DemoDetails" + list.size());

		PrintWriter out = response.getWriter();
		System.out.println("LSSSSS :" + ls.size());

		HttpSession session1 = request.getSession();
		session1.setAttribute("demoDetails", list);

		response.sendRedirect("user/appliedStudent.jsp");

	}

	protected void searchMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List l1 = teacherRequirementDAO.searchMedium(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l1);

		response.sendRedirect("user/JSON/loadMedium.jsp");

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

		response.sendRedirect("user/teacherRequirement.jsp");
	}

	protected void searchStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int mediumId = Integer.parseInt(request.getParameter("mediumId"));

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(mediumId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List l1 = teacherRequirementDAO.searchStandard(mediumVO);

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l1);

		response.sendRedirect("user/JSON/loadStandard.jsp");
	}

	protected void searchAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int standardId = Integer.parseInt(request.getParameter("standardId"));

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(standardId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List l1 = teacherRequirementDAO.searchAcademicSubject(standardVO);

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

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List l1 = teacherRequirementDAO.searchNonAcademicSubject(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicSubjectList", l1);

		response.sendRedirect("user/JSON/loadNonAcademicSubject.jsp");
	}

	protected void searchArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int cityId = Integer.parseInt(request.getParameter("cityId"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);

		TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
		List l1 = teacherRequirementDAO.searchArea(cityVO);

		HttpSession session = request.getSession();
		session.setAttribute("areaList", l1);

		response.sendRedirect("user/JSON/loadArea.jsp");
	}

}
