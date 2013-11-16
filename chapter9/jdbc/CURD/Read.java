package CURD;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

	public static void main(String[] args) {
		 read("1");//r
		// write("UPDATE xs_kc set k_score=k_score+1");//u
		// write("DELETE FROM kc WHERE k_id='102'");//D
		// write("INSERT INTO hehe_user VALUES('122','潘哈哈','is')");//C
	}

	/**
	 * @param id
	 * 读取数据
	 * 不易被sql注入
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

	/**
	 * 写数据
	 * @param sql
	 * @return
	 */
	static int write(String sql) {
		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		int rows = 0;
		System.out.println(sql);

		try {
			con = Jdbc.getCon();
			sm = con.createStatement();
			System.out.println(sql);
			rows = sm.executeUpdate(sql);
			System.out.println(rows + "rows effect");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, sm, con);
		}
		return rows;

	}

}
