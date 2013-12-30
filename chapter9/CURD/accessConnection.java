import java.io.File;
import java.sql.*;

public class accessConnection {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection con;
		Statement stmt;
		ResultSet rs;

		// String
		// dbUr1="jdbc:odbc:driver={Microsoft Access Driver(*.mdb)};DBQ=E:"+File.separator+"dataAnalysis"+File.separator+"db.mdb";
		// System.out.println(dbUr1);
		// String user = "";
		// String password = "";
		// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		// Connection c = DriverManager.getConnection(dbUr1, user, password);
		// Statement s = c.createStatement();
		// ResultSet r = s.executeQuery("SELECT hehe" + "FROM test");
		// while (r.next()) {
		// System.out.println(r.getString("hehe"));
		// }
		// s.close();
		// String dbUr1 =
		// "jdbc:odbc:driver={Microsoft Access Driver(*.mdb)};DBQ=E:"+File.separator+"dataAnalysis"+File.separator+"db.mdb";
		// // jdbc:odbc:Driver={Microsoft Access Driver (*.mdb,
		// *.accdb)};DBQ=E:\\dataAnalysis\\db.mdb;
		DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
		con = DriverManager.getConnection("jdbc:odbc:JAVAACCESS");
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT hehe FROM test");
		while (rs.next()) {
			System.out.println(rs.getString("hehe"));
		}
		rs.close();

	}
}