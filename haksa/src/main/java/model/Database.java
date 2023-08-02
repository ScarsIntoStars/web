package model;

import java.sql.*;


public class Database {
	public static Connection CON;
    static { // 스태틱의 값을 주려면, 스태틱 블록 안에서 줘야 됨
        try {
            Class.forName("com.mysql.jdbc.Driver");
            CON=DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/HAKSADB","HAKSA","PASS");
            System.out.println("접속성공");
        }catch(Exception e) { 
        	System.out.println("접속실패:" + e.toString());
        }
    }
}
