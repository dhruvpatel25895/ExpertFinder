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
 * Servlet implementation class city
 */
@WebServlet("/City")
public class City extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public City() {
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

		if (flag.equals("searchCity")) {
			searchCity(request, response);
		}

		if (flag.equals("deleteCity")) {
			deleteCity(request, response);
		}

		if (flag.equals("editCity")) {
			editCity(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");

		if (flag.equals("insertCity")) {
			insertCity(request, response);
		}

		if (flag.equals("updateCity")) {
			updateCity(request, response);
		}

	}

	protected void searchCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CityDAO cityDAO = new CityDAO();
		List l = cityDAO.searchCity();

		HttpSession session = request.getSession();
		session.setAttribute("cityList", l);

		response.sendRedirect("admin/searchCity.jsp");

	}

	protected void deleteCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("cityId"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(s1);

		CityDAO cityDAO = new CityDAO();
		cityDAO.deleteCity(cityVO);

		CityDAO cityDAO2 = new CityDAO();
		List l = cityDAO2.searchCity();

		HttpSession session = request.getSession();
		session.setAttribute("cityList", l);

		response.sendRedirect("admin/searchCity.jsp");

	}

	protected void editCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int s1 = Integer.parseInt(request.getParameter("cityId"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(s1);

		CityDAO cityDAO = new CityDAO();
		List l = cityDAO.editCity(cityVO);

		HttpSession session = request.getSession();
		session.setAttribute("editCityList", l);

		response.sendRedirect("admin/editCity.jsp");

	}

	protected void insertCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String s1 = request.getParameter("cityName");
		String s2 = request.getParameter("cityDesc");

		CityVO cityVO = new CityVO();
		cityVO.setCityName(s1);
		cityVO.setCityDesc(s2);

		CityDAO cityDAO = new CityDAO();
		cityDAO.insertCity(cityVO);

		response.sendRedirect("admin/addCity.jsp");

	}

	protected void updateCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("cityId"));
		String s2 = request.getParameter("cityName");
		String s3 = request.getParameter("cityDesc");

		CityVO cityVO = new CityVO();
		cityVO.setCityId(s1);
		cityVO.setCityName(s2);
		cityVO.setCityDesc(s3);

		CityDAO cityDAO = new CityDAO();
		cityDAO.updateCity(cityVO);

		CityDAO cityDAO2 = new CityDAO();
		List l = cityDAO2.searchCity();

		HttpSession session = request.getSession();
		session.setAttribute("cityList", l);

		response.sendRedirect("admin/searchCity.jsp");

	}

}
