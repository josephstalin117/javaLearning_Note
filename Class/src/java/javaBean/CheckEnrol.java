package javaBean;

import java.sql.*;

public class CheckEnrol {

    /**
     *
     * 选课
     *
     */
    public int enrol(String class_id, String stu_id) {
        int num = 0;
        String sql = "insert into enrol(stu_id,class_id) " + " VALUES('"
                + stu_id + "','" + class_id + "')   ";
        SqlBean db = new SqlBean();
        num = db.executeInsert(sql);
        return num;
    }

    public boolean hasPassPrepare(String prepare) {
        // TODO Auto-generated method stub
        boolean f = false;
        int a = 0;
        String temp = null;
        String sql = "select score " + "from enrol,classes ,course "
                + "where enrol.class_id=classes.id "
                + "and classes.cour_id=course.id " + "and course.id='"
                + prepare + "' ";
        SqlBean db = new SqlBean();
        try {
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                temp = rs.getString("score");
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        if (temp == null || temp.equals("")) {
            return false;
        } else {
            try {
                a = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.print(e.toString());
            }
            if (a >= 60) {
                f = true;
            }
        }
        return f;
    }

    public String getTotalMark(String id) {
        String temp = "0";
        String sql = "select mark from student where id='" + id + "'  ";
        SqlBean db = new SqlBean();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                temp = temp + rs.getString("mark");
            }
        } catch (Exception e) {
        }
        return temp;
    }

    public boolean hasLogin(String stu_id, String cour_id) { // 该学生是否已经注册该课程
        boolean f = true;
        String sql = "select stu_id,class_id " + "from enrol,classes "
                + "where stu_id='" + stu_id + "' "
                + "and classes.id=enrol.class_id " + "and cour_id='" + cour_id
                + "' ";
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

    public int updatestu(String pw, String id, String e_mail, String tel) {
        int num = 0;

        String sql = "update student set password='" + pw + "',e_mail='"
                + e_mail + "',tel='" + tel + "'  where id='" + id + "'  ";
        SqlBean db = new SqlBean();
        num = db.executeInsert(sql);
        return num;
    }

    /**
     *
     * 选择课程
     *
     */
    public ResultSet getCourse(String id) {

        String sql = "select DISTINCT course.id,course.name,course.prepare,course.dep , "
                + "classes.id as class_id,classes.room_id,classes.cour_time,teacher.name as tea_name "
                + "from course,classes,teacher "
                + "where classes.cour_id=course.id  "
                + "and classes.tea_id=teacher.id "
                + "and classes.id in "
                + "( select classes.id from classes,student,course  "
                + "where classes.id not in( select class_id from enrol where stu_id='" + id + "') "
                + "and ( student.department=course.dep or course.dep ='public')  "
                + "and course.id=classes.cour_id and student.id='" + id + "') ";

        SqlBean sqlbean = new SqlBean();

        ResultSet rs = sqlbean.executeQuery(sql);

        return rs;

    }

}
