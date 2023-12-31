package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LocalDAO;
import model.LocalVO;

@WebServlet(value={"/local/list", "/local/insert"})
public class LocalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocalDAO dao=new LocalDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageName", "/local/list.jsp");
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		dis.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/local/insert":
			LocalVO vo=new LocalVO();
			vo.setLid(req.getParameter("lid"));
			vo.setLname(req.getParameter("lname"));
			vo.setLaddress(req.getParameter("laddress"));
			vo.setLphone(req.getParameter("lphone"));
			vo.setLurl(req.getParameter("lurl"));
			vo.setX(req.getParameter("x"));
			vo.setY(req.getParameter("y"));
			
//			System.out.println(vo.toString());
			dao.insert(vo);
			break;
		}
	}

}
