package filter;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import DAO.TeacherRequirementDAO;
import VO.LoginVO;
import VO.TeacherRequirementVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		
		String flag = request.getParameter("flag");
		//System.out.println("registration flag===" + flag);
		//	int i = (Integer)session.getAttribute("userID");
		//System.out.println("id = = = = =" + i);
		String uri = ((HttpServletRequest)request).getRequestURI();

		//System.out.println("link =  = = = = " + uri);

		if(uri.contains("Registration")||uri.contains("forgotPassword.jsp") ||uri.contains("ForgotPassword") || uri.contains("admin/LoadMenu.java")|| uri.contains("user/index.jsp") ||uri.contains(".css") || uri.contains(".js") && !uri.contains(".jsp")|| uri.contains("/img")|| uri.contains("/images")||uri.contains("/font") || uri.contains("/fonts"))
		{
			chain.doFilter(request,response);
		}

		else if (flag!= null && flag.equals("logout")) {
			//session.removeAttribute("userID");
			session.invalidate();
			System.out.println("after session invalidates");
			RequestDispatcher rd;
			((HttpServletResponse) response).sendRedirect("admin/login.jsp");
			//rd.forward(request, response);
		}
		else if(flag != null && flag.equals("login") )
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			System.out.println(userName+""+password);

			LoginVO loginVO = new LoginVO();
			loginVO.setUserName(userName);
			loginVO.setPassword(password);

			LoginDAO loginDAO = new LoginDAO();
			List list =  loginDAO.authentication(loginVO);

			if(list != null && list.size()>=1){

				//Iterator itr = list.iterator();

				//while(itr.hasNext()){
				LoginVO user=(LoginVO) list.get(0);

				int userId = (Integer)user.getUserId();
				session.setAttribute("loginId", userId);
				// code for search stardarID
				

				String type = user.getUsertype();
				session.setAttribute("usertype",type);
				
				String uName=user.getUserName();
				
				session.setAttribute("userName", uName);
				
				if(type.equals("admin"))
				{
					
					LoginDAO loginDAO2= new LoginDAO();
					List list1 =  loginDAO2.searchStudent();
						
					HttpSession session1 = ((HttpServletRequest) request).getSession();
					session1.setAttribute("studentCountList", list1.size());
					
					LoginDAO loginDAO3= new LoginDAO();
					List list2 =  loginDAO3.searchTeacher();
						
					HttpSession session2 = ((HttpServletRequest) request).getSession();
					session2.setAttribute("teacherCountList", list2.size());
					
					LoginDAO loginDAO4= new LoginDAO();
					List list3 =  loginDAO4.searchDemoList();
						
					HttpSession session3 = ((HttpServletRequest) request).getSession();
					session3.setAttribute("demoCountList", list3.size());
					
					LoginDAO loginDAO5= new LoginDAO();
					List list4 =  loginDAO5.searchAppliedList();
						
					HttpSession session4 = ((HttpServletRequest) request).getSession();
					session4.setAttribute("appliedCountList", list4.size());
					
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else if(type.equals("Student"))
				{
					requestDispatcher = request.getRequestDispatcher("/user/index.jsp");  
				
					requestDispatcher.forward(request,response);  
				}
				else if(type.equals("Teacher")){
				
					LoginVO loginVO1 = new LoginVO();
					loginVO1.setUserId(userId);
					
					TeacherRequirementDAO teacherRequirementDAO = new TeacherRequirementDAO();
					List list1 = teacherRequirementDAO.searchTeacherRequirement(loginVO1);
					
					HttpSession session5 = ((HttpServletRequest) request).getSession();
					session5.setAttribute("TeacherRequirementList", list1);
					
					System.out.println("ohhooooo"+list1.size());
					
					
					requestDispatcher = request.getRequestDispatcher("/user/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else
				{

					requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}

			else {
				requestDispatcher = request
						.getRequestDispatcher("/admin/login.jsp");
				requestDispatcher.forward(request, response);
			}	
		}

		else if(session.getAttribute("loginId") != null)
		{
			String h = (String)session.getAttribute("usertype");
			
			if(h!=null && h.equals("admin")){	 /*&& uri.contains("/admin")*/

				System.out.println("chain");
				chain.doFilter(request,response);
			}
			else if(h!=null && h.equals("Student")) 		/*&& uri.contains("/vendor")*/
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else if(h!=null && h.equals("Teacher")) 		/*&& uri.contains("/user")*/
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else{
				System.out.println("filter : error");
				RequestDispatcher rd = request.getRequestDispatcher("/user/error.jsp");  
				rd.forward(request,response);  
			}
		}
	
		else{
			System.out.println("In else");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
			rd.forward(request,response);  
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
