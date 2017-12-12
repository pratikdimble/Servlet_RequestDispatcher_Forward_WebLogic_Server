package com.pratik.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionFactory {
	private static Connection con=null;
	static {
	//get the connection
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
		}catch (Exception e) {
			e.printStackTrace();
		}//try with catch close
	}//static
	public static Connection getConnection() {
		return con;		//return the connection
		}
}//class close
