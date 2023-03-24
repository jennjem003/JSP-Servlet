package edupnu;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JBDCClientMySQL {
	public static void main(String[] args) throws Exception {
		
		//MySQL 접속을 위한 JDBC 드라이버 로드
		// Class라는 클래스에서 static 매서드 호출, 라이브러리 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//MySQL database 연결 객체 생성
		//첫번째 파라미터 접속할 url(로컬 호스트에 ip주소 넣는거),유저,패스워드를 con에 넣어줌
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","musthave","tiger");
		
		//질의를 위한 객체 생성
		//
		Statement st = con.createStatement();
		
		//SQL 질의
		//쿼리 실행(밑에 있는거 돌려서 질의 날려 객체 실행 / rs가 ds를 가르침)
		ResultSet rs = st.executeQuery("select Name,Continent,Population,HeadOfState from country");
		
		//질의 결과 Parsing(-> 커서프로세싱 cursor processing)
		while(rs.next()) { //다음 결과 레코드로 이동. ds에서 rs로 이동. 안에서 호출될때마다 하나씩 하나씩.
			for(int i = 1; i <= 4; i++) {//인덱스 1부터 시작, 0 아님
				if(i != 1) System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		//생성된 객체 연결을 모두 해제. 내가 연건 내가 닫으렴
		rs.close();
		st.close();
		con.close();
	}

}
