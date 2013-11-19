package normaldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestOthers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 写方法

		// System.out
		// .println(writeDB(
		// "insert into hehe_user(id,username,birthday,salary) values(?,?,?,?)",
		// new Object[] { 10, "林永泽",
		// new java.sql.Date(System.currentTimeMillis()),
		// new java.math.BigDecimal("0.5") })
		// + " rows affect.");
//		System.out.println(writeDB("delete from hehe_user where id=10", null));

		// 读方法
		System.out.println(readDB("select * from hehe_user", null));
	}
	
	
	/**
	 * 重写
	 * @param sql
	 * @return
	 */
	static int writeDB(String sql){
		return writeDB(sql,null);
	}
	/**
	 * 数据库通用写方法 写模板:insert,update,delete
	 * 
	 * @param sql
	 * @return
	 */
	static int writeDB(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);

			// SQL语句参数化
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rows = ps.executeUpdate();
			// System.out.println(rows + "rows effect");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return rows;
	}

	/**
	 * 通用读方法 SELECT
	 * 
	 * @param id
	 */
	static List<Map<String, Object>> readDB(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			// 参数化处理
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			//元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 测试rsmd方法使用
			int count = rsmd.getColumnCount();
			String[] columnName = new String[count];
			for (int i = 0; i < count; i++) {
//				System.out.println(rsmd.getColumnName(i + 1));
//				System.out.println(rsmd.getColumnTypeName(i + 1));
				columnName[i] = rsmd.getColumnName(i + 1);
			}

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < count; i++) {
					map.put(columnName[i], rs.getObject(i + 1));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return list;
	}
}
