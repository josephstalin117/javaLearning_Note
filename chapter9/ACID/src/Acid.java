import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Acid {

	/**
	 * @param args
	 */
	static Connection con = null;

	public static void main(String[] args) {
		int hehe = transfer(5, "123456", 2, "wakaka", new BigDecimal("100.00"));
		System.out.println(hehe);
	}

	/**
	 * 模拟银行转账
	 */
	static int transfer(int from, String Pwd, int to, String toName,
			BigDecimal num) {
		PreparedStatement ps = null;
		ResultSet rsFrom = null;
		ResultSet rsTo = null;
		int temp = 0;

		try {
			BigDecimal fromSalary;
			BigDecimal toSalary;
			con = Jdbc.getCon();
			con.setAutoCommit(false);

			// 读入数据库信息
			rsFrom = read(from);
			rsTo = read(to);

			// 判断能否登录

			if (login(from, Pwd, con)) {
				System.out.println("登录成功");
				if (verifyName(toName, rsTo)) {
					System.out.println("姓名匹配");
					rsFrom = read(from);
					rsTo = read(to);
					if (rsFrom.next()) {
						fromSalary = rsFrom.getBigDecimal("salary");
						if (rsTo.next()) {
							toSalary = rsTo.getBigDecimal("salary");
							UpdateAccount test = new UpdateAccount();// 实例化UpdateAccount
							if (test.Update(fromSalary, toSalary, from, to,
									num, con)) {
								System.out.println("转账成功");
								temp = 1;
							} else {
								System.out.println("金额不足");
								temp = -2;
							}
						}

					}
				} else {
					System.out.println("姓名不匹配");
					temp = -3;
				}
			} else {
				System.out.println("密码错误");
				temp = -1;
			}
			// 回滚判断
			if (temp == 1) {
				con.commit();
			} else {
				con.rollback();
			}

		} catch (SQLException e) {
			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// Jdbc.free(rs, ps, con);
			Jdbc.freeConnection(con);
		}
		switch (temp) {
		case 1:
			return 1;
		case -1:
			return -1;
		case -2:
			return -2;
		case -3:
			return -3;
		default:
			return 0;
		}
	}

	/**
	 * 读取数据
	 * 
	 * @param id
	 * @return
	 */
	private static ResultSet read(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,pwd,name,salary FROM bank WHERE id=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	/**
	 * 判断能否登录
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	@SuppressWarnings("finally")
	private static boolean login(int from, String pwd, Connection con) {
		CallableStatement cs = null;
		int temp = 0;

		try {
			cs = con.prepareCall("{Call verifyPerson(?,?,?)}");
			cs.setInt(1, from);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, Types.INTEGER);

			// 执行
			cs.executeUpdate();
			temp = cs.getInt(3);
			System.out.print(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (temp == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证姓名
	 * 
	 * @param toName
	 * @param rsTo
	 * @return
	 */
	private static boolean verifyName(String toName, ResultSet rsTo) {
		String Name = null;
		int i = 0;
		try {
			if (rsTo.next()) {
				Name = rsTo.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (toName.trim().equals(Name.trim())) {
			i = 1;
		}
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
}
