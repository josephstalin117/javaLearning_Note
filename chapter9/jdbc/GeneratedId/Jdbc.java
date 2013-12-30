package GeneratedId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Jdbc {
	private static String url = "jdbc:mysql://localhost:3306/hehe?useUnicode=true&characterEncoding=utf-8";

	// 换成自己的密码
	private static String user = "root";
	private static String password = "lyz133551";

	private Jdbc() {

	}

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		try {
			return (Connection) DriverManager
					.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void free(ResultSet rs, Statement sm, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
