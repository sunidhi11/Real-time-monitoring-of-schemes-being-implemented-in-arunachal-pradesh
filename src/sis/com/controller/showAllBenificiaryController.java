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
 * Servlet implementation class showAllBenificiaryController
 */
public class showAllBenificiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session= request.getSession();
		BenificaryDao dao=DaoFactory.getBenificaryDao();
		List<Benificary> benificiaryList= dao.ShowAllBenificiary();
		for(Benificary b:benificiaryList){
			System.out.println(">>>>>"+b.getName());
		}
		if(benificiaryList!=null){
			System.out.println("all set");
			session.setAttribute("benificiaryList",benificiaryList);
		}
		response.sendRedirect("showAllBenificiary.jsp");
	}

}
