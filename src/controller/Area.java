package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AreaDAO;
import DAO.CityDAO;
import VO.AreaVO;
import VO.CityVO;

/**
 * Servlet implementation class area
 */
@WebServlet("/Area")
public class Area extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Area() {
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

		if (flag.equals("searchArea")) {
			searchArea(request, response);
		}

		if (flag.equals("editArea")) {
			editArea(request, response);
		}

		if (flag.equals("deleteArea")) {
			deleteArea(request, response);
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

		if (flag.equals("insertArea")) {
			insertArea(request, response);
		}

		if (flag.equals("updateArea")) {
			updateArea(request, response);
		}

	}

	protected void searchCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CityDAO cityDAO = new CityDAO();
		List l = cityDAO.searchCity();

		HttpSession session = request.getSession();
		session.setAttribute("cityList", l);

		response.sendRedirect("admin/addArea.jsp");
	}

	protected void searchArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AreaDAO areaDAO = new AreaDAO();
		List l1 = areaDAO.searchArea();

		HttpSession session = request.getSession();
		session.setAttribute("areaList", l1);

		response.sendRedirect("admin/searchArea.jsp");

	}

	protected void editArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("areaId"));

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(s1);

		AreaDAO areaDAO = new AreaDAO();
		List l = areaDAO.editArea(areaVO);

		HttpSession session = request.getSession();
		session.setAttribute("editAreaList", l);

		CityDAO cityDAO = new CityDAO();
		List l1 = cityDAO.searchCity();
		session.setAttribute("cityList", l1);

		response.sendRedirect("admin/editArea.jsp");

	}

	protected void deleteArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("areaId"));

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(s1);

		AreaDAO areaDAO = new AreaDAO();
		areaDAO.deleteArea(areaVO);

		AreaDAO areaDAO2 = new AreaDAO();
		List l = areaDAO2.searchArea();

		HttpSession session = request.getSession();
		session.setAttribute("areaList", l);

		response.sendRedirect("admin/searchArea.jsp");

	}

	protected void insertArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("areaName");
		String s2 = request.getParameter("areaDesc");
		Integer s3 = Integer.parseInt(request.getParameter("cityDrop"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(s3);

		AreaDAO areaDAO = new AreaDAO();
		// d.insert1(v1);

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaName(s1);
		areaVO.setAreaDesc(s2);
		areaVO.setCityVO(cityVO);

		areaDAO.insertArea(areaVO);
		response.sendRedirect("admin/addArea.jsp");

	}

	protected void updateArea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("areaId"));
		String s2 = request.getParameter("areaName");
		String s3 = request.getParameter("areaDesc");
		Integer s4 = Integer.parseInt(request.getParameter("cityDrop"));

		CityVO cityVO = new CityVO();
		cityVO.setCityId(s4);

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(s1);
		areaVO.setAreaName(s2);
		areaVO.setAreaDesc(s3);
		areaVO.setCityVO(cityVO);

		AreaDAO areaDAO = new AreaDAO();
		areaDAO.updateArea(areaVO);

		AreaDAO areaDAO2 = new AreaDAO();
		List l = areaDAO2.searchArea();

		HttpSession session = request.getSession();
		session.setAttribute("areaList", l);

		response.sendRedirect("admin/searchArea.jsp");

	}

}
