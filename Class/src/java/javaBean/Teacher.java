/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBean;

import java.sql.ResultSet;

/**
 *
 * @author josephstalin
 */
public class Teacher {
    /*

     * 通过get(),set()方法来得到教师信息

     */

    String id;

    String name;

    String password;

    String title;

    public void setPassword(String s) {
        password = s;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String s) {
        title = s;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*

     * 得到所有课程

     *返回类型：ResultSet

     @return

     */
    public ResultSet getCourse() {

        String sql = "select course.name "
                + "from classes,course "
                + "where classes.tea_id='" + id + "' "
                + "and course.id=classes.cour_id";

        SqlBean sqlbean = new SqlBean();

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

    /*

     *检查该教师是否已经注册 

     *返回类型：boolean

     @param id

     @return

     */
    public boolean hasLogin(String id) {   //检查该教师是否已经注册

        boolean f = true;

        String sql = "select id from teacher where id ='" + id + "'";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                f = false;
            } else {
                f = true;
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return f;

    }

    /*

     * 增加教师

     *返回类型：void

     */
    public void addTeacher() {

        String sql = "insert into teacher(id,name,title,password)  "
                + "values('" + id + "','" + name + "','" + title + "','" + password + "') ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 得到所有教师

     *返回类型：ResultSet

     @return

     */
    public ResultSet getAll() {

        String sql = "select * from teacher";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 更新教师信息

     *返回类型：void

     */
    public void update() {

        String sql = "update teacher set name='" + name + "', "
                + "title='" + title + "' ,password='" + password + "' "
                + "where id='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 删除教师信息

     *返回类型：int

     @param id

     @return

     */
    public int delete(String id) {

        int num = 0;

        String sql = "delete  from teacher where id ='" + id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeDelete(sql);

        return num;

    }

}
