package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.ProductDAO;
import model.ProductVO;


@WebServlet(value={"/pro/list", "/pro/list.json", "/pro/total", "/pro/insert", "/pro/delete", "/pro/update"})
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao=new ProductDAO();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DecimalFormat df= new DecimalFormat("#,###");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		switch(request.getServletPath()) {
		case "/pro/total":
			String query1=request.getParameter("query");
			out.print(dao.total(query1));
			break;
		
		
		case "/pro/list":
			request.setAttribute("pageName", "/pro/list.jsp");
			dis.forward(request, response);
			break;
			
		case "/pro/list.json": 
			int page=Integer.parseInt(request.getParameter("page"));
			String query=request.getParameter("query");
			//pro/list.json?page=1&query=냉장고 ;;;; 테스트 할 때는 이렇게
			
			
			ArrayList<ProductVO> array=dao.list(page, query);
			JSONArray jArray=new JSONArray();
			//array에 있는 것을 읽어서 jarray에 넣음
			// 자바 오브젝트를 제이손 오브젝트로
			for(ProductVO vo:array) {
				JSONObject obj=new JSONObject();
				obj.put("code", vo.getCode());
				obj.put("name", vo.getName());
				obj.put("price", vo.getPrice());
				obj.put("fprice", df.format(vo.getPrice()));
				// rdate를 object로 만들면 오류가 나서 fdate로 만듦
				obj.put("fdate", sdf.format(vo.getRdate()));
				jArray.add(obj);
				
			}
			out.print(jArray);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		
		case  "/pro/delete":
			int code=Integer.parseInt(request.getParameter("code"));
			System.out.println("삭제할 코드 : " + code);
			dao.delete(code);
			break;
		case "/pro/insert":
			ProductVO vo=new ProductVO();
			vo.setName(request.getParameter("name"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			System.out.println(vo.toString());
			dao.insert(vo);
			break;
		case "/pro/update":
			vo=new ProductVO();
			vo.setCode(Integer.parseInt(request.getParameter("code")));
			vo.setName(request.getParameter("name"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			System.out.println(vo.toString());
			dao.update(vo);
			break;
		}
	}

}
