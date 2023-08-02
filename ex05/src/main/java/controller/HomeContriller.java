package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//wepapp가 /(루트) 임

@WebServlet("/")
public class HomeContriller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher dis=request.getRequestDispatcher("/home.jsp")	;
	request.setAttribute("pageName", "/about.jsp");
	dis.forward(request, response);
	}

}
