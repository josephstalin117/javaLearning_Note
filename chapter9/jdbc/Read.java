import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

//	public static void main(String[] args) {
//		// read("select * from hehe_user");//r
//		System.out.println("hehe~");
//		// write("UPDATE xs_kc set k_score=k_score+1");//u
//		// write("DELETE FROM kc WHERE k_id='102'");//D
//		// write("INSERT INTO hehe_user VALUES('122','潘哈哈','is')");
//		// c
//	}

	static void read(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			// sm = con.createStatement();
			// System.out.println(sql);
			ps = con.prepareStatement(sql);
			// ps.setString(1, "1");
			ps.setString(1, id);

			// rs = sm.executeQuery(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject("username"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Jdbc.free(rs, sm, con);
			Jdbc.free(rs, ps, con);

		}
	}

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
