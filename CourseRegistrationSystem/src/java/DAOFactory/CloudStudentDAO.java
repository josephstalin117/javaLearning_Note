/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author josephstalin
 */
public class CloudStudentDAO implements StudentDAO {

    public boolean insertStudent(Student s) {
        int i = -1;
        String sql = "insert into cr_stuinfo(uuid,sid,sname,sex,did,spid,birthday,enrollment) values(?,?,?,?,?,?,?,?)";

        int uuid = s.getUuid();
        int sid = s.getSid();
        String sname = s.getSname();
        int sex = s.getSex();
        int did = s.getDid();
        int spid = s.getSpid();
        Date birthday = new java.sql.Date(s.getBirthday().getTime());
        Date enrollment = new java.sql.Date(s.getEnrollment().getTime());

        i = CloudDAOFactory.writeDB(sql, new Object[]{uuid, sid, sname, sex, did, spid, birthday, enrollment}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(Student s) {
        int rows = 0;
        String sql = "DELETE FROM cr_stuinfo where uuid=?";

        int uuid = s.getUuid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{uuid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public Student findStudent(int uuid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_stuinfo where uuid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, uuid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public Student loginStudent(int sid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_stuinfo where sid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean updateStudent(Student s) {
        String sql = "UPDATE cr_stuinfo SET sid=?,sname=?,sex=?,did=?,spid=?,birthday=?,enrollment=? WHERE uuid=?";

        int uuid = s.getUuid();
        int sid = s.getSid();
        String sname = s.getSname();
        int sex = s.getSex();
        int did = s.getDid();
        int spid = s.getSpid();
        Date birthday = new java.sql.Date(s.getBirthday().getTime());
        Date enrollment = new java.sql.Date(s.getEnrollment().getTime());

        int i = CloudDAOFactory.writeDB(sql, new Object[]{sid, sname, sex, did, spid, birthday, enrollment, uuid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Student mappingStudent(ResultSet rs) throws SQLException {
        Student s = new Student();

        s.setUuid(rs.getInt("uuid"));
        s.setSid(rs.getInt("sid"));
        s.setSname(rs.getString("sname"));
        s.setSex(rs.getInt("sex"));
        s.setDid(rs.getInt("did"));
        s.setSpid(rs.getInt("spid"));
        s.setBirthday(rs.getDate("birthday"));
        s.setEnrollment(rs.getDate("enrollment"));

        return s;
    }

}
