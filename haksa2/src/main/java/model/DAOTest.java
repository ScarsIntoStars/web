package model;

import java.util.ArrayList;

public class DAOTest {

	public static void main(String[] args) {
//		CouDAO dao = new CouDAO();
//		System.out.println("새로운 코드:" + dao.toString());
		StuDAO dao=new StuDAO();
		ArrayList<EnrollVO> array= dao.list("92514023");
		for(EnrollVO vo :array) {
			System.out.println(vo.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
		
//	}
//		ProDAO dao=new ProDAO();
//		ProVO vo=new ProVO();
//		vo.setPname("이몽룡");
//		vo.setDept("전자");
//		vo.setTitle("조교수");
//		vo.setHiredate("2023-08-02");
//		dao.insert(vo);
//		System.out.println("입력완료");
	}

}