package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDaoJdbc implements PersonDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDao#findPerson(java.lang.String)
	 */
	@Override
	public Person findPerson(String id) {

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

	/**
	 * 设定职工信息，并返回职工对象
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Person mappingPerson(ResultSet rs) throws SQLException {
		Person p = new Person();
		//输出员工姓名
//		System.out.println(rs.getString("username"));
		p.setId(rs.getInt("id"));
		p.setUsername(rs.getString("username"));
		p.setBirthday(new java.util.Date(rs.getDate("birthday").getTime()));
		p.setState(rs.getInt("state"));

		p.getId();
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDao#invalidPerson(dao.Person) 员工离职
	 */
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
			ps.setInt(2, p.getId());

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
	 * @see dao.PersonDao#newPerson(dao.Person) 新增员工
	 */
	@Override
	public Person newPerson(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = -1;
		String sql = "insert into hehe_user(username,birthday,state)"
				+ "values(?,?,?)";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			String username = p.getUsername();
			Date birthday = new java.sql.Date(p.getBirthday().getTime());
			int state = p.getState();

			ps.setString(1, p.getUsername());
			ps.setDate(2, new java.sql.Date(p.getBirthday().getTime()));
			ps.setInt(3, p.getState());

			int rows = ps.executeUpdate();
			System.out.println(rows + "rows effect");
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				i = rs.getInt(1);
				System.out.println("generated id= " + i);

				// 返回对象p本身
				p.setId(i);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DaoException("未成功登记员工信息");
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDao#deletePerson(dao.Person) 移除员工信息
	 */
	@Override
	public boolean deletePerson(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "DELETE FROM hehe_user where id=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());

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
	 * 
	 * 修改名字
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
			ps.setInt(2, p.getId());
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

	/**
	 * 列出员工状态
	 * 
	 * @param state
	 * @return
	 */
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
			// 数组lisy
			List<Person> list = new ArrayList<Person>();
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(mappingPerson(rs));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return null;
	}

}
