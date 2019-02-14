package sis.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sis.com.bo.Benificary;
import sis.com.dao.BenificaryDao;
import sis.com.util.SisDbUtil;

public class BenificaryDaoImpl implements BenificaryDao {
public boolean  addRegisteredBenificiary(Benificary benificary){
		
		Connection con=null;
		 PreparedStatement pstmt=null;
		 PreparedStatement pstmt_getid=null;
		 PreparedStatement pstmt_doc=null;
		 int result1=0;
		 int result2=0;
		 int result=0;
		 ResultSet rs= null;
		try{
			con  = SisDbUtil.getConnection();
		
		
String sql="insert into Scheme_Applicant(District,Block,Panchayat,hospital,name,husband,address,gender,"
            +"mobile,dob,adhharNo,maritial,schemeCode)"
             +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

 pstmt=con.prepareStatement(sql);
 //===============student details==========================

 pstmt.setString(1,benificary.getDistrict());
 pstmt.setString(2,benificary.getBlock());
 pstmt.setString(3,benificary.getPanchayat());
 pstmt.setString(4,benificary.getHospital());
 pstmt.setString(5,benificary.getName());
 pstmt.setString(6,benificary.getHusband());
 pstmt.setString(7,benificary.getAddress());
 pstmt.setString(8,benificary.getGender());
 pstmt.setString(9,benificary.getMobile());
 pstmt.setDate(10,benificary.getDob());
 pstmt.setString(11,benificary.getAdhharNo());

 pstmt.setString(12,benificary.getMaritial());
 pstmt.setString(13,benificary.getSchemeCode());

 
	  result1=pstmt.executeUpdate();
	 System.out.println(" benificiary  table inserted"+result);
	 
	 //-----------------------------fetching id-----------------------------------
	 
	 String sql_getid= "select applicantID from Scheme_Applicant where applicantID = (select max(applicantID) from Scheme_Applicant)";
	 pstmt_getid=con.prepareStatement(sql_getid);
	 rs=pstmt_getid.executeQuery();
	 if(rs.next()){
		
	     benificary.setApplicationId(rs.getString(1));
	 }
	 
	 String sql_doc= "insert into Scheme_Applicant_Doc(applicantID,adhharProof,residentProof)"
				+"values(?,?,?)";
pstmt_doc= con.prepareStatement(sql_doc);

pstmt_doc.setString(1,benificary.getApplicationId());
pstmt_doc.setBinaryStream(2,benificary.getAdhharProof(),benificary.getAdhharProofSize());
pstmt_doc.setBinaryStream(3,benificary.getResidentProof(),benificary.getResidentProofSize());

System.out.println("");
result2=pstmt_doc.executeUpdate();
result=result1+result2;
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
		if(result==2){
			return true;
		}else
			return false;
		
	}  // end of class

public List<Benificary> ShowAllBenificiary() {
	List<Benificary> benificarylist = new ArrayList<Benificary>();
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con = SisDbUtil.getConnection();
		String sql="select * from Scheme_Applicant where selected=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,"yes");
		
		 rs=pstmt.executeQuery();
		 Benificary benificiary; 
		 while(rs.next()){
			 benificiary=new Benificary();
			 benificiary.setApplicationId(rs.getString("applicantID"));
			 System.out.println("");
			 benificiary.setName(rs.getString("name"));
			 benificarylist.add(benificiary);
		 }
	} catch (Exception e) {
     e.printStackTrace();
	}
	return benificarylist;
}   //method2

public Benificary ShowBenificiaryById(int applicantId){

	Benificary benificiary=new Benificary();
	Connection con=null;
	ResultSet rs=null;
	 PreparedStatement pstmt=null;
	 System.out.println("applicant id in impl"+applicantId);
	
	try{
		con  = SisDbUtil.getConnection();
		System.out.println("connection");
		String sql="select * from Scheme_Applicant where applicantID=?";
pstmt=con.prepareStatement(sql);
pstmt.setInt(1,applicantId);
	rs=pstmt.executeQuery();
	System.out.println("===============================");
	 if(rs.next()){
		 System.out.println("============================");
		/* benificiary.setApplicationId(rs.getString("applicantID"));
		 System.out.println("applicant id in impl by fetching"+benificiary.getApplicationId());*/
		 benificiary.setDistrict(rs.getString("District"));
		 System.out.println("district id in impl by fetching"+benificiary.getDistrict());
		 benificiary.setBlock(rs.getString("Block"));
		 benificiary.setSchemeCode(rs.getString("schemeCode"));
		 benificiary.setPanchayat(rs.getString("panchayat"));
		 benificiary.setHospital(rs.getString("hospital"));
		 benificiary.setName(rs.getString("name"));
		 benificiary.setHusband(rs.getString("husband"));
		 benificiary.setAddress(rs.getString("address"));
		 benificiary.setGender(rs.getString("gender"));
		 benificiary.setMobile(rs.getString("mobile"));
		 benificiary.setDob(rs.getDate("dob"));
		 benificiary.setAdhharNo(rs.getString("adhharNo"));
		 benificiary.setMaritial(rs.getString("maritial"));
		 
	 }
	}catch (Exception e) {
	     e.printStackTrace();
		}
	 
	return benificiary;
}

}
