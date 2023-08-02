package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//	어노테이션을 이용하여 URL Mapping을 설정한다.
//	"/"로 설정하면 웹 어플리케이션 루트(/)에 대한 요청을 처리하게 된다.
@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet() 메소드를 오버라이드하여 GET 방식 처리 로직을 작성한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 객체의 setAttribute() 메소드를 사용하여 request 객체에 속성을 추가한다.
		request.setAttribute("pageName", "/about.jsp");
		
		// request 객체의 getRequestDispatcher() 메소드를 사용하여 RequestDispatcher 객체를 얻은 후,
		// forward() 메소드를 이용하여 /home.jsp로 포워딩한다.
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		dis.forward(request, response);
	}

	
}