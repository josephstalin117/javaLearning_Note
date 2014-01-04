/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author josephstalin
 */
public class CloudTeacherDAO implements TeacherDAO {

    public boolean insertTeacher(Teacher t) {
        int i = -1;
        String sql = "insert into cr_teainfo(uuid,tid,tname,sex,birthday,did,spid,proid) values(?,?,?,?,?,?,?,?)";

        int uuid = t.getUuid();
        int tid = t.getTid();
        String tname = t.getTname();
        int sex = t.getSex();
        Date birthday = new java.sql.Date(t.getBirthday().getTime());
        int did = t.getDid();
        int spid = t.getSpid();
        int proid = t.getProid();

        i = CloudDAOFactory.writeDB(sql, new Object[]{uuid, tid, tname, sex, birthday, did, spid, proid}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTeacher(Teacher s) {
        int rows = 0;
        String sql = "DELETE FROM cr_teainfo where uuid=?";

        int uuid = s.getUuid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{uuid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public Teacher findTeacher(int uuid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_teainfo where uuid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uuid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingTeacher(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);
        }
        return null;
    }

    public List<Teacher> displayTeacher() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CachedRowSet cr = null;
        String sql = "select * from cr_teainfo";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);

            // 数组lisy
            List<Teacher> list = new ArrayList<Teacher>();
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mappingTeacher(rs));
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public CachedRowSet getClass(String tid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select cr_plan.pid,cr_curriculum.cname " + "from cr_plan,cr_curriculum "
                + "where cr_curriculum.cid=cr_plan.cid " + "and cr_plan.tid='"
                + tid + "'";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);

            return crs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean marking(String sid, String cid, String score) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update cr_modelselect " + "set score='" + score + "' "
                + "where sid='" + sid + "' " + "and cid='"
                + cid + "' ";

        int i = CloudDAOFactory.writeDB(sql); //设定输入数据

        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public CachedRowSet getStudents(String pid) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select cr_stuinfo.sid,cr_stuinfo.sname "
                + "from cr_stuinfo,cr_modelselect,cr_plan "
                + "where cr_stuinfo.sid=cr_modelselect.sid "
                + "and cr_plan.pid=cr_modelselect.pid " + "and cr_plan.pid='"
                + pid + "' ";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);

            return crs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;

    }

    public Teacher loginTeacher(int tid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_teainfo where tid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingTeacher(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);
        }
        return null;
    }

    public boolean updateTeacher(Teacher t) {
        String sql = "UPDATE cr_teainfo SET tid=?,tname=?,sex=?,birthday=?,did=?,spid=?,proid=? WHERE uuid=?";

        int uuid = t.getUuid();
        int tid = t.getTid();
        String tname = t.getTname();
        int sex = t.getSex();
        Date birthday = new java.sql.Date(t.getBirthday().getTime());
        int did = t.getDid();
        int spid = t.getSpid();
        int proid = t.getProid();

        int i = CloudDAOFactory.writeDB(sql, new Object[]{tid, tname, sex, birthday, did, spid, proid, uuid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Teacher mappingTeacher(ResultSet rs) throws SQLException {
        Teacher t = new Teacher();

        t.setUuid(rs.getInt("uuid"));
        t.setTid(rs.getInt("tid"));
        t.setTname(rs.getString("tname"));
        t.setSex(rs.getInt("sex"));
        t.setBirthday(rs.getDate("birthday"));
        t.setDid(rs.getInt("did"));
        t.setSpid(rs.getInt("spid"));
        t.setProid(rs.getInt("proid"));

        return t;
    }
}
