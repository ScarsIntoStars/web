package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

public class UserDAO {
	
	// 회원목록
	public ArrayList<UserVO> list(String key, String query, int page){
		ArrayList<UserVO> array=new ArrayList<UserVO>();
		
		try {
			String sql="SELECT * FROM USERS WHERE " +key+ " LIKE ? ORDER BY REGDATE DESC LIMIT ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				UserVO vo=new UserVO();
				vo.setUid(rs.getString("uid"));
				vo.setUpass(rs.getString("upass"));
				vo.setUname(rs.getString("uname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
				vo.setRegDate(rs.getTimestamp("regDate"));
				vo.setPhoto(rs.getString("photo"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("유저정보읽기 오류 " + e.toString());
		}
		return array;
	}
	
	// 회원수정
	public void update(UserVO vo) {
		
		try {
			String sql = "UPDATE USERS SET UNAME=?, PHONE=?, ADDRESS1=?, ADDRESS2=?, PHOTO=? WHERE UID=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getUname());
			ps.setString(2, vo.getPhone());
			ps.setString(3, vo.getAddress1());
			ps.setString(4, vo.getAddress2());
			ps.setString(5, vo.getPhoto());
			ps.setString(6, vo.getUid());
			ps.execute();
		} catch (Exception e) {
			System.out.println("회원수정 : " + e.toString());
		}
		
		
	}
	
	//회원등록
	public void insert(UserVO vo) {
		try {
			String sql = "INSERT INTO USERS(UID,UPASS,UNAME,PHONE,ADDRESS1,ADDRESS2,PHOTO) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpass());
			ps.setString(3, vo.getUname());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getAddress1());
			ps.setString(6, vo.getAddress2());
			ps.setString(7, vo.getPhoto());
			ps.execute();
		} catch (Exception e) {
			System.out.println("회원등록 : " + e.toString());
		}
		
	}
	
	//회원정보 읽기
	public UserVO read(String uid) {
		UserVO vo=new UserVO();
		try {
			String sql="SELECT * FROM USERS WHERE UID=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs= ps.executeQuery();
			if(rs.next()){
				vo.setUid(rs.getString("uid"));
				vo.setUpass(rs.getString("upass"));
				vo.setUname(rs.getString("uname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
				vo.setRegDate(rs.getTimestamp("regDate"));
				vo.setPhoto(rs.getString("photo"));
			}
		} catch (Exception e) {
			System.out.println("유저정보읽기 오류 " + e.toString());
		}
		
		return vo;
	}
}