/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josephstalin
 */
public class CloudUserDAO implements UserDAO {

    public User insertUser(User u) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = -1;
        String sql = "insert into cr_account(nackname,role,email,password,picture,secuquestion,secuanswer) values(?,?,?,?,?,?,?)";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //设定属性
            String nackname = u.getNackname();
            int role = u.getRole();
            String email = u.getEmail();
            String password = u.getPassword();
            String picture = u.getPicture();
            String secuquestion = u.getSecuquestion();
            String secuanswer = u.getSecuanswer();

            ps.setString(1, nackname);
            ps.setInt(2, role);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, picture);
            ps.setString(6, secuquestion);
            ps.setString(7, secuanswer);

            int rows = ps.executeUpdate();
            System.out.println(rows + "rows effect");
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i = rs.getInt(1);
                System.out.println("generated id= " + i);

                // 返回对象p本身
                u.setUuid(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("未成功登记员工信息");
        } finally {
            CloudDAOFactory.free(rs, ps, con);
        }
        return u;
    }

    public boolean deleteUser(User u) {
        int i = 0;
        String sql = "DELETE FROM cr_account where uuid=?";

        int uuid = u.getUuid();
        i = CloudDAOFactory.writeDB(sql, new Object[]{uuid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public User findUser(int uuid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_account where uuid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uuid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean updateUser() {
        return true;
    }

    private User mappingUser(ResultSet rs) throws SQLException {
        User u = new User();

        u.setUuid(rs.getInt("uuid"));
        u.setNackname(rs.getString("nackname"));
        u.setRole(rs.getInt("role"));
        u.setEmail(rs.getString("email"));
        u.setPassword(rs.getString("password"));
        u.setPicture(rs.getString("picture"));
        u.setSecuquestion(rs.getString("secuquestion"));
        u.setSecuanswer(rs.getString("secuanswer"));

        return u;
    }
}
