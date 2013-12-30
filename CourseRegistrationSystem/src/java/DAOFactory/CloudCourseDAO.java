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
public class CloudCourseDAO implements CourseDAO {

    public boolean insertCourse(Course c) {
        int i = -1;
        String sql = "insert into cr_curriculum(cid,cname,cintroduction,credit,period,limit,cgesbook,mark) values(?,?,?,?,?,?,?,?)";

        int cid = c.getCid();
        String cname = c.getCname();
        String cintroduction = c.getCintroduction();
        int credit = c.getCredit();
        int period = c.getPeriod();
        int limit = c.getLimit();
        int cgesbook = c.getCgestbook();
        int mark = c.getMark();

        i = CloudDAOFactory.writeDB(sql, new Object[]{cid, cname, cintroduction, credit, period, limit, cgesbook, mark}); //设定输入数据
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCourse(Course c) {
        int rows = 0;
        String sql = "DELETE FROM cr_curriculum where cid=?";

        int cid = c.getCid();
        int i = CloudDAOFactory.writeDB(sql, new Object[]{cid}); //设定输入数据

        if (i > 0) {
            return true;
        }

        return false;
    }

    public Course findCourse(int cid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cr_curriculum where cid=?";

        try {
            con = CloudDAOFactory.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return mappingCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDAOFactory.free(rs, ps, con);

        }
        return null;
    }

    public boolean updateCourse(Course c) {
        String sql = "UPDATE cr_stuinfo SET cname=?,cintroduction=?,credit=?,period=?,spid=?,cgestbook=?,mark=? WHERE cid=?";

        int cid = c.getCid();
        String cname = c.getCname();
        String cintroduction = c.getCintroduction();
        int credit = c.getCredit();
        int period = c.getPeriod();
        int spid = c.getLimit();
        int cgestbook = c.getCgestbook();
        int mark = c.getMark();

        int i = CloudDAOFactory.writeDB(sql, new Object[]{cname, cintroduction, credit, period, spid, cgestbook, mark, cid});
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    private Course mappingCourse(ResultSet rs) throws SQLException {
        Course c = new Course();

        c.setCid(rs.getInt("cid"));
        c.setCname(rs.getString("cname"));
        c.setCintroduction(rs.getString("cintroduction"));
        c.setCredit(rs.getInt("credit"));
        c.setPeriod(rs.getInt("period"));
        c.setLimit(rs.getInt("limit"));
        c.setCgestbook(rs.getInt("cgestbook"));
        c.setMark(rs.getInt("mark"));

        return c;
    }
}
