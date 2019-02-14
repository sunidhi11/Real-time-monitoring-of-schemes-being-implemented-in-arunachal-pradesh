package sis.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/*import sis.com.bo.SchemesBo;*/
import sis.com.dao.AdminAddScheme;
/*import sis.com.util.SomenDbUtil;*/
import sis.com.util.SisDbUtil;

public class AdminAddSchemeImp implements AdminAddScheme{
	/*@Override
	public boolean add(String name, int id, String domain) {
		int result = 0;
		try{
			Connection con = SomenDbUtil.getConnection();
			String sql = "insert into schemes (id,name,domain) values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, domain);
			
			
			result = pstmt.executeUpdate();
			
			
			System.out.println(result + " rows affected");
			
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		if(result!=0){
			return true;
		}
		return false;
	
	}//add

	@Override
	public ArrayList<SchemesBo> check() {
		
		SchemesBo schemesBo = null;
		
		ArrayList<SchemesBo> schemes = new ArrayList<SchemesBo>();
		
		try{
			Connection con = SomenDbUtil.getConnection();
			String sql = "select * from schemes";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				schemesBo = new SchemesBo();
				//schemes.add(rs.getString(2));
				schemesBo.setId(rs.getInt("id"));
				schemesBo.setName(rs.getString("name"));
				schemesBo.setDomain(rs.getString("domain"));
				schemes.add(schemesBo);
			}
			return schemes;
			}catch(SQLException e){
				e.printStackTrace();
				return schemes;
			}

	}

	@Override
	public HashMap<Integer, String> show() {
HashMap<Integer,String> hashMap = new HashMap<>(); 
		
		try{
			Connection con = SomenDbUtil.getConnection();
			String sql = "select * from schemes";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				hashMap.put(rs.getInt("int"), rs.getString("name"));
			}
			return hashMap;
			}catch(SQLException e){
				e.printStackTrace();
				return hashMap;
			}
	}

	@Override
	public boolean delete(int id) {
		int result = 0;
		try{
			Connection con = SomenDbUtil.getConnection();
			String sql = "delete from schemes where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		
		}
		

		if(result!=0){
			System.out.println(result + " rows affected.");
		return true;
		}else{
			return false;
		}
		
	}

	@Override
	public ArrayList<SchemesBo> search(String domain) {
		
		SchemesBo schemesBo = null;
		
		ArrayList<SchemesBo> schemes = new ArrayList<SchemesBo>();
		System.out.println(domain);
		try{
			Connection con = SomenDbUtil.getConnection();
			String sql = "select * from schemes where domain='"+domain+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				schemesBo = new SchemesBo();
				//schemes.add(rs.getString(2));
				schemesBo.setId(rs.getInt("id"));
				schemesBo.setName(rs.getString("name"));
				schemesBo.setDomain(rs.getString("domain"));
				schemes.add(schemesBo);
			}
			return schemes;
			}catch(SQLException e){
				e.printStackTrace();
				return schemes;
			}
*/
/*
	
	}*/


//sunidhi===========================
	
	public boolean validateAdminLogin(String userName, String password) {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		ResultSet result=null;
		int value=0;
		try {
			System.out.println("username in dao"+userName);
			con=SisDbUtil.getConnection();
			String sql ="select * from admin_login where userName='"+userName+"' and password='"+password+"' ";
			pstmt = con.prepareStatement(sql);
			result= pstmt.executeQuery();
			if(result.next()){
				value=1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(value==1){
			return true;
		}
		else{
			return false;
		}
	}  //func

}//class
