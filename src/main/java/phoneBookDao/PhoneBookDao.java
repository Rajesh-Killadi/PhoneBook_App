package phoneBookDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dto.ContactDto;
import Dto.UserDto;
import connectionPool.ConnectionPooling;

public class PhoneBookDao {

	public static boolean insertContact(ContactDto o ,int user_id) throws SQLException, ClassNotFoundException, IOException {
		
		String query = "insert into phone_book(contact_name,contact_email,phno,user_id) values(?,?,?,?)";
		boolean insert = false;
		try(Connection conObj = ConnectionPooling.getPool();) {
			
			PreparedStatement pObj = conObj.prepareStatement(query);
			pObj.setString(1,o.getContact_name());
			pObj.setString(2,o.getContact_email());
			pObj.setLong(3, o.getContact_phno());
			pObj.setLong(4, user_id);
			
			int result = pObj.executeUpdate();
			
			if (result >= 1) {
				insert = true;
			}
	   	}
		
		return insert;
		
		
		
		
	}
	
	
	public static List<ContactDto> getContacts(int user_id) throws SQLException, ClassNotFoundException, IOException{
		
		String query ="select contact_name,contact_email,phno from phone_book where user_id = ?";
		List<ContactDto> list = new ArrayList<>();
		
		try(Connection conObj = ConnectionPooling.getPool();) {
		     
			PreparedStatement pObj = conObj.prepareStatement(query);
			pObj.setInt(1,user_id);
			
			ResultSet rsObj = pObj.executeQuery();
			
			
		   while(rsObj.next()) {
			   
			   ContactDto cObj = new ContactDto();
			   
			   cObj.setContact_name(rsObj.getString("contact_name"));
			   cObj.setContact_email(rsObj.getString("contact_email"));
			   cObj.setContact_phno(rsObj.getLong("phno"));
			   
			   list.add(cObj);
		   }
		   
	   	}
		
		return list;
		
		
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
