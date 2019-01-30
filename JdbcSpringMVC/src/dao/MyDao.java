package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.EmpBean;

public class MyDao {
	//my sql connection code
		public Connection start()
		{
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcspringdb","root","root");
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return con;
		}
		
		
		//admin login check by passing parameter uid and pwd
		public int loginCheck(String uid,String pwd)
		{
			int x=0;
			
			try {
				Connection con=start();
				PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
				ps.setString(1, uid);
				ps.setString(2, pwd);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
					x=1;
				con.close();
				}catch(  SQLException e)
			{
					System.out.println(e);
			}
			
			return x;
		}
		public int insertCustomer(EmpBean e)
		{ 
			int x=0;
			
			try {
				
				Connection con=start();
				PreparedStatement ps1=con.prepareStatement("insert into employee (ename,salary,address)values(?,?,?)");
			    
			    ps1.setString(1,e.getEname());
			    ps1.setDouble(2, e.getSalary());
			    ps1.setString(3,e.getAddress());
			   			    
			    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
			    con.close();
			    }catch(Exception w)
			{
			    	System.out.println(w);
			}
			
		return x;
			
		}

}
