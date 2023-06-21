package servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	private static String userName = "root";
    private static String password = "S&ttembre3*";
    private static String dbURL = "jdbc:mysql://localhost:3306/KawaiiComix?useSSL= false";
    
    public  static Connection getConnection() {
			
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(dbURL, userName, password);
				return conn;	
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			
		}
	}


