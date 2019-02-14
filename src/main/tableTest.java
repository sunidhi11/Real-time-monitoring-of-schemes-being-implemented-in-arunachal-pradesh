package main;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sis.com.util.SisDbUtil;

public class tableTest {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		ArrayList<String> list1= new ArrayList<String>();
		ArrayList<String> list2= new ArrayList<String>();
		list1.add("name");
		list1.add("age");
		list1.add("address");
		list2.add("varchar");
		list2.add("varchar");
		list2.add("varchar");
		

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded");

		String url = "jdbc:mysql://localhost:3306/sih";
		String user = "root";
		String pass = "root";

		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt = null;
		int rs = 0;
		int i=0;

		
		String s = "sih111";
		String sql = "CREATE TABLE IF NOT EXISTS sih."+s+"(applicantID INT NOT NULL AUTO_INCREMENT,";
				for(String value1:list1){
					sql=sql+""+value1;
					sql=sql+" "+list2.get(i)+"(45),";
					i++;
				}
				sql=sql+"PRIMARY KEY (applicantID))";
				sql=sql+ "ENGINE=InnoDB DEFAULT CHARSET=utf8";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeUpdate();
		System.out.println(sql);
		
		
		DatabaseMetaData dbm = con.getMetaData();
		ResultSet r  = dbm.getTables(null, null, s, null);
		if(r.next()){
			System.out.println("table created!");
		}else{
			System.out.println("table doent not created!");
		}
		
		System.out.println("result is++++++++++++" + rs);

	}  //main

}   //class
