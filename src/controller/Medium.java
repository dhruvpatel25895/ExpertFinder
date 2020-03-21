package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import VO.MediumVO;
import VO.SubCategoryVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.MediumDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class medium
 */
@WebServlet("/Medium")
public class Medium extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Medium() {
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

		if (flag.equals("editMedium")) {
			editMedium(request, response);
		}

		if (flag.equals("deleteMedium")) {
			deleteMedium(request, response);
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

		if (flag.equals("insertMedium")) {
			insertMedium(request, response);
		}

		if (flag.equals("updateMedium")) {
			updateMedium(request, response);
		}

	}

	protected void searchAcademicCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l = subCategoryDAO.searchAcademicCategory();

		HttpSession session = request.getSession();
		session.setAttribute("academicCategoryList", l);

		response.sendRedirect("admin/addMedium.jsp");

	}

	protected void searchMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MediumDAO mediumDAO = new MediumDAO();
		List l1 = mediumDAO.searchMedium();

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l1);

		response.sendRedirect("admin/searchMedium.jsp");

	}

	protected void editMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("mediumId"));

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s1);

		MediumDAO mediumDAO = new MediumDAO();
		List l = mediumDAO.editMedium(mediumVO);

		HttpSession session = request.getSession();
		session.setAttribute("editMediumList", l);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchAcademicCategory();
		session.setAttribute("subCategoryList", l1);

		response.sendRedirect("admin/editMedium.jsp");

	}

	protected void deleteMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("mediumId"));

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s1);

		MediumDAO mediumDAO = new MediumDAO();
		mediumDAO.deleteMedium(mediumVO);

		MediumDAO mediumDAO2 = new MediumDAO();
		List l = mediumDAO2.searchMedium();

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l);

		response.sendRedirect("admin/searchMedium.jsp");

	}

	protected void insertMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("mediumName");

		Integer s2 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s2);

		MediumDAO mediumDAO = new MediumDAO();
		// d.insert1(v1);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumName(s1);

		mediumVO.setSubCategoryVO(subCategoryVO);

		mediumDAO.insertMedium(mediumVO);
		response.sendRedirect("admin/addMedium.jsp");

	}

	protected void updateMedium(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("mediumId"));
		String s2 = request.getParameter("mediumName");

		Integer s4 = Integer.parseInt(request
				.getParameter("aceademicCategoryDrop"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s4);

		MediumVO mediumVO = new MediumVO();
		mediumVO.setMediumId(s1);
		mediumVO.setMediumName(s2);

		mediumVO.setSubCategoryVO(subCategoryVO);

		MediumDAO mediumDAO = new MediumDAO();
		mediumDAO.updateMedium(mediumVO);

		MediumDAO mediumDAO2 = new MediumDAO();
		List l = mediumDAO2.searchMedium();

		HttpSession session = request.getSession();
		session.setAttribute("mediumList", l);

		response.sendRedirect("admin/searchMedium.jsp");

	}
}
