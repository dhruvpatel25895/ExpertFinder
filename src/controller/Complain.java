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

import DAO.CityDAO;
import DAO.ComplainDAO;
import DAO.LoginDAO;
import VO.CityVO;
import VO.ComplainVO;
import VO.LoginVO;

/**
 * Servlet implementation class complain
 */
@WebServlet("/Complain")
public class Complain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Complain() {
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

		if (flag.equals("searchAdmin")) {
			searchAdmin(request, response);
		}

		if (flag.equals("searchComplain")) {
			searchComplain(request, response);
		}

		if (flag.equals("deleteComplain")) {
			deleteComplain(request, response);
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

		if (flag.equals("insertComplain")) {
			insertComplain(request, response);
		}

	}

	protected void searchAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.complainAdmin();

		HttpSession s = request.getSession();
		s.setAttribute("adminlist", ls);

		response.sendRedirect("user/postComplain.jsp");

	}

	protected void searchComplain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ComplainDAO complainDAO = new ComplainDAO();
		List l = complainDAO.searchComplain();

		HttpSession session = request.getSession();
		session.setAttribute("complainList", l);

		response.sendRedirect("admin/searchComplain.jsp");

	}

	protected void deleteComplain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("complainId"));

		ComplainVO complainVO = new ComplainVO();
		complainVO.setComplainId(s1);

		ComplainDAO complainDAO = new ComplainDAO();
		complainDAO.deleteComplain(complainVO);

		ComplainDAO complainDAO2 = new ComplainDAO();
		List l = complainDAO2.searchComplain();

		HttpSession session = request.getSession();
		session.setAttribute("complainList", l);

		response.sendRedirect("admin/searchComplain.jsp");

	}

	protected void insertComplain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int fromId = Integer.parseInt(request.getParameter("fromUser"));
		int toId = Integer.parseInt(request.getParameter("toUser"));
		String complainTitle = request.getParameter("complainTitle");
		String complainDesc = request.getParameter("complainDescription");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(fromId);

		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserId(toId);

		ComplainVO complainVO = new ComplainVO();
		complainVO.setComplainName(complainTitle);
		complainVO.setComplainDesc(complainDesc);
		complainVO.setFromUserId(loginVO);
		complainVO.setToUserId(loginVO2);

		ComplainDAO complainDAO = new ComplainDAO();
		complainDAO.insertComplain(complainVO);

		response.sendRedirect("user/index.jsp");

	}

}
