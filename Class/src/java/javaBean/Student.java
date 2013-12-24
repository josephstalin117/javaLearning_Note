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
public class Student {

    private String name;

    private String password;

    private String id;

    private String jiguan;

    private String sex;

    private String dep;

    public void setDep(String s) {

        dep = s;

    }

    public String getDep() {

        return dep;

    }

    public void setSex(String s) {

        sex = s;

    }

    public String getSex() {

        return sex;

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

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getJiguan() {

        return jiguan;

    }

    public void setJiguan(String jiguan) {

        this.jiguan = jiguan;

    }

    /*

     * 检查该学生是否已经注册 返回类型：boolean @param id @return

     */
    public boolean hasLogin(String id) { // 检查该学生是否已经注册

        boolean f = true;

        String sql = "select id from student where id ='" + id + "'";

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

     * 得到所有学生 返回类型：ResultSet @return

     */
    public ResultSet getStudent() {

        String sql = "select * from student   ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /*

     * 更新学生 返回类型：void

     */
    public void updateStudent() {

        String sql = "update student " + " set name='" + name + "',sex='" + sex
                + "',department='" + dep + "',       " + "password='" + password
                + "',jiguan='" + jiguan + "'  " + " where id='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

    /*

     * 删除学生 返回类型：void

     */
    public void deleteStudent() {

        String sql = "delete  from student where id ='" + id + "' ";

        SqlBean db = new SqlBean();

        db.executeDelete(sql);

    }

    /*

     * 删除学生 返回类型：int @param id @return

     */
    public int deleteStudent(String id) {

        int num = 0;

        String sql = "delete  from student where id ='" + id + "' ";

        SqlBean db = new SqlBean();

        num = db.executeDelete(sql);

        return num;

    }

    /*

     * 增加学生 返回类型：void

     */
    public void addStudent() {

        String sql = "insert into student(name,password,id,sex,department,jiguan)  "
                + "VALUES('"
                + name
                + "','"
                + password
                + "','"
                + id
                + "','"
                + sex + "','" + dep + "','" + jiguan + "')";

        SqlBean db = new SqlBean();

        db.executeInsert(sql);

    }

}
