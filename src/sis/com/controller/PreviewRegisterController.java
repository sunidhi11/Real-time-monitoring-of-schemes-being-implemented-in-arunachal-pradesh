package sis.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.bo.Benificary;
import sis.com.dao.BenificaryDao;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class PreviewRegisterController
 */
public class PreviewRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewRegisterController() {
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
		HttpSession session = request.getSession();
		if((Benificary)session.getAttribute("benificiaryinfo")!=null){
			Benificary benificary=(Benificary)session.getAttribute("benificiaryinfo");
			

			BenificaryDao dao=DaoFactory.getBenificaryDao();
        boolean result=dao.addRegisteredBenificiary(benificary);//function call
        
        session.setAttribute("result",result);
        response.sendRedirect("applyforschemeform.html");
      
	}
	}

}
