package sis.com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sis.com.bo.Attributes;
import sis.com.dao.AttributeDao;
import sis.com.dao.BenificaryDao;
import sis.com.daoFactory.DaoFactory;

/**
 * Servlet implementation class SetAttributes
 */
public class SetAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Attributes attributes = new Attributes();
		if(request.getParameter("name")!=null){
			attributes.setName(request.getParameter("name"));
		}else{
			attributes.setName("no");
		}
		
		if(request.getParameter("age")!=null){
			attributes.setAge(request.getParameter("age"));
		}else{
			attributes.setAge("no");
		}
		if(request.getParameter("gender")!=null){
			attributes.setGender(request.getParameter("gender"));
		}else{
			attributes.setGender("no");
		}
		if(request.getParameter("mobile")!=null){
			attributes.setMobile(request.getParameter("mobile"));
		}else{
			attributes.setMobile("no");
		}
		if(request.getParameter("husband")!=null){
			attributes.setHusband(request.getParameter("husband"));
		}else{
			attributes.setHusband("no");
		}
		if(request.getParameter("dob")!=null){
			attributes.setDob(request.getParameter("dob"));
		}else{
			attributes.setDob("no");
		}
		if(request.getParameter("email")!=null){
			attributes.setEmail(request.getParameter("email"));
		}else{
			attributes.setEmail("no");
		}
		if(request.getParameter("adhharNo")!=null){
			attributes.setAdhharNo(request.getParameter("adhharNo"));
		}else{
			attributes.setAdhharNo("no");
		}
		if(request.getParameter("address")!=null){
			attributes.setAddress(request.getParameter("address"));
		}else{
			attributes.setAddress("no");
		}
		if(request.getParameter("hostel")!=null){
			attributes.setHostel(request.getParameter("hostel"));
		}else{
			attributes.setHostel("no");
		}
		if(request.getParameter("school")!=null){
			attributes.setSchool(request.getParameter("school"));
		}else{
			attributes.setSchool("no");
		}
		if(request.getParameter("hospital")!=null){
			attributes.setHospital(request.getParameter("hospital"));
		}else{
			attributes.setHospital("no");
		}
		if(request.getParameter("panchayat")!=null){
			attributes.setPanchayat(request.getParameter("panchayat"));
		}else{
			attributes.setPanchayat("no");
		}
		if(request.getParameter("district")!=null){
			attributes.setDistrict(request.getParameter("district"));
			System.out.println("*********"+attributes.getDistrict());
		}else{
			attributes.setDistrict("no");
		}
		if(request.getParameter("block")!=null){
			attributes.setBlock(request.getParameter("block"));
		}else{
			attributes.setBlock("no");
		}
		if(request.getParameter("cast")!=null){
			attributes.setCast(request.getParameter("cast"));
		}else{
			attributes.setCast("no");
		}
	
		if(request.getParameter("file_aadhar")!=null){
			attributes.setFile_aadhar(request.getParameter("file_aadhar"));
		}else{
			attributes.setFile_aadhar("no");
		}
		if(request.getParameter("file_cast")!=null){
			attributes.setFile_cast(request.getParameter("file_cast"));
		}else{
			attributes.setFile_cast("no");
		}
		if(request.getParameter("file_passbook")!=null){
			attributes.setFile_passbook(request.getParameter("file_passbook"));
		}else{
			attributes.setFile_passbook("no");
		}
		if(request.getParameter("d_l")!=null){
			attributes.setFile_driving(request.getParameter("d_l"));
		}else{
			attributes.setFile_driving("no");
		}
		if(request.getParameter("file_passbook")!=null){
			attributes.setFile_passbook(request.getParameter("file_passbook"));
		}else{
			attributes.setFile_passbook("no");
		}
		if(request.getParameter("file_other")!=null){
			attributes.setFile_other(request.getParameter("file_other"));
		}else{
			attributes.setFile_other("no");
		}
		if(request.getParameter("file_bpl")!=null){
			attributes.setFile_bpl(request.getParameter("file_bpl"));
		}else{
			attributes.setFile_bpl("no");
		}
		if(request.getParameter("file_residance")!=null){
			attributes.setFile_residance(request.getParameter("file_bpl"));
		}else{
			attributes.setFile_residance("no");
		}
		if(request.getParameter("file_10th")!=null){
			attributes.setFile_10th(request.getParameter("file_bpl"));
		}else{
			attributes.setFile_10th("no");
		}
		if(request.getParameter("file_12th")!=null){
			attributes.setFile_12th(request.getParameter("file_12th"));
		}else{
			attributes.setFile_12th("no");
		}
		attributes.setSchemeCode(request.getParameter("schemeCode"));
		System.out.println("schemeCode in controller"+attributes.getSchemeCode());
		AttributeDao dao=DaoFactory.getAttributeDao();
        boolean result=dao.addAttributesTOForm(attributes);//function call
        if(result==true){
        	response.sendRedirect("select-form.html");
        }
        System.out.println("attribute insertion result"+result);
	}

}
