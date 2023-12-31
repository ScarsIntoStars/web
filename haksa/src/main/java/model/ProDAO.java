package model;
import java.util.*;
import java.sql.*;

public class ProDAO {
	
	// 교수정보수정
	public void update(ProVO vo) {
	try {
		int ncode=0;
		String sql ="UPDATE PROFESSORS SET PNAME=?, DEPT=?, TITLE=?, SALARY=?, HIREDATE=?";
				sql += " WHERE PCODE=?";
		PreparedStatement ps = Database.CON.prepareStatement(sql);
		ps.setString(1, vo.getPname());
		ps.setString(2, vo.getDept());
		ps.setString(3, vo.getTitle());
		ps.setInt(4, vo.getSalary());
		ps.setString(5, vo.getHiredate());
		ps.setString(6, vo.getPcode());
		ps.execute();
				
	} catch (Exception e) {
		System.out.println("교수등록 오류 : " + e.toString());
	}
}
	
	
	// 교수정보읽기
	public ProVO read(String pcode) {
		ProVO vo=new ProVO();
		try {
			String 	sql="SELECT * FROM professors";
					sql+=" WHERE PCODE=?";
					
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				vo.setPcode(rs.getString("PCODE"));
				vo.setPname(rs.getString("PNAME"));
				vo.setDept(rs.getString("DEPT"));
				vo.setHiredate(rs.getString("HIREDATE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSalary(rs.getInt("SALARY"));	
			}
		} catch (Exception e) {
			System.out.println("교수정보 오류 : " + e.toString() );
		}
		return vo;
	}
	
	
	// 교수등록
	public void insert(ProVO vo) {
		try {
			int ncode=0;
			String sql ="SELECT MAX(PCODE)+1 NCODE FROM professors";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ncode=rs.getInt("ncode");
			}
			sql="INSERT INTO professors(PCODE,PNAME,DEPT,TITLE,SALARY,HIREDATE)";
			sql+=" VALUES(?,?,?,?,?,?)";
			ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, ncode);
			ps.setString(2, vo.getPname());
			ps.setString(3, vo.getDept());
			ps.setString(4, vo.getTitle());
			ps.setInt(5, vo.getSalary());
			ps.setString(6, vo.getHiredate());
			ps.execute();
					
		} catch (Exception e) {
			System.out.println("교수등록 오류 : " + e.toString());
		}
		
	}
	
	
	// 교수 수
	public int total(String query, String key) {
		int total=0;
		try {
			String 	sql="SELECT COUNT(*) CNT FROM professors WHERE " + key + " LIKE ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				total=rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("교수님 명수 오류 : " + e.toString() );
		}
		
		return total;
	}
	
	
	// 교수목록
	public ArrayList<ProVO> list(int page, String query, String key){
		ArrayList<ProVO> array = new ArrayList<ProVO>();
		try {
			String 	sql="SELECT * FROM professors";
					sql+=" WHERE " + key + " LIKE ?";
					sql+=" LIMIT ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProVO vo=new ProVO();
				vo.setPcode(rs.getString("PCODE"));
				vo.setPname(rs.getString("PNAME"));
				vo.setDept(rs.getString("DEPT"));
				vo.setHiredate(rs.getString("HIREDATE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSalary(rs.getInt("SALARY"));
				array.add(vo);
				
			}
		} catch (Exception e) {
			System.out.println("교수님 리스트 오류 : " + e.toString() );
		}
		
		return array;
	}
	
	// 모든 교수목록
	public ArrayList<ProVO> all(){
		ArrayList<ProVO> array = new ArrayList<ProVO>();
		try {
			String 	sql="SELECT * FROM professors ORDER BY PNAME";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProVO vo=new ProVO();
				vo.setPcode(rs.getString("PCODE"));
				vo.setPname(rs.getString("PNAME"));
				vo.setDept(rs.getString("DEPT"));
				vo.setHiredate(rs.getString("HIREDATE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSalary(rs.getInt("SALARY"));
				array.add(vo);
				
			}
		} catch (Exception e) {
			System.out.println("모든 교수목록 : " + e.toString() );
		}
		return array;
	}
}
