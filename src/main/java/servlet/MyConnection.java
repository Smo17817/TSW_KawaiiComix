package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static String userName = "root";
    private static String password = "vittismo13";
    private static String dbURL = "jdbc:mysql://localhost:3306/KawaiiComix";
    private static Connection connection;
    
    public MyConnection() {
		try{
			connection = DriverManager.getConnection(dbURL, userName, password);
		}catch (SQLException e) {
			System.out.println("Connection to MySQL db failed");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
