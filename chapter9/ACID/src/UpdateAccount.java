import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author josephstalin 转账的业务
 */
public class UpdateAccount {
	PreparedStatement ps = null;

	UpdateAccount() {

	}

	/**
	 * 更新转账数据
	 * 
	 * @param fromSalary
	 * @param toSalary
	 * @param from
	 * @param to
	 * @param num
	 * @param con
	 * @return
	 */
	public boolean Update(BigDecimal fromSalary, BigDecimal toSalary, int from,
			int to, BigDecimal num, Connection con) {
		int temp = 0;
		if (fromSalary.compareTo(num) > 0) {
			try {
				// 减去银行钱数
				ps = con.prepareStatement("update bank set salary=? where id=?");
				ps.setBigDecimal(1, fromSalary.subtract(num));
				ps.setInt(2, from);
				System.out.println(ps.executeUpdate() + "rows effect");
				// 增加用户银行钱数
				ps = con.prepareStatement("update bank set salary=? where id=?");
				ps.setBigDecimal(1, toSalary.add(num));
				ps.setInt(2, to);
				System.out.println(ps.executeUpdate() + "rows effect");
				temp = 1;
				recordLog(from, to, num, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (temp == 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 记录每笔交易发生的时间
	 * @param from
	 * @param to
	 * @param num
	 * @param con
	 */
	public void recordLog(int from, int to, BigDecimal num, Connection con) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("INSERT INTO transferlog VALUES(?,?,?,?)");
			ps.setInt(1, from);
			ps.setInt(2, to);
			ps.setBigDecimal(3, num);
			//加入时间戳
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); 
			System.out.println(ps.executeUpdate() + "row effect");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
