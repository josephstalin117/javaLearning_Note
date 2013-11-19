package GeneratedId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Others {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// getGeneratedId("hehe~");
		scroll(1);
	}

	/**
	 * 插入新数据同时返回主键
	 * 
	 * @param username
	 * @return
	 */
	static int getGeneratedId(String username) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into hehe_user(username) values(?)";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, username);

			int i = ps.executeUpdate();
			System.out.println(i + "rows effect");

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				i = rs.getInt(1);
				System.out.println("generated id=: " + i);
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return -1;
	}

	/**
	 * 可滚动的结果集，分页
	 * 
	 * @param currentPage
	 */
	static void scroll(int page) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,username,birthday,salary from hehe_user";
		// select * from hehe_user limit 1,10;
		// metadata

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			// 获取总行数
			rs.last();
			int size = rs.getRow();

			// select count(*) from hehe_user

			// 计算总页数
			int pageSize = 3;
			int pageCount = 0;
			if (size % pageSize == 0) {
				pageCount = size / pageSize;
			} else {
				pageCount = size / pageSize + 1;
			}
			if (page > pageCount) {
				page = pageCount;
			}

			// 计算当前页起始记录

			rs.absolute((page - 1) * pageSize + 1);

			int i = 0;
			do {
				i++;
				System.out.println(rs.getInt("id") + "\t"
						+ rs.getString("username") + "\t"
						+ rs.getDate("birthday") + "\t"
						+ rs.getBigDecimal("salary"));

			} while (rs.next() && i < pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);

		}
	}
}
