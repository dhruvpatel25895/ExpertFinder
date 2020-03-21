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
import VO.SubCategoryVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class subCategory
 */
@WebServlet("/SubCategory")
public class SubCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubCategory() {
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
		if (flag.equals("searchCategory")) {
			searchCategory(request, response);
		}
		if (flag.equals("searchSubCategory")) {
			searchSubCategory(request, response);
		}
		if (flag.equals("editSubCategory")) {
			editSubCategory(request, response);
		}
		if (flag.equals("deleteSubCategory")) {
			deleteSubCategory(request, response);
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

		if (flag.equals("insertSubCategory")) {
			insertSubCategory(request, response);
		}
		if (flag.equals("updateSubCategory")) {
			updateSubCategory(request, response);
		}

	}

	protected void searchCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO();
		List l = categoryDAO.searchCategory();

		HttpSession session = request.getSession();
		session.setAttribute("categoryList", l);

		response.sendRedirect("admin/addSubCategory.jsp");

	}

	protected void searchSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l1 = subCategoryDAO.searchSubCategory();

		HttpSession session = request.getSession();
		session.setAttribute("subCategoryList", l1);

		response.sendRedirect("admin/searchSubCategory.jsp");

	}

	protected void editSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s1);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List l = subCategoryDAO.editSubCategory(subCategoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("editSubCategoryList", l);

		CategoryDAO categoryDAO = new CategoryDAO();
		List l1 = categoryDAO.searchCategory();
		session.setAttribute("categoryList", l1);

		response.sendRedirect("admin/editSubCategory.jsp");

	}

	protected void deleteSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("subCategoryId"));

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s1);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.deleteSubCategory(subCategoryVO);

		SubCategoryDAO subCategoryDAO2 = new SubCategoryDAO();
		List l = subCategoryDAO2.searchSubCategory();

		HttpSession session = request.getSession();
		session.setAttribute("subCategoryList", l);

		response.sendRedirect("admin/searchSubCategory.jsp");

	}

	protected void insertSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("subCategoryName");
		String s2 = request.getParameter("subCategoryDesc");
		Integer s3 = Integer.parseInt(request.getParameter("categoryDrop"));

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(s3);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		// d.insert1(v1);

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryName(s1);
		subCategoryVO.setSubCategoryDesc(s2);
		subCategoryVO.setCategoryVO(categoryVO);

		subCategoryDAO.insertSubCategory(subCategoryVO);
		response.sendRedirect("admin/addSubCategory.jsp");

	}

	protected void updateSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("subCategoryId"));
		String s2 = request.getParameter("subCategoryName");
		String s3 = request.getParameter("subCategoryDesc");
		Integer s4 = Integer.parseInt(request.getParameter("categoryDrop"));

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(s4);

		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(s1);
		subCategoryVO.setSubCategoryName(s2);
		subCategoryVO.setSubCategoryDesc(s3);
		subCategoryVO.setCategoryVO(categoryVO);

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.updateSubCategory(subCategoryVO);

		SubCategoryDAO subCategoryDAO2 = new SubCategoryDAO();
		List l = subCategoryDAO2.searchSubCategory();

		HttpSession session = request.getSession();
		session.setAttribute("subCategoryList", l);

		response.sendRedirect("admin/searchSubCategory.jsp");

	}
}
