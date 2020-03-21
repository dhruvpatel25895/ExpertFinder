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
import DAO.FeedackDAO;
import DAO.LoginDAO;
import VO.CityVO;
import VO.ComplainVO;
import VO.FeedbackVO;
import VO.LoginVO;

/**
 * Servlet implementation class complain
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Feedback() {
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

		if (flag.equals("searchFeedback")) {
			searchFeedback(request, response);
		}

		if (flag.equals("searchTeacherForFeedback")) {
			searchTeacherForFeedback(request, response);
		}

		if (flag.equals("deleteFeedback")) {
			deleteFeedback(request, response);
		}
		if (flag.equals("searchRating")) {
			searchRating(request, response);
		}
		if (flag.equals("searchRatingFromStudent")) {
			searchRatingFromStudent(request, response);
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

		if (flag.equals("insertFeedback")) {
			insertFeedback(request, response);
		}

	}

	protected void searchAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.complainAdmin();

		HttpSession s = request.getSession();
		s.setAttribute("adminlist", ls);

		response.sendRedirect("user/postFeedback.jsp");

	}

	protected void searchFeedback(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FeedackDAO feedbackDAO = new FeedackDAO();
		List l = feedbackDAO.searchFeedback();

		HttpSession session = request.getSession();
		session.setAttribute("feedbackList", l);

		response.sendRedirect("admin/searchFeedback.jsp");

	}

	protected void searchTeacherForFeedback(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		FeedackDAO feedbackDAO = new FeedackDAO();
		List l = feedbackDAO.searchTeacherForFeedback(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("feedbackTeacherList", l);

		System.out.println("hello" + l.size());

		response.sendRedirect("user/postFeedback.jsp");

	}

	protected void searchRatingFromStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		FeedackDAO feedbackDAO = new FeedackDAO();
		List l = feedbackDAO.searchRatingForTeacher(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("feedbackRatingListForTeacher", l);

		System.out.println("hello" + l.size());

	response.sendRedirect("user/viewRatingForTeacher.jsp");

	}
	
	protected void searchRating(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int teacherId = Integer.parseInt(request
				.getParameter("teacherId"));

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");

		LoginVO loginVO = new LoginVO();
		
		loginVO.setUserId(teacherId);

		FeedackDAO feedbackDAO = new FeedackDAO();
		List l = feedbackDAO.searchRating(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("feedbackRatingList", l);

		System.out.println("hello" + l.size());

	response.sendRedirect("user/viewRating.jsp");

	}

	protected void deleteFeedback(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int s1 = Integer.parseInt(request.getParameter("feedbackId"));

		FeedbackVO feedbackVO = new FeedbackVO();
		feedbackVO.setFeedbackId(s1);

		FeedackDAO feedackDAO = new FeedackDAO();
		feedackDAO.deleteFeedback(feedbackVO);

		FeedackDAO feedackDAO2 = new FeedackDAO();
		List l = feedackDAO2.searchFeedback();

		HttpSession session = request.getSession();
		session.setAttribute("feedbackList", l);

		response.sendRedirect("admin/searchFeedback.jsp");

	}

	protected void insertFeedback(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int fromId = Integer.parseInt(request.getParameter("fromUser"));

		Integer toId = Integer.parseInt(request.getParameter("toUser"));
		String feedbackTitle = request.getParameter("feedbackTitle");
		String feedbackDesc = request.getParameter("feedbackDescription");

		String rating = request.getParameter("rating");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(fromId);

		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserId(toId);

		FeedbackVO feedbackVO = new FeedbackVO();
		feedbackVO.setFeedbackName(feedbackTitle);
		feedbackVO.setFeedbackDesc(feedbackDesc);
		feedbackVO.setRating(rating);
		feedbackVO.setFromUserId(loginVO);
		feedbackVO.setToUserId(loginVO2);

		FeedackDAO feedackDAO = new FeedackDAO();
		feedackDAO.insertFeedback(feedbackVO);

		response.sendRedirect("user/index.jsp");

	}

}
