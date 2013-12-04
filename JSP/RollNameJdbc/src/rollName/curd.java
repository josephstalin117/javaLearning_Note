package rollName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class curd {
	
	public static void main(String[] args){
		read("4");
	}
	
	public static void read(String id){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM hehe_user WHERE id=?";
		
		try{
			con=Jdbc.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("username"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs,ps,con);
		}
		
		
	}
}
