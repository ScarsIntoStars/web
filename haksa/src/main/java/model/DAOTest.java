package model;
import java.util.*;
import java.sql.*;

public class DAOTest {

	public static void main(String[] args) {		
//		ProDAO dao=new ProDAO();
//		System.out.println(dao.read("221").toString());
		
		StuDAO dao=new StuDAO();
		System.out.println(dao.read("92414033"));
		
		
//		ProDAO dao=new ProDAO();
//		ProVO vo=new ProVO();
//		vo.setPname("이몽룡");
//		vo.setDept("전자");
//		vo.setTitle("조교수");
//		vo.setHiredate("2023-08-02");
//		dao.insert(vo);
//		System.out.println("입력완료");
		
//		CouDAO dao = new CouDAO();
//		ArrayList<CourseVO> array = dao.list(1, "pname", "이");
//		for(CourseVO vo:array) {
//			System.out.println(vo.toString());
//		}
//	
//		}
	
		
		
		
//		StuDAO dao=new StuDAO();
//		ArrayList<StuVO> array=dao.list(1, "4", "year");
//		for(StuVO vo:array) {
//			System.out.println(vo.toString());
//		}
//		System.out.println("검색 수 : " + dao.total("4", "year"));
		
		
		
//		System.out.println("검색 수 : " + dao.total(""));
		
		
//		ArrayList<ProVO> array=dao.list(1, "", "pname");
//		for(ProVO vo:array) {
//			System.out.println(vo.toString());
//		}

	}
}


