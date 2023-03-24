package common;

import java.sql.Statement;

import javax.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		try {
			//드라이브 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DB연결
			String url = "jdbc:mysql://localhost:3306/musthave";
			//String url = "jdbc:mysql://localhost:3306/world";
			String id = "musthave";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public JDBConnect (String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB연결성공(인수 생성자 1)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JDBConnect(ServletContext application) {
		try {
			
			// JDBC 드라이브 로드
			String driver = application.getInitParameter("MysqlDriver");
			Class.forName(driver);
			
			//DB 연결
			String url = application.getInitParameter("MysqlURL");
			String id = application.getInitParameter("MysqlId");
			String pwd = application.getInitParameter("MysqlPwd");
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자 2)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JDBConnect jdbConnect = new JDBConnect();
	}
	
	

	public void close() {
		try {
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			
			System.out.println("JDBC 자원해제");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
