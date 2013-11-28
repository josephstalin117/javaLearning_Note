package testJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testRead {
	// public static void main(String arg[]) {
	// List<String> testList = new ArrayList<String>();
	// testList=heheRead();
	// System.out.println(heheRead());
	// System.out.println(testList);
	// System.out.print(readName());
	//
	// }

	public static List readName() {
		return heheRead("SELECT username FROM hehe_user");
	}

	public static String testWrite() {
		String t = null;
		// 建立数组
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,username,birthday FROM hehe_user";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				t = username;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return t;
	}

	/**
	 * 读取数据
	 */
	public static ArrayList heheRead(String sql) {
		String t = null;
		// 建立数组
		ArrayList<String> l = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				t = username;
				l.add(username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return l;
	}
}
