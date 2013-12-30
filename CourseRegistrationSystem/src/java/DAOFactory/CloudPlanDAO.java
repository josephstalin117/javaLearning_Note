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
public class CloudPlanDAO implements PlanDAO {

    public boolean insertPlan(Plan p) {
        int i = -1;
        String sql = "insert into cr_plan(pid,cid,tid,location,capacity,prepare,classtime) values(?,?,?,?,?,?,?)";

        int pid = p.getPid();
        int cid = p.getCid();
        int tid = p.getTid();
        int location = p.getLocation();
        int capacity = p.getCapacity();
        int prepare = p.getPrepare();
        int classtime = p.getClasstime();

        i = CloudDAOFactory.writeDB(sql, new Object[]{pid, cid, tid, location, capacity, prepare, classtime}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePlan(Plan p) {
        int rows = 0;
        String sql = "DELETE FROM cr_plan where pid=?";

        int pid = p.getCid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{pid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public Plan findPlan(int pid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_plan where pid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingPlan(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean updatePlan(Plan p) {
        //修改到这里
        String sql = "UPDATE cr_plan SET cid=?,tid=?,location=?,capacity=?,prepare=?,classtime=? WHERE pid=?";

        int pid = p.getPid();
        int cid = p.getCid();
        int tid = p.getTid();
        int location = p.getLocation();
        int capacity = p.getCapacity();
        int prepare = p.getPrepare();
        int classtime = p.getClasstime();

        int i = CloudDAOFactory.writeDB(sql, new Object[]{cid, tid, location, capacity, prepare, classtime, pid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Plan mappingPlan(ResultSet rs) throws SQLException {
        Plan p = new Plan();

        p.setPid(rs.getInt("pid"));
        p.setCid(rs.getInt("cid"));
        p.setTid(rs.getInt("tid"));
        p.setLocation(rs.getInt("location"));
        p.setCapacity(rs.getInt("capacity"));
        p.setPrepare(rs.getInt("prepare"));
        p.setClasstime(rs.getInt("classtime"));

        return p;
    }
}
