package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbc implements PersonDao {

	@Override
	public Person findPerson(String id) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				return mappingPerson(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);

		}
		return null;
	}

	private Person mappingPerson(ResultSet rs) throws SQLException {
		Person p = new Person();
		System.out.println(rs.getString("username"));
		p.setId(rs.getString("id"));
		p.setUsername(rs.getString("username"));
		p.setBirthday(new java.util.Date(rs.getDate("birthday").getTime()));
		p.setState(rs.getInt("state"));

		p.getId();
		return p;
	}

	@Override
	public boolean invalidPerson(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "UPDATE hehe_user SET state=? where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 0);// 0代表离职，1代表在职
			ps.setString(2, p.getId());

			rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return false;
	}

	@Override
	public boolean newPerson(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "insert into hehe_user(id,username,birthday,state)"
				+ "values(?,?,?,?)";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getId());
			ps.setString(2, p.getUsername());
			ps.setDate(3, new java.sql.Date(p.getBirthday().getTime()));
			ps.setInt(4, p.getState());

			rows = ps.executeUpdate();
			// System.out.println(rows + "rows effect");
			if (rows > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DaoException("未成功登记员工信息");
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return false;
	}

	@Override
	public boolean deletePerson(Person p) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "DELETE FROM hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getId());

			rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDao#changeName(dao.Person) 修改名字
	 */
	public boolean changeName(Person p, String hehename) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "UPDATE hehe_user SET username=? where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(2, p.getId());
			ps.setString(1, hehename);

			rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return false;
	}

	public List<Person> findState(String state) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from hehe_user where state=?";
		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, state);
			List<Person> list = new ArrayList<Person>();
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(mappingPerson(rs));
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return null;
	}

}
