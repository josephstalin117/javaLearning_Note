package batch;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOther {
	public static void main(String[] args) {
		sqlBatch();
	}

	/**
	 * 批处理
	 */
	static void sqlBatch() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "insert into username(username) values(?)";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);

			for (int i = 0; i < 100; i++) {
//				ps.setString(1, "" + i);
				ps.setString(1, "name" + i);
//				ps.setDate(3, new Date(System.currentTimeMillis()));
				ps.addBatch();
			}
			int[] i = ps.executeBatch();

			System.out.println(i + "rows effect");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

	}
}
