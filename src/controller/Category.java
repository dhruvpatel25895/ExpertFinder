package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.CityDAO;
import VO.CategoryVO;
import VO.CityVO;

/**
 * Servlet implementation class category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Category() {
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

		if (flag.equals("deleteCategory")) {
			deleteCategory(request, response);
		}

		if (flag.equals("editCategory")) {
			editCategory(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");

		if (flag.equals("insertCategory")) {
			insertCategory(request, response);
		}

		if (flag.equals("updateCategory")) {
			updateCategory(request, response);
		}

	}

	protected void searchCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO();
		List l = categoryDAO.searchCategory();

		HttpSession session = request.getSession();
		session.setAttribute("categoryList", l);

		response.sendRedirect("admin/searchCategory.jsp");

	}

	protected void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int s1 = Integer.parseInt(request.getParameter("categoryId"));

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(s1);

		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.deleteCategory(categoryVO);

		CategoryDAO categoryDAO2 = new CategoryDAO();
		List l = categoryDAO2.searchCategory();

		HttpSession session = request.getSession();
		session.setAttribute("categoryList", l);

		response.sendRedirect("admin/searchCategory.jsp");

	}

	protected void editCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("categoryId"));

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(s1);

		CategoryDAO categoryDAO = new CategoryDAO();
		List l = categoryDAO.editCategory(categoryVO);

		HttpSession session = request.getSession();
		session.setAttribute("editCategoryList", l);

		response.sendRedirect("admin/editCategory.jsp");

	}

	protected void insertCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String s1 = request.getParameter("categoryName");
		String s2 = request.getParameter("categoryDesc");

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryName(s1);

		categoryVO.setCategoryDesc(s2);

		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.insertCategory(categoryVO);

		response.sendRedirect("admin/addCategory.jsp");

	}

	protected void updateCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("categoryId"));
		String s2 = request.getParameter("categoryName");
		String s3 = request.getParameter("categoryDesc");

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(s1);
		categoryVO.setCategoryName(s2);
		categoryVO.setCategoryDesc(s3);

		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.updateCategory(categoryVO);

		CategoryDAO categoryDAO2 = new CategoryDAO();
		List l = categoryDAO2.searchCategory();

		HttpSession session = request.getSession();
		session.setAttribute("categoryList", l);

		response.sendRedirect("admin/searchCategory.jsp");

	}
}
