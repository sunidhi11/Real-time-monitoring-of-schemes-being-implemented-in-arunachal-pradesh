package sis.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.bo.Benificary;
import sis.com.dao.BenificaryDao;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class ViewBenificiaryController
 */
public class ViewBenificiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Benificary benificiary=null;
		
		int applicantId=Integer.parseInt(request.getParameter("id"));
		System.out.println("applicant id in controller==================="+applicantId);
		if(applicantId!=0){
			BenificaryDao dao=DaoFactory.getBenificaryDao();
			benificiary= dao.ShowBenificiaryById(applicantId);
			
			 if(benificiary!=null){
					session.setAttribute("benificiary",benificiary);
				}
				
			response.sendRedirect("viewBenificiaryProfile.jsp");
		}
		}
	}


