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
public class CloudModelDAO implements ModelDAO {

    public boolean insertModel(Model m) {
        int i = -1;
        String sql = "insert into cr_modelselect(sid,cid) values(?,?)";

        int sid = m.getSid();
        int cid = m.getCid();

        i = CloudDAOFactory.writeDB(sql, new Object[]{sid, cid}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteModel(Model m) {
        String sql = "DELETE FROM cr_modelselect where mid=?";

        int mid = m.getMid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{mid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public Model findModel(int mid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_modelselect where mid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingModel(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean updateModel(Model m) {
        String sql = "UPDATE cr_modelselect SET sid=?,cid=?,accept=?,score=? WHERE mid=?";

        int mid = m.getMid();
        int sid = m.getSid();
        int cid = m.getCid();
        int accept = m.getAccept();
        int score = m.getScore();

        int i = CloudDAOFactory.writeDB(sql, new Object[]{sid, cid, accept, score, mid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Model mappingModel(ResultSet rs) throws SQLException {
        Model m = new Model();

        m.setMid(rs.getInt("mid"));
        m.setSid(rs.getInt("sid"));
        m.setCid(rs.getInt("cid"));
        m.setAccept(rs.getInt("accept"));
        m.setScore(rs.getInt("score"));

        return m;
    }
}
