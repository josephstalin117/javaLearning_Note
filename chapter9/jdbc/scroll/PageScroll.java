package Scroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author josephstalin 分页类
 */
public class PageScroll {
	static Connection con = null;
	private static int currentPage = 1;// 当前页

	int pageCount = 0;// 总页数
	static int pageSize = 3;// 每页显示多少条记录,默认为3条
	int size = 0;// 共有多少条记录

	/**
	 * 数据库分页
	 * 
	 * @param record
	 */
	public PageScroll(int record) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		pageSize = record;

		String sql = "SELECT count(*) FROM hehe_user";

		try {
			con = Jdbc.getCon();

			// 获取总页数
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				size = rs.getInt(1);
				if (size % pageSize == 0) {
					pageCount = size / pageSize;
				} else {
					pageCount = size / pageSize + 1;
				}
			}
			System.out.println("共有数据" + size + "条" + "每页显示" + pageSize + "条数据");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.freeRS(rs, ps);

		}
	}

	/**
	 * 验证是否越界
	 * 
	 * @return
	 */
	private boolean verifyPageCount() {
		if (currentPage < pageCount) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 下一页
	 */
	public void nextPage() {
		if (verifyPageCount()) {
			if (currentPage == pageCount) {
				findPage(1);
			} else {
				currentPage++;
				findPage(currentPage);
			}
		} else {
			lastPage();
		}
	}

	/**
	 * 上一页
	 */
	public void prePage() {
		if (verifyPageCount()) {
			currentPage--;
			findPage(currentPage);
		} else {
			firstPage();
		}
	}

	/**
	 * 首页
	 */
	public void firstPage() {
		findPage(1);
	}

	/**
	 * 末页
	 */
	public void lastPage() {
		findPage(pageCount);
	}

	/**
	 * 显示当前位置
	 */
	private void showPage() {
		System.out.println("currentPage = " + currentPage + " PageSize =  "
				+ pageSize);
	}

	/**
	 * 跳转页面
	 * 
	 * @param findPage
	 */
	public void findPage(int findPage) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,username,birthday,salary FROM hehe_user limit ?,?";
		if (findPage > pageCount) {
			System.out.println("没有此页面");
		} else {
			currentPage = findPage;
		}

		try {
			showPage();
			ps = con.prepareStatement(sql);

			int offSet = (findPage - 1) * pageSize;
			int rowCount = findPage * pageSize;
			ps.setInt(1, offSet);
			ps.setInt(2, rowCount);

			rs = ps.executeQuery();
			int i = 0;
			while (rs.next() && i < pageSize) {
				i++;
				System.out.println(i + "\t" + rs.getInt("id") + "\t"
						+ rs.getString("username") + "\t"
						+ rs.getDate("birthday") + "\t"
						+ rs.getBigDecimal("salary"));
			}
			System.out.println("===============");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.freeRS(rs, ps);

		}
	}

	public static void freeConnection() {
		Jdbc.freeConnection(con);
	}

}
