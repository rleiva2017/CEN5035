package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AbstractDao;

public class ScoreDAO extends AbstractDao{

	public ScoreDAO(Connection conn) {
		super(conn);
	}
	public void insert(final String name, final int score) throws Exception 
	{
		final String sql = "INSERT INTO Score (username, score) VALUES (?,?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.executeQuery();
		} catch (Exception e) {
			throw new RuntimeException(getClass().getName() + ".insert()", e);
		} finally {
			close(rs);
			close(pstmt);
		}
	}
	public String select(final String name, final String password) throws Exception 
	{
		String username = "Empty";
		final String sql = "SELECT username,password FROM Account WHERE username = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				username = rs.getString(1);

			}
		} catch (Exception e) {
			throw new RuntimeException(getClass().getName() + ".insert()", e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return username;
	}
	

}
