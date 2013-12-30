/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josephstalin
 */
public class CloudDAOFactory extends DAOFactory {

    private static String url = "jdbc:mysql://localhost:3306/coursesystem?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    //改成自己的密码
    private static String password = "lyz133551";

    /**
     * 构造函数
     */
    public CloudDAOFactory() {
    }

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to create Cloudscape connections
     *
     * @return
     */
    public static Connection getCon() {
        // Use DRIVER and DBURL to create a connection
        try {
            return (Connection) DriverManager
                    .getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //free connection
    public static void free(ResultSet rs, Statement sm, Connection con) {
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
    public static int writeDB(String sql) {
        return writeDB(sql, null);
    }

    /**
     * 数据库通用写方法 写模板:insert,update,delete
     *
     * @param sql
     * @return
     */
    public static int writeDB(String sql, Object[] params) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            con = getCon();
            ps = con.prepareStatement(sql);

            // SQL语句参数化
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rows = ps.executeUpdate();
            // System.out.println(rows + "rows effect");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            free(rs, ps, con);
        }
        return rows;
    }

    /**
     * CloudStudentDAO implements StudentDAO
     *
     * @return
     */
    public StudentDAO getStudentDAO() {
        return new CloudStudentDAO();
    }

    /**
     * CloudTeacherDAO implements TeacherDAO
     *
     * @return
     */
    public TeacherDAO getTeacherDAO() {
        return new CloudTeacherDAO();
    }

    /**
     * CloudAdminDAO implements AdminDAO
     *
     * @return
     */
    public AdminDAO getAdminDAO() {
        return new CloudAdminDAO();
    }

    /**
     * CloudCourseDAO implements CourseDAO
     *
     * @return
     */
    public CourseDAO getCourseDAO() {
        return new CloudCourseDAO();
    }

    /**
     * CloudUserDAO implements UserDAO
     *
     * @return
     */
    public UserDAO getUserDAO() {
        return new CloudUserDAO();
    }

    /**
     * CloudUserDAO implements UserDAO
     *
     * @return
     */
    public PlanDAO getPlanDAO() {
        return new CloudPlanDAO();
    }

    /**
     * CloudUserDAO implements UserDAO
     *
     * @return
     */
    public ModelDAO getModelDAO() {
        return new CloudModelDAO();
    }

}
