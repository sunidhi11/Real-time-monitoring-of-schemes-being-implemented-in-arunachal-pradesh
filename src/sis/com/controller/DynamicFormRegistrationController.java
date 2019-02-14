package sis.com.controller;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import sis.com.bo.*;

/**
 * Servlet implementation class DynamicFormRegistrationController
 */
public class DynamicFormRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session= request.getSession();
		ArrayList<String> listName=(ArrayList<String>)session.getAttribute("listName");
		 ArrayList<String> listType=(ArrayList<String>)session.getAttribute("listType");
		 ArrayList<String> AllFormFields = new ArrayList<String>();
		 ArrayList<InputStream> AllNonFormFields = new ArrayList<InputStream>();
		 ArrayList<Integer> AllNonFormFieldsSize = new ArrayList<Integer>();
		 int i=0;
		 
		 Attributes attributes = new Attributes();
		 int formfieldcount=0;
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
						if((listName.get(i)).equalsIgnoreCase(paramItem.getFieldName())){
							AllFormFields.add(paramItem.getString());
						}
						formfieldcount=formfieldcount+1;
					i++;
					  }//data extraction end
				//file data process
	//========================================================
			     
		for (FileItem fileItem : allFileItemsList) {
		System.out.println("inside file processing*****************************");
			if((listName.get(i)).equalsIgnoreCase(fileItem.getFieldName())){
				System.out.println("file found student image processing+++++++*******");
				AllNonFormFields.add((fileItem.getInputStream()));
				AllNonFormFieldsSize.add((int)fileItem.getSize());
			}//if
			i++;
			
		}
		}catch(Exception e){
			e.printStackTrace();
			 System.out.println("File upload failed"+e.getMessage());
			 
		} 
		if(AllNonFormFields!=null||AllFormFields!=null){
			session.setAttribute("AllNonFormFields",AllNonFormFields);
			session.setAttribute("AllFormFields",AllFormFields);
			session.setAttribute("formfieldcount",formfieldcount);
			session.setAttribute("allNonFormFieldsSize",AllNonFormFieldsSize);
			System.out.println("page forwarding");
		        request.getRequestDispatcher("PreviewDynamicForm.jsp").forward(request,response);	
		        System.out.println("end.............");
			
		}	
			
}   //end of if
	}

}
