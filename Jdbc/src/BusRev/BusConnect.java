package BusRev;

import java.sql.*;

public class BusConnect {
	private static final String url = "jdbc:mysql://localhost:3306/demo";
	private static final String userName = "root";
	private static final String passWord = "pubg@123";
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, userName, passWord);
	}
}
