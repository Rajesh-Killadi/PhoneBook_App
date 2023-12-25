package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dto.ContactDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import phoneBookDao.PhoneBookDao;

@WebServlet("/SaveContactServlet")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDto cObj = new ContactDto();
		
      
		cObj.setContact_name(request.getParameter("contact_name")) ;
		cObj.setContact_email(request.getParameter("contact_email"));;
		cObj.setContact_phno(Long.parseLong(request.getParameter("contact_phno")));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String user_name = request.getParameter("use_name");
		
		try {
			boolean contactInsert = PhoneBookDao.insertContact(cObj,user_id);
			if(contactInsert) {
				List<ContactDto> list = PhoneBookDao.getContacts(user_id);
				request.setAttribute("result", list);
				request.setAttribute("user_name",user_name);
				
			}
			else {
				request.setAttribute("contact", "Contact is not added");
			}
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);;
			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
