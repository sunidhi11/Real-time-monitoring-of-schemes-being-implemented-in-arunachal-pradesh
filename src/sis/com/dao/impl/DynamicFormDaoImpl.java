package sis.com.dao.impl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sis.com.dao.DynamicFormDao;
import sis.com.util.SisDbUtil;
public class DynamicFormDaoImpl implements DynamicFormDao {

	@Override
	public boolean insertDynamicForm(HttpServletRequest request) {
		Connection con=null;
		 PreparedStatement pstmt=null;
		 int result=0;
		 ResultSet rs= null;
		 HttpSession session = request.getSession();
		 ArrayList<InputStream> AllNonFormFields=(ArrayList<InputStream>)session.getAttribute("AllNonFormFields");
		 ArrayList<String> AllFormFields=(ArrayList<String>)session.getAttribute("AllFormFields");
		 ArrayList<String> AllFieldList=(ArrayList<String>)session.getAttribute("listName");
		 ArrayList<String> AllFieldType=(ArrayList<String>)session.getAttribute("listType");
		 ArrayList<Integer> AllNonFormFieldsSize=(ArrayList<Integer>)session.getAttribute("allNonFormFieldsSize");
		 String tablename= (String)session.getAttribute("tablename");
		 int i=1;
		 int j=1;
		 int k=0;
		 
		try{
			con  = SisDbUtil.getConnection();
		
		
String sql="insert into"+" "+tablename+"(";
		for(String attribute:AllFieldList){
			if(i<AllFieldList.size()){
			sql=sql+attribute;
			sql=sql+",";
			i++;
			}else{
				sql=sql+attribute;	
				i++;
			}
		}  // for each
       sql=sql+")values(";
       for(String values:AllFormFields)
    		   if(j<AllFormFields.size()){
        sql = sql+"'"+values+"'"+",";
    		   j++;
    		   }else{
    			sql = sql+"'"+values+"'"; 
    			j++;
    		   }
		
		sql = sql+")";
			
/*			String sql="insert into"+" "+tablename+"(";
			for(String attribute:AllFieldList){
				if(i<AllFieldList.size()){
				sql=sql+attribute;
				sql=sql+",";
				i++;
				}else{
					sql=sql+attribute;	
					i++;
				}
			}  // for each
	       sql=sql+")values(";
	       for(int a=1;a<=AllNonFormFields.size();a++){
	    	   if(j<AllNonFormFields.size()){
	    	   sql=sql+"?,";
	    	   }
	    	   else{
	    		   sql=sql+"?";
	    	   }  //else
	       }  //for
	    	
			sql = sql+")";*/
		System.out.println(sql);
pstmt=con.prepareStatement(sql);
for(int a=0;a<AllNonFormFields.size();a++){
	pstmt.setBinaryStream(a+1,AllNonFormFields.get(a),(int)AllNonFormFieldsSize.get(a));
}  //for
result=pstmt.executeUpdate();
}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if(con!=null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(result==1){
			return true;
		}else
		return false;
	}  //method1
	
}  //class
