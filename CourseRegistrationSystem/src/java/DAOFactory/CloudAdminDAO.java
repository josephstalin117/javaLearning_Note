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

/**
 *
 * @author josephstalin
 */
public class CloudAdminDAO implements AdminDAO {

    @Override
    public boolean insertAdmin(Admin a) {
        int i = -1;
        String sql = "insert into cr_admin(uuid,username) values(?,?)";

        int uuid = a.getUuid();
        String username = a.getUsername();

        i = CloudDAOFactory.writeDB(sql, new Object[]{uuid, username}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(Admin a) {
        int rows = 0;
        String sql = "DELETE FROM cr_admin where uuid=?";

        int uuid = a.getUuid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{uuid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    @Override
    public Admin findAdmin(int uuid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_admin where uuid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uuid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingAdmin(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);
        }
        return null;
    }

    @Override
    public boolean updateAdmin(Admin a) {
        String sql = "UPDATE cr_admin SET username=? WHERE uuid=?";

        int uuid = a.getUuid();
        String username = a.getUsername();

        int i = CloudDAOFactory.writeDB(sql, new Object[]{username, uuid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Admin mappingAdmin(ResultSet rs) throws SQLException {
        Admin t = new Admin();

        t.setUuid(rs.getInt("uuid"));
        t.setUsername(rs.getString("username"));

        return t;
    }

}
