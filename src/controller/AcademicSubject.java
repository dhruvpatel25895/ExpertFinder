package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.AcademicSubjectVO;
import VO.MediumVO;
import VO.StandardVO;
import VO.SubCategoryVO;
import DAO.AcademicSubjectDAO;
import DAO.MediumDAO;
import DAO.StandardDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class academicSubject
 */
@WebServlet("/AcademicSubject")
public class AcademicSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademicSubject() {
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

		if (flag.equals("searchAcademicCategory")) {
			searchAcademicCategory(request, response);
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

		if (flag.equals("editAcademicSubject")) {
			editAcademicSubject(request, response);
		}

		if (flag.equals("deleteAcademicSubject")) {
			deleteAcademicSubject(request, response);
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

		if (flag.equals("insertAcademicSubject")) {
			insertAcademicSubject(request, response);
		}
		if (flag.equals("updateAcademicSubject")) {
			updateAcademicSubject(request, response);
		}
	}

	protected void insertAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("academicSubjectName");
		String s2 = request.getParameter("academicSubjectDesc");

		Integer s3 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));
		Integer s4 = Integer.parseInt(request.getParameter("mediumDrop"));
		Integer s5 = Integer.parseInt(request.getParameter("standardDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s3);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s4);

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(s5);

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();

		AcademicSubjectVO academicSubjectVO = new AcademicSubjectVO();
		academicSubjectVO.setAcademicSubjectName(s1);
		academicSubjectVO.setAcademicSubjectDesc(s2);

		academicSubjectVO.setSubCategoryVO(subCategoryVO);
		academicSubjectVO.setMediumVO(mediumVO);
		academicSubjectVO.setStandardVO(standardVO);

		academicSubjectDAO.insertAcademicSubject(academicSubjectVO);
		response.sendRedirect("admin/addAcademicSubject.jsp");

	}

	protected void updateAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("academicSubjectId"));
		String s2 = request.getParameter("academicSubjectName");
		String s3 = request.getParameter("academicSubjectDesc");

		Integer s4 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));
		Integer s5 = Integer.parseInt(request.getParameter("mediumDrop"));
		Integer s6 = Integer.parseInt(request.getParameter("standardDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s4);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s5);

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(s6);

		AcademicSubjectVO academicSubjectVO = new AcademicSubjectVO();
		academicSubjectVO.setAcademicSubjectId(s1);
		academicSubjectVO.setAcademicSubjectName(s2);
		academicSubjectVO.setAcademicSubjectDesc(s3);

		academicSubjectVO.setSubCategoryVO(subCategoryVO);
		academicSubjectVO.setMediumVO(mediumVO);
		academicSubjectVO.setStandardVO(standardVO);

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();
		academicSubjectDAO.updateAcademicSubject(academicSubjectVO);

		AcademicSubjectDAO academicSubjectDAO2 = new AcademicSubjectDAO();
		List l = academicSubjectDAO2.searchAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("academicSubjectList", l);

		response.sendRedirect("admin/searchAcademicSubject.jsp");

	}

	protected void searchAcademicCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l = subCategoryDAO.searchAcademicCategory();

		HttpSession session = request.getSession();
		session.setAttribute("academicCategoryList", l);

		response.sendRedirect("admin/addAcademicSubject.jsp");
	}

	protected void searchMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int subCategoryId = Integer.parseInt(request
				.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);

		StandardDAO standardDAO = new StandardDAO();
		List l1 = standardDAO.searchMedium(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l1);

		response.sendRedirect("admin/JSON/loadMedium.jsp");

	}

	protected void searchStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int mediumId = Integer.parseInt(request.getParameter("mediumId"));

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(mediumId);

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();
		List l1 = academicSubjectDAO.searchStandard(mediumVO);

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l1);

		response.sendRedirect("admin/JSON/loadStandard.jsp");

	}

	protected void searchAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();
		List l1 = academicSubjectDAO.searchAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("academicSubjectList", l1);

		response.sendRedirect("admin/searchAcademicSubject.jsp");

	}

	protected void editAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int s1 = Integer.parseInt(request.getParameter("academicSubjectId"));

		AcademicSubjectVO academicSubjectVO = new AcademicSubjectVO();
		academicSubjectVO.setAcademicSubjectId(s1);

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();
		List l = academicSubjectDAO.editAcademicSubject(academicSubjectVO);

		HttpSession session = request.getSession();
		session.setAttribute("editAcademicSubjectList", l);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchAcademicCategory();
		session.setAttribute("academicCategoryList", l1);

		MediumDAO mediumDAO = new MediumDAO();
		List l2 = mediumDAO.searchMedium();
		session.setAttribute("mediumList", l2);

		StandardDAO standardDAO = new StandardDAO();
		List l3 = standardDAO.searchStandard();
		session.setAttribute("standardList", l3);

		response.sendRedirect("admin/editAcademicSubject.jsp");
	}

	protected void deleteAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("academicSubjectId"));

		AcademicSubjectVO academicSubjectVO = new AcademicSubjectVO();
		academicSubjectVO.setAcademicSubjectId(s1);

		AcademicSubjectDAO academicSubjectDAO = new AcademicSubjectDAO();
		academicSubjectDAO.deleteAcademicSubject(academicSubjectVO);

		AcademicSubjectDAO academicSubjectDAO2 = new AcademicSubjectDAO();
		List l = academicSubjectDAO2.searchAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("academicSubjectList", l);

		response.sendRedirect("admin/searchAcademicSubject.jsp");

	}

}
