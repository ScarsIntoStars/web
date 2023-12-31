package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StuDAO {
	
	// 학생수정
	public void update(StuVO vo) {
	try {
		
		String sql = "UPDATE STUDENTS SET SNAME=?, DEPT=?, YEAR=?, BIRTHDAY=?, ADVISOR=? WHERE SCODE=?";
		PreparedStatement ps=Database.CON.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		ps.setString(1, vo.getSname());
		ps.setString(2, vo.getDept());
		ps.setInt(3, vo.getYear());
		ps.setString(4, vo.getBirthday());
		ps.setString(5, vo.getAdvisor());
		ps.setString(6, vo.getScode());
		ps.execute();
	
	} catch (Exception e) {
		System.out.println("학생수정 오류 : " + e.toString());
	}
	
	
}
	
	// 학생정보
	public StuVO read(String scode) {
		StuVO vo= new StuVO();
		try {
			String sql= "select * from VIEW_STU WHERE scode=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setYear(rs.getInt("year"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setAdvisor(rs.getString("advisor"));
				vo.setPname(rs.getString("pname"));
			}
		}catch(Exception e) {
			System.out.println("학생정보 : " + e.toString());
		}
		return vo;
	}
	
	
	// 학생등록
	public void insert(StuVO vo) {
		try {
			String ncode="";
			String sql = "SELECT MAX(SCODE)+1 NCODE FROM STUDENTS";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) ncode=rs.getString("ncode");
			sql="INSERT INTO STUDENTS(SCODE, SNAME, DEPT, YEAR, BIRTHDAY, ADVISOR) VALUES(?,?,?,?,?,?)";
			ps=Database.CON.prepareStatement(sql);
			ps.setString(1, ncode);
			ps.setString(2, vo.getSname());
			ps.setString(3, vo.getDept());
			ps.setInt(4, vo.getYear());
			ps.setString(5, vo.getBirthday());
			ps.setString(6, vo.getAdvisor());
			ps.execute();
		
		} catch (Exception e) {
			System.out.println("학생등록 오류 : " + e.toString());
		}
		
		
	}
	
	//학생검색수
	public int total(String query, String key) {
		int total=0;
		try {
			String  sql= " select count(*) cnt from view_stu ";
					sql+=" where " + key + " like ?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				total=rs.getInt("cnt");
			}
		}catch(Exception e) {
			System.out.println("학생검색수:" + e.toString());
		}
		return total;
	}
	
	//학생목록
	public ArrayList<StuVO> list(int page, String query, String key){
		ArrayList<StuVO> array=new ArrayList<StuVO>();
		try {
			String  sql= " select * from view_stu ";
					sql+=" where " + key + " like ?";
					sql+=" limit ?,5";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StuVO vo=new StuVO();
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setYear(rs.getInt("year"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setAdvisor(rs.getString("advisor"));
				vo.setPname(rs.getString("pname"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("학생목록:" + e.toString());
		}
		return array;
	}
}