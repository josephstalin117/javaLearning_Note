package DateSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author josephstalin 连接池
 */
public class DataSource {
	private static String url = "jdbc:mysql://localhost:3306/hehe?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";

	// 密码换成自己的密码
	private static String password = "lyz133551";

	/**
	 * 数据库连接池
	 */
	private LinkedList<Connection> pool = new LinkedList<Connection>();

	private static int initCount = 5;
	private static int maxCount = 10;
	private int currentCount = 0;

	/**
	 * 生成连接池
	 */
	public DataSource() {
		for (int i = 0; i < initCount; i++) {
			try {
				pool.addLast(createConnection());
				currentCount++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getCon() throws SQLException {
		// 连接池中获得数据库连接
		// 支持多线程
		synchronized (pool) {
			if (pool.size() > 0) {
				return pool.removeFirst();
			} else {
				if (currentCount < maxCount) {
					currentCount++;
					return createConnection();
				} else {
					throw new SQLException();
				}
			}
		}
	}

	/**
	 * 将数据库连接归还到连接池
	 * @param con
	 */
	public void free(Connection con) {
		pool.addLast(con);
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

}
