package Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author josephstalin 存储过程
 * 
 */
public class Procedure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		read();
	}

	/**
	 * 调用存储过程
	 */
	static void read() {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			con = Jdbc.getCon();
			cs = con.prepareCall("{Call NewPerson(?,?,?,?)}");
			cs.setString(1, "1000");
			cs.setString(2, "9000");
			cs.setString(3, "9000");
			cs.registerOutParameter(4, Types.INTEGER);

			cs.executeUpdate();
			System.out.println(cs.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, cs, con);

		}
	}

}
