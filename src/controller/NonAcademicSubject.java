package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.MediumVO;
import VO.NonAcademicSubjectVO;
import VO.SubCategoryVO;
import DAO.MediumDAO;
import DAO.NonAcademicSubjectDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class nonAcademicSubject
 */
@WebServlet("/NonAcademicSubject")
public class NonAcademicSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NonAcademicSubject() {
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

		if (flag.equals("searchNonAcademicCategory")) {
			searchNonAcademicCategory(request, response);
		}

		if (flag.equals("searchNonAcademicSubject")) {
			searchNonAcademicSubject(request, response);
		}

		if (flag.equals("editNonAcademicSubject")) {
			editNonAcademicSubject(request, response);
		}

		if (flag.equals("deleteNonAcademicSubject")) {
			deleteNonAcademicSubject(request, response);
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

		if (flag.equals("insertNonAcademicSubject")) {
			insertNonAcademicSubject(request, response);
		}

		if (flag.equals("updateNonAcademicSubject")) {
			updateNonAcademicSubject(request, response);
		}

	}

	protected void searchNonAcademicCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l = subCategoryDAO.searchNonAcademicCategory();

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicCategoryList", l);

		response.sendRedirect("admin/addNonAcademicSubject.jsp");

	}

	protected void searchNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		NonAcademicSubjectDAO nonAcademicSubjectDAO = new NonAcademicSubjectDAO();
		List l1 = nonAcademicSubjectDAO.searchNonAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicSubjectList", l1);

		response.sendRedirect("admin/searchNonAcademicSubject.jsp");

	}

	protected void editNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("nonAcademicSubjectId"));

		NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
		nonAcademicSubjectVO.setNonAcademicSubjectId(s1);

		NonAcademicSubjectDAO nonAcademicSubjectDAO = new NonAcademicSubjectDAO();
		List l = nonAcademicSubjectDAO
				.editNonAcademicSubject(nonAcademicSubjectVO);

		HttpSession session = request.getSession();
		session.setAttribute("editNonAcademicSubjectList", l);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchNonAcademicCategory();
		session.setAttribute("subCategoryList", l1);

		response.sendRedirect("admin/editNonAcademicSubject.jsp");

	}

	protected void deleteNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("nonAcademicSubjectId"));

		NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
		nonAcademicSubjectVO.setNonAcademicSubjectId(s1);

		NonAcademicSubjectDAO nonAcademicSubjectDAO = new NonAcademicSubjectDAO();
		nonAcademicSubjectDAO.deleteNonAcademicSubject(nonAcademicSubjectVO);

		NonAcademicSubjectDAO nonAcademicSubjectDAO2 = new NonAcademicSubjectDAO();
		List l = nonAcademicSubjectDAO2.searchNonAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicSubjectList", l);

		response.sendRedirect("admin/searchNonAcademicSubject.jsp");

	}

	protected void insertNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("nonAcademicSubjectName");
		String s2 = request.getParameter("nonAcademicSubjectDesc");

		Integer s3 = Integer.parseInt(request
				.getParameter("nonAceademicCategoryDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s3);

		NonAcademicSubjectDAO nonAcademicSubjectDAO = new NonAcademicSubjectDAO();
		// d.insert1(v1);

		NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
		nonAcademicSubjectVO.setNonAcademicSubjectName(s1);
		nonAcademicSubjectVO.setNonAcademicSubjectDesc(s2);

		nonAcademicSubjectVO.setSubCategoryVO(subCategoryVO);

		nonAcademicSubjectDAO.insertNonAcademicSubject(nonAcademicSubjectVO);
		response.sendRedirect("admin/addNonAcademicSubject.jsp");

	}

	protected void updateNonAcademicSubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("nonAcademicSubjectId"));
		String s2 = request.getParameter("nonAcademicSubjectName");
		String s3 = request.getParameter("nonAcademicSubjectDesc");

		Integer s4 = Integer.parseInt(request
				.getParameter("nonAceademicCategoryDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s4);

		NonAcademicSubjectVO nonAcademicSubjectVO = new NonAcademicSubjectVO();
		nonAcademicSubjectVO.setNonAcademicSubjectId(s1);
		nonAcademicSubjectVO.setNonAcademicSubjectName(s2);
		nonAcademicSubjectVO.setNonAcademicSubjectDesc(s3);
		nonAcademicSubjectVO.setSubCategoryVO(subCategoryVO);

		NonAcademicSubjectDAO nonAcademicSubjectDAO = new NonAcademicSubjectDAO();
		nonAcademicSubjectDAO.updateNonAcademicSubject(nonAcademicSubjectVO);

		NonAcademicSubjectDAO nonAcademicSubjectDAO2 = new NonAcademicSubjectDAO();
		List l = nonAcademicSubjectDAO2.searchNonAcademicSubject();

		HttpSession session = request.getSession();
		session.setAttribute("nonAcademicSubjectList", l);

		response.sendRedirect("admin/searchNonAcademicSubject.jsp");

	}

}
