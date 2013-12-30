package DateSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Jdbc {
	private static DataSource ds = null;

	private Jdbc() {

	}

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			ds = new DataSource();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Connection getCon() {
		try {
			return ds.getCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	static void free(ResultSet rs, Statement sm, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sm != null) {
					sm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null) {
						// con.close();
						ds.free(con);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
