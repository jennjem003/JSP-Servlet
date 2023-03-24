package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class dbconTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db0220","root","1234");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("JDBC드라이버 로딩 오류");
			e.printStackTrace();
			return;
		} catch(SQLException e) {
			System.out.println("DB 연결 오류");
			e.printStackTrace();
			return;
		}
		
			while(true) {
				System.out.println("1.insert : ");
				System.out.println("2.delete : ");
				System.out.println("3.update : ");
				System.out.println("4.select : ");
				System.out.println("5.종료 ");
				//System.out.println("4.update : ");
				int key = scanner.nextInt();
				
				switch (key) {
				case 1: 
					try {
						System.out.println("책번호 : ");
						int id = scanner.nextInt();
						System.out.println("책이름 : ");
						String name = scanner.next();
						System.out.println("출판사 : ");
						String publisher = scanner.next();
						System.out.println("가격 : ");
						int cost = scanner.nextInt();
						
						psmt = conn.prepareStatement("insert into book values(?,?,?,?)");
						psmt.setInt(1, id);
						psmt.setString(1, name);
						psmt.setString(3, publisher);
						psmt.setInt(4, cost);
						
						//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db0220","root","1234");
						//psmt = conn.prepareStatement("select * from book");
						//psmt = conn.prepareStatement("insert into book value(15, '야구의 기술', '길벗', 10000)");
						//
						//rs = psmt.executeQuery(); //select는 쿼리
						//psmt.executeUpdate(); //insert,delete는 업데이트
						
						/*
						while(rs.next()) {
							String bookname = rs.getString("bookname");
							String publisher = rs.getString("publisher");
							System.out.println("도서명 : "+bookname + ", 출판사 : "+ publisher);
						}
						*/ //insert,delete 하게되면 while문은 필요가 없다.
					} catch (SQLException e) {
						System.out.println("중복 오류");
					}
					break;
				case 2:
					try {
						psmt = conn.prepareStatement("delete from book where id=15");
						psmt.executeQuery();
						
						}catch (SQLException e) {
							System.out.println("실행 오류");
						}
					 	break;
				
				case 3:
					try {
						//UPDATE 테이블명 SET 칼럼명 = '내용' WHERE 조건문
						psmt = conn.prepareStatement("update book set bookname = 이재화책, publisher = 한번미디어, price = 50000 where id = 18");
						psmt.executeQuery();
						
						}catch (SQLException e) {
							System.out.println("실행 오류");
						}
					 	break;
				case 4:
					try {
						psmt = conn.prepareStatement("select * from book");
						psmt.executeQuery();
						
						while(rs.next()) {
							String bookname = rs.getString("bookname");
							String publisher = rs.getString("publisher");
							System.out.println("bookname : "+ bookname + ", 출판사 : "+ publisher);
							} 
						}catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					 
				case 5: 
					System.out.println("끝 ~~~~");
					System.exit(0);
					try {
						conn.close();
						psmt.close();
						rs.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				default:
					System.out.println("종료");
				}
			}
	}
}

