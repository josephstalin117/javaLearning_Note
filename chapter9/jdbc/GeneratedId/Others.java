package GeneratedId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Others {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getGeneratedId("hehe~");
	}

	/**
	 * 插入新数据同时返回主键
	 * @param username
	 * @return
	 */
	static int getGeneratedId(String username) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into username(username) values(?)";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, username);

			int i = ps.executeUpdate();
			System.out.println(i + "rows effect");

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				i=rs.getInt(1);
				System.out.println("generated id=: "+i);
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return -1;
	}
}
