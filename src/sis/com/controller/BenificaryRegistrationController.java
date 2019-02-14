package sis.com.controller;

import java.io.IOException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sis.com.bo.Benificary;


/**
 * Servlet implementation class BenificaryRegistrationController
 */
public class BenificaryRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BenificaryRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Benificary benificiary  =new Benificary();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			
			try {
				// Parse the request
				List<FileItem> allMultipartsData = upload.parseRequest(request);
					
				List<FileItem> allNonFileData = new ArrayList<FileItem>();
				List<FileItem> allFileItemsList = new ArrayList<FileItem>();
				
				for (FileItem item : allMultipartsData) {
					if (item.isFormField()) {
						allNonFileData.add(item);
					}else if (!item.isFormField()) {
						allFileItemsList.add(item);
					}
				}
			     for (FileItem paramItem : allNonFileData) {
						//extract data
						if("dname".equalsIgnoreCase(paramItem.getFieldName())){
							benificiary.setDistrict(paramItem.getString());
						}else if("bname".equalsIgnoreCase(paramItem.getFieldName())){
							benificiary.setBlock(paramItem.getString());
					        
						}else if("vp".equalsIgnoreCase(paramItem.getFieldName())){
							benificiary.setPanchayat(paramItem.getString());
						}
						//try{
							 else if("hospital".equalsIgnoreCase(paramItem.getFieldName())){
								 benificiary.setHospital(paramItem.getString());
							 }
					             else if("name".equalsIgnoreCase(paramItem.getFieldName())){
					            	 benificiary.setName(paramItem.getString());
					             }
					            else if("fhname".equalsIgnoreCase(paramItem.getFieldName())){
					            	benificiary.setHusband(paramItem.getString());
					            }
					        	 else if("gender".equalsIgnoreCase(paramItem.getFieldName())){
					        		 benificiary.setGender(paramItem.getString());
					        	 }
					        	 else if("schemeCode".equalsIgnoreCase(paramItem.getFieldName())){
					        		 benificiary.setSchemeCode(paramItem.getString());
					        	 }
					        	  else if("address".equalsIgnoreCase(paramItem.getFieldName())){
					        		  benificiary.setAddress(paramItem.getString());
					        	  }
					              else if("contact".equalsIgnoreCase(paramItem.getFieldName())){
					            	  benificiary.setMobile(paramItem.getString());
					              }
					            
					              else if("date".equalsIgnoreCase(paramItem.getFieldName())){
					            	  benificiary.setDob(Date.valueOf(paramItem.getString()));
					              }
									    
					              else if("addhar".equalsIgnoreCase(paramItem.getFieldName())){
					            	  benificiary.setAdhharNo(paramItem.getString());

					              }
					              else if("maritial_status".equalsIgnoreCase(paramItem.getFieldName())){
					            	  benificiary.setMaritial(paramItem.getString());

					              }
					
					  }//data extraction end
				//file data process
	//========================================================
			     
		for (FileItem fileItem : allFileItemsList) {
		System.out.println("inside file processing*****************************");
			if("adhhar".equalsIgnoreCase(fileItem.getFieldName())){
				System.out.println("file found student image processing+++++++*******");
				benificiary.setAdhharProof(fileItem.getInputStream());
				benificiary.setAdhharProofName(fileItem.getName());
				benificiary.setAdhharProofSize((int)fileItem.getSize());
				
				}//if
			if("resident".equalsIgnoreCase(fileItem.getFieldName())){
				System.out.println("file found file processing+++++++*******");
				benificiary.setResidentProof(fileItem.getInputStream());
				benificiary.setResidentProofName(fileItem.getName());
				benificiary.setResidentProofSize((int)fileItem.getSize());
				}

		
		}
		}catch(Exception e){
			e.printStackTrace();
			 System.out.println("File upload failed"+e.getMessage());
			 
		} 
			HttpSession session = request.getSession();
		if(benificiary!=null){
			session.setAttribute("benificiaryinfo",benificiary);
			System.out.println("page forwarding");
		        request.getRequestDispatcher("PreviewRegister.jsp").forward(request,response);	
		        System.out.println("end.............");
			
		}	
			
}   //end of if
	
	}

}
