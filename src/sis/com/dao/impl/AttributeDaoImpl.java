package sis.com.dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sis.com.bo.Attributes;
import sis.com.bo.Benificary;
import sis.com.dao.AttributeDao;
import sis.com.util.SisDbUtil;

public class AttributeDaoImpl implements AttributeDao {

	@Override
	public boolean addAttributesTOForm(Attributes attributes) {

		Connection con=null;
		PreparedStatement pstmt=null;
		int rs=0;

		
			 try { 

					con  = SisDbUtil.getConnection();
					String sql ="insert into attribute(schemeCode,name,age,gender,email,mobile,"
							+ "husband,dob,hostel,school,hospital,panchayat,adhharNo,cast,District,Block,address,passbookProof,drivingProof,bplProof,residentProof,10thProof,12thProof,adhharProof)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt  = con.prepareStatement(sql);
					pstmt.setString(1,attributes.getSchemeCode());
					pstmt.setString(2,attributes.getName());
					pstmt.setString(3,attributes.getAge());
					pstmt.setString(4,attributes.getGender());
					pstmt.setString(5,attributes.getEmail());
					pstmt.setString(6, attributes.getMobile());
					pstmt.setString(7,attributes.getHusband());
					pstmt.setString(8,attributes.getDob());
					pstmt.setString(9,attributes.getHostel());
					pstmt.setString(10,attributes.getSchool());
					pstmt.setString(11,attributes.getHospital());
					pstmt.setString(12,attributes.getPanchayat());
					pstmt.setString(13,attributes.getAdhharNo());
					pstmt.setString(14,attributes.getCast());
					pstmt.setString(15,attributes.getDistrict());
					pstmt.setString(16,attributes.getBlock());
					pstmt.setString(17,attributes.getAddress());
					pstmt.setString(18,attributes.getFile_passbook());
					pstmt.setString(19,attributes.getFile_driving());
					pstmt.setString(20,attributes.getFile_bpl());
					pstmt.setString(21,attributes.getFile_residance());
					pstmt.setString(22,attributes.getFile_10th());
					pstmt.setString(23,attributes.getFile_12th());
					pstmt.setString(24,attributes.getFile_aadhar());
					
			    rs=	pstmt.executeUpdate();
			    	
				if(rs>0){
					return true;
				}	else{
					return false;
				}
				
				}
				  catch (SQLException e) {
					e.printStackTrace();
					}catch (Exception e2) {
						e2.printStackTrace();
					}finally{
						if(con!=null){
							try {
								con.close();
							} catch (Exception e3) {
								e3.printStackTrace();
							}//catch
						}//if
					}//finally
		return false;
	}   // method 1
	public HashMap<String,ArrayList<String>> getFormDb(String schemeCode){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		ArrayList<String>coulmnName = new ArrayList<String>();
		ArrayList<String>coulmnType=new ArrayList<String>();
			 try { 

					con  = SisDbUtil.getConnection();
					String sql ="select * from attribute where schemeCode=?";
					pstmt  = con.prepareStatement(sql);
					pstmt.setString(1,schemeCode);
			    rs=	pstmt.executeQuery();
			    ResultSetMetaData rsmd = rs.getMetaData();
	            int colCount = rsmd.getColumnCount();
	            
			    if(rs.next()){
			    	System.out.println("++++++++++++++++++++");
			    	 for (int i = 1; i<= colCount; i++)
			            {
			    		 if(rs.getString(i).equalsIgnoreCase("yes")){
			    			 coulmnName.add(rsmd.getColumnName(i));
			    			 coulmnType.add(rsmd.getColumnTypeName(i));
			    	
			    		 }   //if
					 
				 }  //for
			    	 
			    }  //if
			   
				}  //try
			
				  catch (SQLException e) {
					e.printStackTrace();
					}catch (Exception e2) {
						e2.printStackTrace();
					}finally{
						if(con!=null){
							try {
								con.close();
							} catch (Exception e3) {
								e3.printStackTrace();
							}//catch
						}//if
					}//finally
			 HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();    
			    map.put("listName",coulmnName);
			    map.put("listType",coulmnType);
		return map;
		
	}  //method2
	@Override
	public boolean createFormDb(ArrayList<String> columnName,
			ArrayList<String> columnType,String tablename) {

		Connection con=null;
		PreparedStatement pstmt=null;
		int rs=0;

		
			 try { 

					con  = SisDbUtil.getConnection();
					int i=0;

					String sql = "CREATE TABLE IF NOT EXISTS sih."+tablename+"(applicantID INT NOT NULL AUTO_INCREMENT,";
							for(String value1:columnName){
								sql=sql+""+value1;
								if(columnType.get(i).equalsIgnoreCase("varchar")){
									sql=sql+" "+columnType.get(i)+"(45),";
								}else{
									sql=sql+" "+columnType.get(i)+",";
								}
								i++;
							}
							sql=sql+"PRIMARY KEY (applicantID))";
							sql=sql+ "ENGINE=InnoDB DEFAULT CHARSET=utf8";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeUpdate();
					System.out.println(sql);
					
					
					DatabaseMetaData dbm = con.getMetaData();
					ResultSet r  = dbm.getTables(null, null, tablename, null);
					if(r.next()){
						System.out.println("table created!");
					}else{
						System.out.println("table doent not created!");
					}
					
					System.out.println("result is++++++++++++" + rs);
			    	
				if(rs==0){
					return true;
				}	else{
					return false;
				}
				
				}
				  catch (SQLException e) {
					e.printStackTrace();
					}catch (Exception e2) {
						e2.printStackTrace();
					}finally{
						if(con!=null){
							try {
								con.close();
							} catch (Exception e3) {
								e3.printStackTrace();
							}//catch
						}//if
					}//finally
		
		return false;
	}
}  // class
