package sis.com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.bo.Benificary;
import sis.com.dao.DynamicFormDao;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class PreviewDynamicFormController
 */
public class PreviewDynamicFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 ArrayList<String> AllFormFields=(ArrayList<String>)session.getAttribute("AllFormFields");
		 ArrayList<String> AllFieldList=(ArrayList<String>)session.getAttribute("listName");
		 ArrayList<String> AllFieldType=(ArrayList<String>)session.getAttribute("listType");
		 String tablename= (String)session.getAttribute("tablename");
		if(AllFormFields!=null){
			

			DynamicFormDao dao=DaoFactory.geDynamicFormDao();
			
        boolean result=dao.insertDynamicForm(request);//function call
        
        session.setAttribute("result",result);
        response.sendRedirect("createFormByDb.jsp");
	}

}
} //class
