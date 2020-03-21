package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CategoryVO;
import VO.SubCategoryVO;
import DAO.CategoryDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class LoadMenu
 */
@WebServlet("/LoadMenu")
public class LoadMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadMenu() {
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

		CategoryDAO categoryDAO = new CategoryDAO();
		List<CategoryVO> categoryVOs = categoryDAO.searchCategory();

		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List<SubCategoryVO> subCategoryVOs = subCategoryDAO.searchSubCategory();

		Map mp = new HashMap();

		Iterator<CategoryVO> itr = categoryVOs.iterator();
		while (itr.hasNext()) {
			CategoryVO categoryVO = itr.next();
			Integer catId = categoryVO.getCategoryId();

			List<SubCategoryVO> list = new ArrayList<SubCategoryVO>();

			Iterator<SubCategoryVO> itr1 = subCategoryVOs.iterator();
			while (itr1.hasNext()) {
				SubCategoryVO subCategoryVO = itr1.next();
				Integer catIdFromSubCat = subCategoryVO.getCategoryVO()
						.getCategoryId();

				if (catId == catIdFromSubCat) {
					list.add(subCategoryVO);
				}
			}
			mp.put(categoryVO.getCategoryName(), list);
		}

		HttpSession session = request.getSession();
		session.setAttribute("menuList", mp);

		response.sendRedirect("user/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
