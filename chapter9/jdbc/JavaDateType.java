import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class JavaDateType {
	public static void main(String[] args) {
		read();

	}

	static Calendar cal = Calendar.getInstance();
	static BigDecimal salary;

	/**
	 * 
	 */
	static void read() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "4");

			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject("username"));
				int id = rs.getInt("id");
				String name = rs.getString("username");
				int sex = rs.getInt("sex");

				// 生日
				java.util.Date birthday = rs.getDate("birthday");
				cal.setTime(birthday);
				double score = rs.getDouble("score");
				// 薪水
				salary = rs.getBigDecimal("salary");
				BigDecimal wakaka = new BigDecimal("100.11");
				System.out.print(salary);
				salary = salary.add(wakaka);

				java.sql.Timestamp log = rs.getTimestamp("log");
				java.util.Date d = new java.util.Date(log.getTime());

				// 测试输出
				System.out.print(id + "\t");
				System.out.print(name + "\t");
				System.out.print(sex + "\t");
				System.out.print(birthday + "\t");
				System.out.print(score + "\t");
				System.out.print(salary + "\t");
				System.out.print(log);

				// 测试java时间戳
				// System.out.println(rs.getTimestamp("birthday"));
				// System.out.println(rs.getTime("birthday"));
				System.out.println(rs.getTime("log"));
				System.out.println(rs.getDate("log"));
				System.out.println(d);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Jdbc.free(rs, sm, con);
			Jdbc.free(rs, ps, con);

		}

		cal.add(Calendar.DATE, 1);

		int rows = 0;
		sql = "UPDATE hehe_user SET birthday=?,salary=? WHERE id=?";

		System.out.println(sql);

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(3, 4);

			ps.setBigDecimal(2, salary);
			System.out.print(salary);
			// BigDecimal
			// hehe = new java.util.Date().getTime();
			// System.out.println(hehe);

			// hehe = cal.add(hehe, +1);// 取当前日期的前一天.

			// cal.add(Calendar.DAY_OF_MONTH, +1);// 取当前日期的后一天.

			Date date = cal.getTime();
			ps.setDate(1, new java.sql.Date(date.getTime()));

			rows = ps.executeUpdate();
			System.out.println(rows + "rows effect");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

	}
}
