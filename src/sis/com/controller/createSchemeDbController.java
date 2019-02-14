package sis.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.dao.AttributeDao;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class createSchemeDbController
 */
public class createSchemeDbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		System.out.println(session);
		String schemeCode= request.getParameter("schemeCode");
		System.out.println(schemeCode);
		AttributeDao dao=DaoFactory.getAttributeDao();
		 HashMap<String,ArrayList<String>> mapresult=dao.getFormDb(schemeCode);//function call
		 System.out.println("++++++"+mapresult.get("listName"));
		 System.out.println("++++++"+mapresult.get("listType"));
		 String tablename="scheme"+schemeCode;
		 boolean result=dao.createFormDb(mapresult.get("listName"),mapresult.get("listType"),tablename);
		 if(result==true){
			 System.out.println("result is"+result);
			 session.setAttribute("listName",mapresult.get("listName"));
			 session.setAttribute("listType",mapresult.get("listType"));
			 response.sendRedirect("createFormByDb.jsp");
		 }
		 System.out.println("result"+result);
		 
	}  //post
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schemeCode= request.getParameter("schemecode");
		System.out.println(schemeCode);
		HttpSession session= request.getSession();
		AttributeDao dao=DaoFactory.getAttributeDao();
		 HashMap<String,ArrayList<String>> mapresult=dao.getFormDb(schemeCode);//function call
		 System.out.println("++++++"+mapresult.get("listName"));
		 System.out.println("++++++"+mapresult.get("listType"));
		 String tablename="scheme"+schemeCode;
		 
		if(mapresult.get("listName")!=null){
			 session.setAttribute("listName",mapresult.get("listName"));
			 session.setAttribute("listType",mapresult.get("listType"));
			session.setAttribute("tablename",tablename);
			response.sendRedirect("createFormByDb.jsp");
		}
	}//get
}  //class
