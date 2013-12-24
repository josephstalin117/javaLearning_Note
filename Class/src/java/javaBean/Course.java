/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author josephstalin
 */
public class Course {
    /*

     * 通过get(),set()方法来得到课程信息

     */

    private String id;

    private String name;

    private String dep;

    private String prepare;

    private int mark;

    public void setPrepare(String s) {
        prepare = s;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setMark(int s) {
        mark = s;
    }

    public int getMark() {
        return mark;
    }

    public void setDep(String s) {
        dep = s;
    }

    public String getDep() {
        return dep;
    }

    public String getId() {

        return id;

    }

    public void setId(String id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    /*

     * 得到所能选择的预修课

     *返回类型：ResultSet

     @return

     */
    public ResultSet getPrepares() {               //得到所能选择的预修课

        String sql = "select name,id from course   ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 察看预修课所在系

     *返回类型：String

     @return

     */
    public String getPrepareDep() {                 //察看预修课所在系

        String s = "no";

        String sql = "select dep from course where id='" + prepare + "' ";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {

                s = rs.getString("dep");

            }

        } catch (Exception e) {
            e.getMessage();
        }

        return s;
    }

    /*

     * 得到所有课程

     *返回类型：ResultSet

     @return

     */
    public ResultSet getCourse() {         //察看所有课程

        String sql = "select * from course   ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 删除课程信息

     *返回类型：int

     @param id

     @return

     */
    public int deleteCourse(String id) {

        int num = 0;

        String sql = "delete  from Course where id ='" + id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeDelete(sql);

        return num;

    }

    /*

     * 判断课程所在系与预修课所在系是否不一致

     *返回类型：String

     @param id

     @return

     */
    public String getPrepareDep(String id) {

        String dep = "";

        String sql = "select dep from course where id='" + id + "'";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                dep = rs.getString("dep");
            }

        } catch (SQLException e) {
            System.out.print(e.toString());
        }

        return dep;

    }

    /*

     * 更新课程信息

     *返回类型：void

     @param id

     */
    public void updateCourse(String id) {

        String sql = "update course "
                + " set name='" + name + "',prepare='" + prepare + "',"
                + "dep='" + dep + "',mark='" + mark + "'  "
                + " where id='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 增加课程信息

     *返回类型：void

     */
    public void addCourse() {

        String sql = "insert into course(id,name,mark,prepare,dep) "
                + "VALUES('" + id + "','" + name + "','" + mark + "','" + prepare + "','" + dep + "') ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 判断此课程是否有

     *返回类型：boolean

     @param id

     @return

     */
    public boolean hasLogin(String id) {

        boolean f = true;

        String sql = "select id from course where id='" + id + "'  ";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                f = false;
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return f;

    }

}
