import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

	public static void main(String[] args) {
		read("select * from personal");
//		write("update personal set salary=salary+100");
	}

	static void read(String sql) {
		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;

		try {
			con = Jdbc.getCon();
			sm = con.createStatement();
			System.out.println(sql);
			rs = sm.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getObject("ID") + "\t"
						+ rs.getObject("name") + "\t" + rs.getObject("salary"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, sm, con);
		}
	}

	static int write(String sql) {
		Connection con=null;
		Statement sm=null;
		ResultSet rs=null;
		int rows=0;
		
		try{
			con=Jdbc.getCon();
			sm=con.createStatement();
			System.out.println(sql);
			rows=sm.executeUpdate(sql);
			System.out.println(rows+"rows effect");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs,sm,con);
		}
		return rows;
		
		
	}

}
