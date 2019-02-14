package sis.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.dao.AdminAddScheme;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class StudentLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("Password");
		
		
		
		//validation from database
		AdminAddScheme dao=DaoFactory.getAdminAddScheme();
		boolean result= dao.validateAdminLogin(userName,password);
		//System.out.println("student object have -->> "+student.getHostelId());
		System.out.println("reult is"+result);
		if(result==false) {
			
			response.sendRedirect("AdminLogin.jsp");
			
		}
		//here is sesssion
		if(result==true){
			
			
			response.sendRedirect("admin1.html");
		}
	}

}
