package util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {
	
	public static void main(String[] args) {
		try(Connection conn = DBUtil.getConnection()){
			System.out.println("ok");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
