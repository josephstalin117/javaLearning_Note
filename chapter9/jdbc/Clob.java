//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Reader;
//import java.io.Writer;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Clob {
//
//	public static void main(String[] args) throws IOException {
//		create();
////		read();
//	}
//
//	static void read() throws IOException {
//		Connection con = null;
//		// Statement sm = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "select blog from hehe_user where id=?";
//		Reader r = null;
//		Writer w = null;
//
//		try {
//			con = Jdbc.getCon();
//			ps = con.prepareStatement(sql);
//			ps.setString(1, "1");
//
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				r=rs.getCharacterStream("blog");
//				File f = new File("wakaka.txt");
//				w = new BufferedWriter(new FileWriter(f));
//				char[] buf = new char[1024];
//				for (int i = 0; (i = r.read(buf)) > 0;) {
//					w.write(buf, 0, i);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			Jdbc.free(rs, ps, con);
//			r.close();
//			w.close();
//		}
//	}
//
//	static void create() throws IOException {
//		Connection con = null;
//		// Statement sm = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "update hehe_user set blog=? where id=?";
//		Reader r = null;
//
//		try {
//
//			con = Jdbc.getCon();
//			// sm = con.createStatement();
//			// System.out.println(sql);
//			ps = con.prepareStatement(sql);
//			// ps.setString(1, "1");
//			ps.setString(2, "2");
//			File f = new File("hehe.txt");
//			r = new BufferedReader(new FileReader(f));
//			ps.setCharacterStream(1, r, f.length());
//
//			// rs = sm.executeQuery(sql);
//			int i = ps.executeUpdate();
//			System.out.println(i + " rows effect.");
//			// while (rs.next()) {
//			// System.out.println(rs.getObject("username"));
//			//
//			// }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// Jdbc.free(rs, sm, con);
//			Jdbc.free(rs, ps, con);
//			r.close();
//
//		}
//	}
//
//}