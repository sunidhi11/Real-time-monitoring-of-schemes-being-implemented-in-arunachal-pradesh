package sis.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sis.com.dao.query;
import sis.com.bo.query1;
import sis.com.util.SisDbUtil;

public class queryImpl implements query{
	public int insert(query1 q){
		
		PreparedStatement pstmt=null;
		Connection con =null;
		try {
			con=SisDbUtil.getConnection();
			String sql="insert into query(firstName,lastName,email,contact,subject,"
					+ "query)values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, q.getFirstName());
		//	System.out.println(beneficiary.getId());
			pstmt.setString(2,q.getLastName());
			pstmt.setString(3, q.getEmail());
			pstmt.setInt(4,q.getContact());
			pstmt.setString(5, q.getSubject()); 
			pstmt.setString(6,q.getQuery());
								
			int result =pstmt.executeUpdate();			
			if(result==1) {
				System.out.println("appeal to database");
			}
			else {
				System.out.println("appeal not added to database");
				}//else
			
		}catch(SQLException e) {
			System.out.println("error in SQLException inside add()");
			e.printStackTrace();
		}finally {
			try {
				SisDbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	
		return 0;
	}
}
