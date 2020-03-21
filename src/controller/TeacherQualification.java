package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.TeacherQualificationDAO;
import VO.LoginVO;
import VO.TeacherQualificationFileUploadVO;
import VO.TeacherQualificationVO;

/**
 * Servlet implementation class StudentRequirement
 */
@WebServlet("/TeacherQualification")
@MultipartConfig
public class TeacherQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherQualification() {
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

		if (flag.equals("searchTeacherQualification")) {
			searchTeacherQualification(request, response);
		}

		if (flag.equals("searchTeacherDetails")) {
			searchTeacherDetails(request, response);
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

		if (flag.equals("insert")) {
			insert(request, response);
		}

	}

	protected void insert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		String instituteName = request.getParameter("instituteName");
		String experienceYear = request.getParameter("experienceYear");
		String experienceDescription = request
				.getParameter("experienceDescription");
		String fileDescription = request.getParameter("fileDescription");

		TeacherQualificationVO teacherQualificationVO = new TeacherQualificationVO();
		teacherQualificationVO.setInstituteName(instituteName);
		teacherQualificationVO.setExperienceYear(experienceYear);
		teacherQualificationVO.setExperienceDescription(experienceDescription);
		teacherQualificationVO.setLoginVO(loginVO);

		TeacherQualificationDAO teacherQualificationDAO = new TeacherQualificationDAO();
		teacherQualificationDAO
				.insertTeacherQualification(teacherQualificationVO);

		for (Part filePart : request.getParts()) {
			if (filePart.getSubmittedFileName() != null
					&& !filePart.getSubmittedFileName().equals("")) {
				String fileName = ((Object) filePart).getSubmittedFileName();
				System.out.println(">> file Name :: " + fileName);

				InputStream fileContent = filePart.getInputStream();
				System.out.println(">> File Content :: " + fileContent);

				System.out.println(">> Desc :: " + fileDescription);
				System.out.println(">> filePart :: " + filePart);

				byte[] buffer = new byte[fileContent.available()];
				fileContent.read(buffer);

				String filePath = getServletContext().getRealPath(
						request.getServletPath());

				System.out.println(">> getServletContext : "
						+ getServletContext());
				System.out.println(">> Servlet Path : "
						+ getServletContext().getRealPath(
								request.getServletPath()));

				int path = filePath.lastIndexOf('\\');
				System.out.println(">> path : " + path);

				String path1 = filePath.substring(0, path) + "\\doc\\";
				System.out.println(">> path1 : " + path1);

				File targetFile = new File(path1 + fileName);

				OutputStream outStream = new FileOutputStream(targetFile);
				outStream.write(buffer);

				String finalPath = path1 + fileName;

				System.out.println("File Output Path :: " + finalPath);
				outStream.close();

				TeacherQualificationFileUploadVO teacherQualificationFileUploadVO = new TeacherQualificationFileUploadVO();
				teacherQualificationFileUploadVO
						.setFileDescription(fileDescription);
				teacherQualificationFileUploadVO.setFilePath(finalPath);
				teacherQualificationFileUploadVO
						.setTeacherQualificationVO(teacherQualificationVO);
				teacherQualificationFileUploadVO.setFileName(fileName);
				teacherQualificationFileUploadVO.setLoginVO(loginVO);

				TeacherQualificationDAO teacherQualificationDAO2 = new TeacherQualificationDAO();
				teacherQualificationDAO2
						.insertFile(teacherQualificationFileUploadVO);

			}
		}
		
		searchTeacherQualification(request,response);
	

	}

	protected void searchTeacherQualification(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer loginId = (Integer) request.getSession()
				.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		TeacherQualificationDAO teacherRequirementDAO = new TeacherQualificationDAO();
		List list = teacherRequirementDAO.searchTeacherQualification(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("teacherDocumentList", list);

		List list2 = teacherRequirementDAO.searchTeacherFile(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("teacherFileList", list2);

		response.sendRedirect("user/viewTeacherQualification.jsp");
	}

	protected void searchTeacherDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int loginId = Integer.parseInt(request.getParameter("loginId"));

		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		TeacherQualificationDAO teacherRequirementDAO = new TeacherQualificationDAO();
		List list = teacherRequirementDAO.searchTeacherQualification(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("teacherDocumentList", list);

		List list2 = teacherRequirementDAO.searchTeacherFile(loginVO);
		System.out.println("list2 :: " + list2.size());

		session.setAttribute("teacherFileList", list2);

		response.sendRedirect("user/viewTeacherQualificationStudentSide.jsp");

	}

}
