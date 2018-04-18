package com.process.sql;
import java.sql.*;

public class COMMON_CONN {
	
	public static Connection getConnection() throws SQLException {	      
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/gangwon_bigdata_test?characterEncoding=UTF-8";
        String user = "certified";
        String password = "certified";
              
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        }      
        return DriverManager.getConnection(url, user, password);      
    }
	
}