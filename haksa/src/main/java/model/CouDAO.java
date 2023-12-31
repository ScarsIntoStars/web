package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CouDAO {
	
	
	// 검색 수
	
	public int total(String key, String query) {
		int total=0;
		
		try {
			String sql ="SELECT COUNT(*) CNT FROM VIEW_COU WHERE " + key + " like ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				total=rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("검색 수 오류 : " + e.toString() );
		}
		
		return total;
	}
	
	
	
	// 강좌목록
	public ArrayList<CourseVO> list(int page, String key, String query) {
		ArrayList<CourseVO> array = new ArrayList<CourseVO>();
		
		
		try {
			String sql ="SELECT * FROM VIEW_COU WHERE " + key + " like ? limit ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CourseVO vo=new CourseVO();
				vo.setLcode(rs.getString("lcode"));
				vo.setLname(rs.getString("lname"));
				vo.setHours(rs.getInt("hours"));
				vo.setRoom(rs.getString("room"));
				vo.setInstructor(rs.getString("instructor"));
				vo.setCapacity(rs.getInt("capacity"));
				vo.setPname(rs.getString("pname"));
				vo.setPersons(rs.getInt("persons"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("강좌목록 출력오류 : " + e.toString());
		}
		
		return array;
	}
}
