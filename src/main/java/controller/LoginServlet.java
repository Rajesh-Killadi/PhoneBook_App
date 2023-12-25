package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dto.ContactDto;
import Dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import phoneBookDao.PhoneBookDao;
import userDao.UserDao;

/**
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		
		try {
			
			 UserDto uObj = UserDao.userLogin(email, password);
		   
			
			if (uObj != null) {
				
				request.setAttribute("user_name", uObj.getUser_name());
				request.setAttribute("user_id", uObj.getUser_id());
				List<ContactDto> list = PhoneBookDao.getContacts(uObj.getUser_id());
				request.setAttribute("result", list);
				request.getRequestDispatcher("dashboard.jsp").forward(request ,response);
				
			}
			else {
				request.setAttribute("result","Invalid Credentials");
				request.getRequestDispatcher("index.jsp").forward(request ,response);

			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
