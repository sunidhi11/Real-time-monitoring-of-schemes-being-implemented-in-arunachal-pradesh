package sis.com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakerDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con ;
		ResultSet rs;
		try{
			con=SisDbUtil.getConnection();
			Statement s = con.createStatement();
			String sql="select * from mapdat_tb";
			rs=s.executeQuery(sql);
			String a,b,c;
			while(rs.next()){
				a=request.getParameter("placename");
				b=request.getParameter("lati");
				c=request.getParameter("longi");
				/*{
					   "placeName": a,
					   "lati": "JAVA",
					   "price": 500,
					}*/
 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
