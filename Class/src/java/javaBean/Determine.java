/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBean;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josephstalin
 */
public class Determine {

    int pageSize = 10;                      //每页显示的记录数
    int pageAllCount = 0;                   //分页后的总页数
    int showPage = 1;                   //当前显示页 
    StringBuffer presentPageResult;      //显示当前页内容
    CachedRowSetImpl rowSet;            //用于存储ResultSet对象
    String tableName = "";                //表的名字
    String zd[] = new String[100];
    int zdgs = 0;

    public Determine() {
        presentPageResult = new StringBuffer();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
        }
    }

    public void setPageSize(int size) {
        pageSize = size;
        zdgs = 0;
        String uri
                = "jdbc:sqlserver://127.0.0.1:3306;DatabaseName=class_db";
        try {
            Connection con = DriverManager.getConnection(uri, "root", "lyz133551");
            DatabaseMetaData metadata = con.getMetaData();
            ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
            int k = 0;
            while (rs1.next()) {
                zdgs++;
                zd[k] = rs1.getString(4); //获取字段的名字
                k++;
            }
            Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = sql.executeQuery("SELECT * FROM " + tableName);
            rowSet = new CachedRowSetImpl();  //创建行集对象
            rowSet.populate(rs);
            con.close();                    //关闭连接 
            rowSet.last();
            int m = rowSet.getRow();          //总行数
            int n = pageSize;
            pageAllCount = ((m % n) == 0) ? (m / n) : (m / n + 1);
        } catch (Exception exp) {
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageAllCount() {
        return pageAllCount;
    }

    public void setShowPage(int n) {
        showPage = n;
    }

    public int getShowPage() {
        return showPage;
    }

    public StringBuffer getPresentPageResult() {
        if (showPage > pageAllCount) {
            showPage = 1;
        }
        if (showPage <= 0) {
            showPage = pageAllCount;
        }
        presentPageResult = show(showPage);
        return presentPageResult;
    }

    public StringBuffer show(int page) {
        StringBuffer str = new StringBuffer();
        str.append("<table border=1>");
        str.append("<tr>");
        for (int i = 0; i < zdgs; i++) {
            str.append("<th>" + zd[i] + "</th>");
        }
        str.append("</tr>");
        try {
            rowSet.absolute((page - 1) * pageSize + 1);
            for (int i = 1; i <= pageSize; i++) {
                str.append("<tr>");
                for (int k = 1; k <= zdgs; k++) {
                    str.append("<td>" + rowSet.getString(k) + "</td>");
                }
                str.append("</tr>");
                rowSet.next();
            }
        } catch (SQLException exp) {
        }
        str.append("</table>");
        return str;
    }

    public void setTableName(String s) {
        tableName = s.trim();
    }

    public String getTableName() {
        return tableName;
    }

    /**
     *
     * 选择教师要带的学生
     *
     */
    public ResultSet getClass(String tea_id) {

        String sql = "select classes.id,course.name  " + "from classes,course "
                + "where course.id=classes.cour_id " + "and classes.tea_id='"
                + tea_id + "' ";

        SqlBean sqlbean = new SqlBean();

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    /**
     *
     * 当教师挑选学生后，显示的下一页面是批准要所带的班级及学生 批准要所带的班级及学生
     *
     */
    public ResultSet getStudents(String class_id) {

        String sql = "select student.id,name,department,sex,mark,e_mail,tel "
                + "from student,enrol,classes "
                + "where student.id=enrol.stu_id " + "and enrol.accept='0'"
                + "and classes.id=enrol.class_id " + "and classes.id='"
                + class_id + "' ";

        System.out.print("您所带的班级及学生:" + sql);

        SqlBean sqlbean = new SqlBean();

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    /**
     *
     * 显示学生成绩
     *
     */
    public ResultSet getStudents2(String class_id) {

        String sql = "select student.id as id,student.name as name ,student.department as department,student.sex as sex,student.mark as mark,student.e_mail as e_mail,student.tel as tel "
                + "from student,enrol,classes "
                + "where student.id=enrol.stu_id " + "and enrol.accept='1'"
                + "and classes.id=enrol.class_id " + "and classes.id='"
                + class_id + "' ";

        SqlBean sqlbean = new SqlBean();

        System.out.print("显示学生成绩:" + sql);

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    public ResultSet getStudents22(String class_id) {

        String sql = "select student.id as id,student.name as name ,student.department as department,student.sex as sex,student.mark as mark,student.e_mail as e_mail,student.tel as tel "
                + "from student,enrol,classes "
                + "where student.id=enrol.stu_id " + "and enrol.accept='1'" + "and enrol.score=0"
                + "and classes.id=enrol.class_id " + "and classes.id='"
                + class_id + "' ";

        SqlBean sqlbean = new SqlBean();

        System.out.print("显示学生成绩:" + sql);

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    /**
     *
     * 显示学生信息及成绩
     *
     */
    public ResultSet getStudents3(String class_id) {

        String sql = "select student.id,name ,department,sex,mark,e_mail,tel,enrol.score as score"
                + "from student,enrol,classes "
                + "where student.id=enrol.stu_id " + "and enrol.accept='1' "
                + "and classes.id=enrol.class_id "
                + "and classes.id='" + class_id + "' ";

        SqlBean sqlbean = new SqlBean();
        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    /**
     *
     * 接受学生的选课
     *
     */
    public int enrol(String stu_id, String class_id) {

        int num = 0;

        String sql = "update enrol set accept=1  " + "where stu_id='" + stu_id
                + "' " + "and class_id='" + class_id + "'  ";

        SqlBean db = new SqlBean();

        num = db.executeInsert(sql);

        return num;

    }

    /**
     *
     * 给所带的学生打分
     *
     */
    public int marking(String stu_id, String class_id, String score) {

        int num = 0;

        String sql = "update enrol " + "set score='" + score + "' "
                + "where stu_id='" + stu_id + "' " + "and class_id='"
                + class_id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeInsert(sql);

        return num;

    }

    /**
     *
     * 当成绩大于60时，则通过
     *
     */
    public int addMark(String stu_id, String class_id) {

        int num = 0;

        String sql = "update student,course,classes "
                + "set student.mark=student.mark+course.mark "
                + "where student.id='"
                + stu_id + "' " + "and course.id=classes.cour_id "
                + "and classes.id='" + class_id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeInsert(sql);

        return num;
    }

}
