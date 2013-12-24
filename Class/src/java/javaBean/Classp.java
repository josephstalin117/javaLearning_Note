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
public class Classp {
    /*

     * 通过get(),set()方法来得到班级信息

     */

    private String id;

    private String cour_id;

    private String tea_id;

    private String room_id;

    private String cour_time;

    public String getId() {

        return id;

    }

    public void setId(String id) {

        this.id = id;

    }

    public String getCour_id() {

        return cour_id;

    }

    public void setCour_id(String cour_id) {

        this.cour_id = cour_id;

    }

    public String getTea_id() {

        return tea_id;

    }

    public void setTea_id(String tea_id) {

        this.tea_id = tea_id;

    }

    public String getRoom_id() {

        return room_id;

    }

    public void setRoom_id(String room_id) {

        this.room_id = room_id;

    }

    public String getCour_time() {

        return cour_time;

    }

    public void setCour_time(String time) {

        this.cour_time = time;

    }

    /*

     * 得到所有教师信息

     *返回类型：ResultSet

     @return

     */
    public ResultSet getTeachers() {

        String sql = "select id,name from teacher  ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 得到所有课程信息

     *返回类型：ResultSet

     @return

     */
    public ResultSet getCourses() {

        String sql = "select id,name from course  ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 得到所有班级、教室信息

     *返回类型：boolean

     @param id

     @return

     */
    public boolean hasLogin(String id) {

        boolean f = false;

        String sql = "select id from classes where id ='" + id + "'";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                f = true;
            } else {
                f = false;
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return f;

    }

    /*

     * 判断该教师当前时间是否已经安排有课

     *返回类型：String

     @param tea_id

     @param cour_time

     @return

     */
    public String hasMoreclass(String tea_id, String cour_time) {   //检查教师是否同一时间上两门课程

        String temp = "";

        String sql = "select id from classes  "
                + "where tea_id='" + tea_id + "' and cour_time='" + cour_time + "'   ";

        SqlBean db = new SqlBean();

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                temp = rs.getString("id");
            } else {
                temp = "no";
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return temp;

    }

    /*

     * 根据传入的参数来增加班级信息

     *返回类型：void

     */
    public void addClass() {

        String sql = "insert into classes(id,tea_id,cour_id,room_id,cour_time)  "
                + "values('" + id + "','" + tea_id + "','" + cour_id + "','" + room_id + "','" + cour_time + "') ";

        try {

            SqlBean db = new SqlBean();

            db.executeInsert(sql);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

    }

    /*

     * 更新班级信息

     *返回类型：void

     @param id

     @param tea_id

     @param cour_id

     @param room_id

     @param cour_time

     */
    public void updateClass(String id, String tea_id, String cour_id,
            String room_id, String cour_time) {

        String sql = "update classes "
                + " set tea_id='" + tea_id + "',cour_id='" + cour_id + "',"
                + "room_id='" + room_id + "',cour_time='" + cour_time + "'  "
                + " where id='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 更新班级信息

     *返回类型：void

     @param id

     @param cour_id

     @param room_id

     */
    public void updateClass(String id, String cour_id,
            String room_id) {

        String sql = "update classes "
                + " set cour_id='" + cour_id + "',"
                + "room_id='" + room_id + "' "
                + " where id='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 删除班级信息

     *返回类型：int

     @param id

     @return

     */
    public int deleteClass(String id) {

        int num = 0;

        String sql = "delete  from classes where id ='" + id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeDelete(sql);

        return num;

    }

    /*

     * 根据班级表，课程表，教师表进行关联来得到所有班级信息

     *返回类型：ResultSet

     @return

     */
    public ResultSet getClasses() {

        String sql = "select classes.id,tea_id,cour_id,room_id,cour_time, "
                + "course.name as cour_name,teacher.name as tea_name "
                + "from classes ,course,teacher  "
                + "where classes.cour_id=course.id "
                + "and classes.tea_id=teacher.id ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

}
