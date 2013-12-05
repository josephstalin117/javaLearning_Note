package rollName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class curd {

    public static void main(String[] args) {
        read("4");
		// 测试writeDb
        // .println(writeDb(
        // "insert into hehe_user(id,username,birthday,salary) values(?,?,?,?)",
        // new Object[] { 6, "林永泽",
        // new java.sql.Date(System.currentTimeMillis()),
        // new java.math.BigDecimal("0.5") })
        // + " rows affect.");

        // 测试insert
         int test = insert("测试一下", 1998, 11, 11, 1);
         System.out.print(test);
        // 测试删除
        // int test2=delete(10);
        // System.out.print(test2);
    }

    /**
     * 增加新同学
     *
     * @param username
     * @param year
     * @param month
     * @param day
     * @param isex
     * @return
     */
    public static int insert(String username, int year, int month,
            int day, int isex) {
        if (month <= 12 && month >= 1 && day >= 1 && day <= 30) {
            Calendar calendar = new GregorianCalendar(year, month - 1, day, 0,
                    0, 0);
            Date birthday = calendar.getTime();
            int i = writeDb(
                    "INSERT INTO hehe_user(username,birthday,state) VALUES(?,?,?)",
                    new Object[]{username, birthday, isex});
            return i;
        } else {
            return 0;
        }
    }

    /**
     * 删除同学
     *
     * @param id
     * @return
     */
    public static int delete(int id) {
        int i = writeDb("DELETE FROM hehe_user WHERE id=?", new Object[]{id});
        return i;
    }

    /**
     * 更新学生信息
     *
     * @param id
     * @param username
     * @param year
     * @param month
     * @param day
     * @param isex
     * @return
     */
    public static int update(int id, String username, int year, int month,
            int day, int isex) {
        if (month <= 12 && month >= 1 && day >= 1 && day <= 30) {
            Calendar calendar = new GregorianCalendar(year, month - 1, day, 0,
                    0, 0);
            Date birthday = calendar.getTime();
            int i = writeDb(
                    "UPDATE hehe_user SET username=?,birthday=?,state=? WHERE id=?",
                    new Object[]{username, birthday, isex, id});
            return i;
        } else {
            return 0;
        }
    }

    /**
     * 查找用户
     *
     * @param id
     */
    public static void read(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM hehe_user WHERE id=?";

        try {
            con = Jdbc.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.free(rs, ps, con);
        }
    }

    /**
     * 重写
     *
     * @param sql
     * @return
     */
    private static int writeDb(String sql) {
        return writeDb(sql, null);
    }

    /**
     * 通用写方法
     *
     * @param sql
     * @param params
     * @return
     */
    private static int writeDb(String sql, Object[] params) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            con = Jdbc.getCon();
            ps = con.prepareStatement(sql);

            // SQL语句参数化
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.free(rs, ps, con);
        }
        if (rows != 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
