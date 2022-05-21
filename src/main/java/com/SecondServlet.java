package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dto.User;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SecondServlet() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NumberFormatException {

		User u = new User();
		HttpSession session=request.getSession(false);
		if(session != null) {
	      	u =(User)session.getAttribute("user");
		    u.setEmail(request.getParameter("email"));
		    u.setAge(Integer.parseInt(request.getParameter("age")));
		    session.setAttribute("user",u);
		    response.sendRedirect("third.html");
		}
		
	}


}
