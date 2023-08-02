
package model;
import java.util.*;
import java.sql.*;


public class ProductDAO {
	
	// 상품수정
	public void update(ProductVO vo) {
		try {
			String sql = "UPDATE PRODUCTS SET NAME=?, PRICE=? WHERE CODE=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setInt(3, vo.getCode());
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품수정 오류 : " + e.toString());
		}
	}
	
	
	// 상품삭제
	public void delete(int code) {
		try {
			String sql = "DELETE FROM PRODUCTS WHERE CODE=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setInt(1, code);
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품삭제 오류 : " + e.toString());
		}
	}
	
	// 상품등록
	public void insert(ProductVO vo) {
		try {
			String sql = "INSERT INTO PRODUCTS(NAME, PRICE) VALUES(?, ?)";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품등록 오류 : " + e.toString());
		}
	}
	
	// 상품수 출력
	public int total(String query) {
		int total=0;
		try {
			String sql = "SELECT COUNT(*) CNT FROM PRODUCTS WHERE NAME LIKE ?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total=rs.getInt("CNT");
			}
			
		} catch (Exception e) {
			System.out.println("상품 수 출력 오류 " +e.toString());
		}
		
		return total;
	}
	
	// 상품목록
	public ArrayList<ProductVO> list(int page, String query) {
		ArrayList<ProductVO> array=new ArrayList<ProductVO>();
		try {
			String sql = "SELECT * FROM PRODUCTS WHERE NAME LIKE ? ORDER BY CODE DESC LIMIT ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ps.setInt(2, (page-1)*5);
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
			System.out.println("상품목록오류 " +e.toString());
		}
		return array;
	}
	
}
