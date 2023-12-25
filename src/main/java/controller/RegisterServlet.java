package controller;

import java.io.IOException;
import java.sql.SQLException;

import Dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDao.UserDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		UserDto userObj = new UserDto();
		userObj.setUser_name(request.getParameter("user_name")) ;
		userObj.setUser_email(request.getParameter("user_email"));;
		userObj.setUser_password(request.getParameter("user_password"));;
		userObj.setUser_phno(Long.parseLong(request.getParameter("user_phno")));;
		
		try {
			
			boolean result = UserDao.insertUsers(userObj);
			
			if (result) 
				request.setAttribute("result", "Registration Sucessful");
			
			else 
				request.setAttribute("result", "Regestration failed");
			
			
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	
	
	
	
	
	
	}

}
