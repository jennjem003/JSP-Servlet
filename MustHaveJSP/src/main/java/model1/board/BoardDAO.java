package model1.board;

import javax.servlet.ServletContext;
import common.JDBConnect;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BoardDAO extends JDBConnect {
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	public int selectCount(Map<String,Object>map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM board";
		if ( map.get("searchWord")!= null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<BoardDTO> selectList(Map<String, Object>map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		String query = "SELECT * FROM board";
		if(map == null && map.get("searchWord") != null) {
			query += "WHERE" + map.get("searchField") + " "
					+ "LIKE '%" + map.get("searchWord") + "%' ";
			}
					query += " ORDER BY num DESC ";
					try {
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						
						while(rs.next()) {
							BoardDTO dto = new BoardDTO();
							
							dto.setNum(rs.getString("num"));
							dto.setTitle(rs.getString("title"));
							dto.setContent(rs.getString("content"));
							dto.setPostdate(rs.getDate("postdate"));
							dto.setId(rs.getString("id"));
							dto.setVisitcount(rs.getString("visitcount"));
							
							bbs.add(dto);
						}
					}
					catch(Exception e) {
						System.out.println("게시물 조회 중 예외 발생");
						e.printStackTrace();
					}
		return bbs;
	}
	private int insertWrite(BoardDTO dto) {
		int result = 0;
		
		try {
			String query = "INSERT INTO board ( "
					+ " num,title,content,id,visitcount) "
					+ " VALUES ( "
					+ " seq_board_num.NEXTVAL, ?, ?, ?, 0";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}
