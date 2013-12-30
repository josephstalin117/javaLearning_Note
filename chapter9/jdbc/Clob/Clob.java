package Clob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Clob {

	public static void main(String[] args) throws IOException {
//		create();
		 read();
	}

	/**
	 * @throws IOException
	 *             输出文件数据
	 */
	static void read() throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT content FROM hehe_content WHERE Aid=?";
		Reader r = null;
		Writer w = null;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			// 获取id是21的用户
			ps.setInt(1, 21);

			rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getCharacterStream("content");

				// 文件输出
				File f = new File(".//Clob//wakaka.txt");
				w = new BufferedWriter(new FileWriter(f));

				char[] buf = new char[1024];
				for (int i = 0; (i = r.read(buf)) > 0;) {
					w.write(buf, 0, i);
				}
				System.out.println("文件输出成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
			// 关闭输入输出流
			r.close();
			w.close();
		}
	}

	/**
	 * @throws IOException
	 *             读取文件数据方法
	 */
	static void create() throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "UPDATE hehe_content SET content=? WHERE Aid=?";
		Reader r = null;

		try {

			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(2, 21);
			
			//读入hehe.txt文件
			File f = new File("hehe.txt");
			r = new BufferedReader(new FileReader(f));
			ps.setCharacterStream(1, r, f.length());

			int i = ps.executeUpdate();
			System.out.println(i + " rows effect.");
			System.out.println("文件写入成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
			r.close();

		}
	}

}