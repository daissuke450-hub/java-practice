package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String url;
	private static String password;
	private static String user;

	static {
		try (FileInputStream fis = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fis);

			url = props.getProperty("url");
			password = props.getProperty("password");
			user = props.getProperty("user");

		} catch (IOException e) {
			System.out.println("!!!!!!!!!!!!!!!!" + e.getMessage());
		}

	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}

}
