package Dto;

public class UserDto {
   
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private long user_phno;
	
	
//	public UserDto(int user_id, String user_name, String user_email, String user_password, long user_phno) {
//		super();
//		this.user_id = user_id;
//		this.user_name = user_name;
//		this.user_email = user_email;
//		this.user_password = user_password;
//		this.user_phno = user_phno;
//	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public long getUser_phno() {
		return user_phno;
	}


	public void setUser_phno(long user_phno) {
		this.user_phno = user_phno;
	}
	
	
	
	
}
