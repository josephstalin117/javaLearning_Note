import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class photo {
	public static void main(String[] args) throws IOException {
		// create();
		read();
	}

	static void read() throws IOException {
		Connection con = null;
		// Statement sm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select photo from hehe_user where id=?";
		InputStream r = null;
		FileOutputStream w = null;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "1");

			rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getBinaryStream("photo");
				File f = new File(
						"F:\\学校事务\\学业\\大三上\\java\\java\\chapter9\\jdbc\\11.jpg");
				w = new FileOutputStream(f);
				byte[] buf = new byte[9000];

				for (int i = 0; (i = r.read(buf)) != -1;) {
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
		// Statement sm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update hehe_user set photo=? where id=?";
		Reader r = null;

		try {

			con = Jdbc.getCon();
			// sm = con.createStatement();
			// System.out.println(sql);
			ps = con.prepareStatement(sql);
			// ps.setString(1, "1");
			ps.setString(2, "13");
			File f = new File("0.png");
			FileInputStream fin = new FileInputStream("0.jpg");
			ps.setBinaryStream(1, fin);

			// rs = sm.executeQuery(sql);
			int i = ps.executeUpdate();
			System.out.println(i + " rows effect.");
			// while (rs.next()) {
			// System.out.println(rs.getObject("username"));
			//
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
			r.close();

		}
	}

}
