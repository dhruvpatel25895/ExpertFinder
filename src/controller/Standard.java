package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CategoryVO;
import VO.MediumVO;
import VO.StandardVO;
import VO.SubCategoryVO;
import DAO.MediumDAO;
import DAO.StandardDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class standard
 */
@WebServlet("/Standard")
public class Standard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Standard() {
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

		if (flag.equals("editStandard")) {
			editStandard(request, response);
		}

		if (flag.equals("deleteStandard")) {
			deleteStandard(request, response);
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

		if (flag.equals("insertStandard")) {
			insertStandard(request, response);
		}

		if (flag.equals("updateStandard")) {
			updateStandard(request, response);
		}

	}

	protected void searchAcademicCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l = subCategoryDAO.searchAcademicCategory();

		HttpSession session = request.getSession();
		session.setAttribute("academicCategoryList", l);

		response.sendRedirect("admin/addStandard.jsp");

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

		StandardDAO standardDAO = new StandardDAO();
		List l1 = standardDAO.searchStandard();

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l1);

		response.sendRedirect("admin/searchStandard.jsp");

	}

	protected void editStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("standardId"));

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(s1);

		StandardDAO standardDAO = new StandardDAO();
		List l = standardDAO.editStandard(standardVO);

		HttpSession session = request.getSession();
		session.setAttribute("editStandardList", l);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchAcademicCategory();
		session.setAttribute("subCategoryList", l1);

		MediumDAO mediumDAO = new MediumDAO();
		List l2 = mediumDAO.searchMedium();
		session.setAttribute("mediumList", l2);

		response.sendRedirect("admin/editStandard.jsp");

	}

	protected void deleteStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("standardId"));

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(s1);

		StandardDAO standardDAO = new StandardDAO();
		standardDAO.deleteStandard(standardVO);

		StandardDAO standardDAO2 = new StandardDAO();
		List l = standardDAO2.searchStandard();

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l);

		response.sendRedirect("admin/searchStandard.jsp");

	}

	protected void insertStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("standardName");
		String s2 = request.getParameter("standardDesc");

		Integer s3 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));
		Integer s4 = Integer.parseInt(request.getParameter("mediumDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s3);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s4);

		StandardDAO standardDAO = new StandardDAO();

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardName(s1);
		standardVO.setStandardDesc(s2);

		standardVO.setSubCategoryVO(subCategoryVO);
		standardVO.setMediumVO(mediumVO);

		standardDAO.insertStandard(standardVO);
		response.sendRedirect("admin/addStandard.jsp");

	}

	protected void updateStandard(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("standardId"));
		String s2 = request.getParameter("standardName");
		String s3 = request.getParameter("standardDesc");

		Integer s4 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));
		Integer s5 = Integer.parseInt(request.getParameter("mediumDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s4);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s5);

		StandardVO standardVO = new StandardVO();
		standardVO.setStandardId(s1);
		standardVO.setStandardName(s2);
		standardVO.setStandardDesc(s3);

		standardVO.setSubCategoryVO(subCategoryVO);
		standardVO.setMediumVO(mediumVO);

		StandardDAO standardDAO = new StandardDAO();
		standardDAO.updateStandard(standardVO);

		StandardDAO standardDAO2 = new StandardDAO();
		List l = standardDAO2.searchStandard();

		HttpSession session = request.getSession();
		session.setAttribute("standardList", l);

		response.sendRedirect("admin/searchStandard.jsp");

	}

}
