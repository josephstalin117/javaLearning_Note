package photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author josephstalin 图片输入输出
 */
public class photo {
	public static void main(String[] args) throws IOException {
//		create();
		 read();
	}

	/**
	 * @throws IOException
	 *             图片文件输出
	 */
	static void read() throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select photo from hehe_content where Aid=?";
		InputStream r = null;
		FileOutputStream w = null;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 21);

			rs = ps.executeQuery();
			if (rs.next()) {
				// 获取二进制文件
				r = rs.getBinaryStream("photo");
				// 想输出文件的绝对路径
				File f = new File(".//photo//11.jpg");
				// 创建文件输出流
				w = new FileOutputStream(f);

				byte[] buf = new byte[9000];

				for (int i = 0; (i = r.read(buf)) != -1;) {
					// 文件写入硬盘
					w.write(buf, 0, i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
			r.close();
			w.close();
		}
	}

	static void create() throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update hehe_content set photo=? where Aid=?";

		try {

			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(2, 20);
			// 写入文件相对路径
			FileInputStream fin = new FileInputStream(".//photo//0.jpg");

			ps.setBinaryStream(1, fin);

			int i = ps.executeUpdate();
			System.out.println(i + " rows effect.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}

}
