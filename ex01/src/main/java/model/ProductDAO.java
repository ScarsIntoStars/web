package model;
import java.util.*;
import java.sql.*;

public class ProductDAO {
	// 목록출력 매서드
	public List<ProductVO> list(){
		List<ProductVO> array=new ArrayList<>();
		try {
			String sql="SELECT * FROM PRODUCTS ORDER BY CODE DESC";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setRdate(rs.getTimestamp("rdate"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("상품목록 오류 : " + e.toString());
		}
		
		return array;
	}
}
