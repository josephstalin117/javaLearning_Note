package JavaDateType;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

/**
 * @author josephstalin 文件读入后并修改时间
 * 
 */
public class JavaDateType {
	public static void main(String[] args) {
		read();

	}

	// 建立静态变量cal，用以修改时间类型
	static Calendar cal = Calendar.getInstance();
	static BigDecimal salary;

	/**
	 * 读取文件并修改然后输出
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
				// 获取id
				int id = rs.getInt("id");
				// 获取姓名
				String name = rs.getString("username");

				// 生日
				java.util.Date birthday = rs.getDate("birthday");
				cal.setTime(birthday);
				double score = rs.getDouble("score");
				// 薪水
				salary = rs.getBigDecimal("salary");
				BigDecimal wakaka = new BigDecimal("100.11");
				salary = salary.add(wakaka);

				java.sql.Timestamp log = rs.getTimestamp("log");
				java.util.Date d = new java.util.Date(log.getTime());

				// 测试输出
				System.out.print(id + "\t");
				System.out.print(name + "\t");
				System.out.print(birthday + "\t");
				System.out.print(score + "\t");
				System.out.print(salary + "\t");
				System.out.print(log);

				System.out.println(rs.getTime("log"));
				System.out.println(rs.getDate("log"));
				System.out.println(d);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

			// 获取当前时间
			Date date = cal.getTime();
			ps.setDate(1, new java.sql.Date(date.getTime()));

			// 更新时间
			rows = ps.executeUpdate();
			System.out.println(rows + "rows effect");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

	}
}
