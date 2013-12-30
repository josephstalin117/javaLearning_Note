package RegisterBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class CloudDB {

    private static String url = "jdbc:mysql://localhost:3306/hehe?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";

    //改成自己的密码
    private static String password = "lyz133551";

    private CloudDB() {
    }

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection getCon() {
        try {
            return (Connection) DriverManager
                    .getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void free(ResultSet rs, Statement sm, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 重写
     *
     * @param sql
     * @return
     */
    public static int writeDb(String sql) {
        return writeDb(sql, null);
    }

    /**
     * 通用写方法
     *
     * @param sql
     * @param params
     * @return
     */
    public static int writeDb(String sql, Object[] params) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            con = CloudDB.getCon();
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
            CloudDB.free(rs, ps, con);
        }
        if (rows != 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
