package model;
import java.sql.*;
import java.util.*;


public class ProductDAO {
	
	// 전체상품수
	public int proEa() {
		int proCount = 0;
		try {
			String sql = "SELECT COUNT(*) coco FROM PRODUCTS";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				proCount = rs.getInt("coco");
			}
		} catch (Exception e) {
			System.out.println("전체 상품 수 오류 : " + e.toString());
		}
		return proCount; 
	}
	
	// 상품수정
	public void update(ProductVO vo) {
		try {
			String sql = "UPDATE PRODUCTS SET NAME=?, PRICE=?, RDATE=NOW() WHERE CODE=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setInt(3, vo.getCode());
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품수정오류 : " + e.toString());
		}
	}
	
	
	// 상품삭제
	public void delete(String code) {
		try {
			String sql = "DELETE FROM PRODUCTS WHERE CODE=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, code);;
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품삭제오류 : " + e.toString());
		}
		
	}
	
	// 상품정보
	public ProductVO read(String code) {
		ProductVO vo = new ProductVO();
		try {
			String sql="SELECT * FROM PRODUCTS WHERE CODE=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(code));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				vo.setCode(rs.getInt("CODE"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getInt("PRICE"));
				vo.setRdate(rs.getTimestamp("rdate"));
			}
			
		} catch (Exception e) {
			System.out.println("상품정보오류 : " + e.toString());
		}
		return vo;
	}
	
	
	public void insert(ProductVO vo) {
		try {
			String sql = "INSERT INTO PRODUCTS (NAME, PRICE) VALUES(?, ?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.execute();
		} catch (Exception e) {
			System.out.println("상품등록오류 : " + e.toString());
		}
	}
	
	// 상품목록
	public List<ProductVO> list(int page){
		List<ProductVO> array = new ArrayList<>();
		try {
			String sql="SELECT * FROM PRODUCTS ORDER BY CODE DESC LIMIT ?, 5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, (page-1)*5);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setCode(rs.getInt("CODE"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getInt("PRICE"));
				vo.setRdate(rs.getTimestamp("rdate"));
				array.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("상품목록오류 : " + e.toString());
		}
		return array;
	}
	
}

