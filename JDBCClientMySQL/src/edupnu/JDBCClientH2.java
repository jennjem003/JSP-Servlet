package edupnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientH2 {

	//public int getColumnCount(ResultSet rs) throws Exception {
		//return rs.getMetaData().getColumnCount();
	//}//중복된 코드는 없애서 깔끔하게 만들자

	public int printColumnName(ResultSet rs) throws Exception {//필드명 찍어줄겡
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		
		StringBuilder sb = new StringBuilder("#");
		for (int i = 1 ; i <= count ; i++) {
			sb.append("," + meta.getColumnName(i));
		}
		System.out.println(sb);
		System.out.println("-".repeat(sb.length()));
		
		return count;
	}
//	
	public void StudyStatement1(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM BOARD");

		//printColumnName(rs); 깔끔하게
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	public void StudyStatement2(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from member");

		//printColumnName(rs); 깔끔하게
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
//prepare는 뒤에 어떤 파라메터가 들어가야할때 웨어(where)절에 조건이 들어가야할때
		
	public static void main(String[] args) throws Exception  { //메인

		JDBCClientH2 cli = new JDBCClientH2();//자기 클래스에서 매서드 사용 하기 위함(메서드는 객체를 만들어야 사용가능)

		Class.forName("org.h2.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/musthave", "sa", "");) {
			
			System.out.println("<=== StudyStatement ===>");
			cli.StudyStatement1(con);//매서드들 호출하는데 파라미터로 객체
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyStatement2(con);
		}		
	}
}
