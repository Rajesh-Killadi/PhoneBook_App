package userDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.UserDto;
import connectionPool.ConnectionPooling;

public class UserDao {
	
	public static boolean insertUsers(UserDto o) throws SQLException, ClassNotFoundException, IOException {
		
		boolean insert = false;
		String query ="insert into user(user_name,email,phno,password) values(?,?,?,?)";
		try(Connection conObj = ConnectionPooling.getPool();) {
			
			PreparedStatement pObj = conObj.prepareStatement(query);
			pObj.setString(1, o.getUser_name());
			pObj.setString(2,o.getUser_email());
			pObj.setLong(3, o.getUser_phno());
			pObj.setString(4, o.getUser_password());
			
			
			int result = pObj.executeUpdate();
			
			if (result >= 1) 
				insert = true;
			
			
	 		return insert;
	   	}
		
	 }
	
	
	
	public static UserDto userLogin(String email , String password) throws SQLException, ClassNotFoundException, IOException {
		
		String query ="select user_id,user_name from user where email = ? and password = ?";
		
		
		
		
		try(Connection conObj = ConnectionPooling.getPool();) {
			
			PreparedStatement pObj = conObj.prepareStatement(query);
			pObj.setString(1,email);
			pObj.setString(2, password);
			ResultSet rsObj = pObj.executeQuery();
		
			if (rsObj.next()) {
				UserDto uObj = new UserDto();
				uObj.setUser_id(rsObj.getInt("user_id")); ;
				uObj.setUser_name(rsObj.getString("user_name"));;
				return uObj;
			}
	   	}
		
		return null;
		
		
		
	}
	
	
	
	

}
