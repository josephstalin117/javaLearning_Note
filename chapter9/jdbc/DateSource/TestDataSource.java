package DateSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestDataSource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		read("1");
	}

	/**
	 * @param id
	 *            读取数据 不易被sql注入
	 */
	static void read(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject("username"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);

		}
	}
}
