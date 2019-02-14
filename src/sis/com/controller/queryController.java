package sis.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.query1;
import sis.com.dao.query;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class queryController
 */
public class queryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("first_name");
		String lastName=request.getParameter("last_name");
		String email=request.getParameter("email");
		int contact=Integer.parseInt(request.getParameter("telephone"));
		String subject=request.getParameter("subject");
		String comment=request.getParameter("comments");
		String answer="no";
		query1 q=new query1();
		q.setFirstName(firstName);
		q.setLastName(lastName);
		q.setAnswer(answer);
		q.setEmail(email);
		q.setContact(contact);
		q.setSubject(subject);
		q.setQuery(comment);
		query queryDao=DaoFactory.getQueryDao();
		int insert=queryDao.insert(q);
		if(insert>1){
			response.sendRedirect("front.html");
		}
		
		
		
		
	}

}
