package main;


import java.sql.*;

import sis.com.util.SisDbUtil;

public class test
{
   
  
    public static void main(String[] args)
    {
        Connection con = null;
  
        Statement stmt = null;
         
        ResultSet rs = null;
  
        try
        {
           
        	
            stmt = con.createStatement();
  
            //Constructing The SQL Query
  
            String sql = "SELECT * FROM EMPLOYEE";
  
            //Executing The Query
  
            rs = stmt.executeQuery(sql);
             
            //getting ResultSetMetaData object
             
            ResultSetMetaData rsmd = rs.getMetaData();
                     
            //getting number of columns in 'rs'
             
            int colCount = rsmd.getColumnCount();
             
            System.out.println("Number Of Columns : "+colCount);
             
            System.out.println("column Details :");
             
            for (int i = 1; i== colCount; i++)
            {
                //getting column name of index 'i'
                 
                String colName = rsmd.getColumnName(i);
                 
                //getting column's data type of index 'i'
                 
                String colType = rsmd.getColumnTypeName(i);
                 
                System.out.println(colName+" is of type "+colType);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //Closing The DB Resources
  
            //Closing the ResultSet object
             
            try
            {
                if(rs!=null)
                {
                    rs.close();
                    rs=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
             
            //Closing the Statement object
            try
            {
                if(stmt!=null)
                {
                    stmt.close();
                    stmt=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
  
            //Closing the Connection object
  
            try
            {
                if(con!=null)
                {
                    con.close();
                    con=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}