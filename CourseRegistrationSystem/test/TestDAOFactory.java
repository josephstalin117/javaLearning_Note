/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAOFactory.Admin;
import DAOFactory.AdminDAO;
import DAOFactory.CourseDAO;
import DAOFactory.DAOFactory;
import DAOFactory.Model;
import DAOFactory.ModelDAO;
import DAOFactory.Plan;
import DAOFactory.PlanDAO;
import DAOFactory.Student;
import DAOFactory.StudentDAO;
import DAOFactory.Teacher;
import DAOFactory.TeacherDAO;
import DAOFactory.User;
import DAOFactory.UserDAO;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author josephstalin
 */
public class TestDAOFactory {

    public static void main(String args[]) throws SQLException {
        //测试工厂
//        testFactory();
        //测试新增
//        insertStudent();
        //测试删除
//        deleteStudent();
        //测试增加用户
//        insertUser();
        //更新学生
//        updateStudent();
        //更新老师
//        updateTeacher();
        //更新老师
//        updateUser();
        //增加管理员
//        insertAmdin();
        //增加课程计划
//        insertPlan();
        //增加选课
//        insertModel();
        //测试教师查找
//        loginTeacher();
        //显示课程
//        displayChooseCourse();
//        选课
//        testEnroll();

        //查看学分
//        testDisplayChooseCourse();
        //老师教课
//        getClasst();
        //课程
        getClasstw();
    }

    public static void testFactory() {
        // create the required DAO Factory
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        // Create a DAO
        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        // Find a customer object. Get the Transfer Object.
        Student stu = stuDAO.findStudent(1);

        System.err.println((stu.getBirthday()));

    }

    public static void loginTeacher() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

        Teacher tea = teaDAO.loginTeacher(1);

        System.err.println(tea.getBirthday());
    }

    public static void insertStudent() {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        Student stu = stuDAO.findStudent(2);
        java.util.Date birthday = new java.util.Date();

        stu.setUuid(1);
        stu.setSid(1);
        stu.setSname("josephstalin");
        stu.setSex(1);
        stu.setDid(2);
        stu.setSpid(2);
        stu.setBirthday(new java.util.Date());
        stu.setEnrollment(new java.util.Date());

        stuDAO.insertStudent(stu);

    }

    public static void deleteStudent() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        Student stu = stuDAO.findStudent(2);

        stuDAO.deleteStudent(stu);
    }

    public static void updateStudent() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        Student stu = stuDAO.findStudent(1);

        stu.setSname("feifei");

        stuDAO.updateStudent(stu);
    }

    public static void updateUser() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        UserDAO userDAO = cloudFactory.getUserDAO();

        User user = userDAO.findUser(5);

        user.setNackname("feifei");

        userDAO.updateUser(user);
    }

    public static void insertUser() {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        UserDAO userDAO = cloudFactory.getUserDAO();
        StudentDAO stuDAO = cloudFactory.getStudentDAO();
        TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

        User user = new User();

        user.setNackname("testUser");
        user.setRole(2);
        user.setEmail("lyz2356002@gmail.com");
        user.setPassword("123456");

        User user2 = userDAO.insertUser(user);
        if (user2.getRole() == 1) {
            Student stu = new Student();

            stu.setUuid(user2.getUuid());
            stu.setSid(4);
            stu.setSname("josephstalin");
            stu.setSex(1);
            stu.setDid(2);
            stu.setSpid(2);
            stu.setBirthday(new java.util.Date());
            stu.setEnrollment(new java.util.Date());

            stuDAO.insertStudent(stu);
        }
        if (user2.getRole() == 2) {
            Teacher tea = new Teacher();

            tea.setUuid(user2.getUuid());
            tea.setTid(2);
            tea.setSex(1);
            tea.setTname("ningdaye");
            tea.setSex(1);
            tea.setBirthday(new java.util.Date());
            tea.setDid(2);
            tea.setSpid(2);
            tea.setProid(2);

            teaDAO.insertTeacher(tea);
        }

    }

    public static void insertAmdin() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        AdminDAO admDAO = cloudFactory.getAdminDAO();

        Admin adm = new Admin();

        adm = admDAO.findAdmin(110);

        admDAO.deleteAdmin(adm);
    }

    public static void insertPlan() {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        PlanDAO plaDAO = cloudFactory.getPlanDAO();

        Plan pla = new Plan();

        pla.setPid(1);
        pla.setCid(1);
        pla.setTid(1);
        pla.setCapacity(60);
        pla.setLocation(6814);
        pla.setPrepare(0);
        pla.setClasstime(116378);

//        plaDAO.insertPlan(pla);
        pla = plaDAO.findPlan(1);

        System.err.println(pla.getCid());

        plaDAO.deletePlan(pla);
    }

    public static void insertModel() {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        ModelDAO modDAO = cloudFactory.getModelDAO();

        Model mod = new Model();

        mod.setMid(1);
        mod.setSid(1);
        mod.setCid(1);
        mod.setAccept(1);
        mod.setScore(60);

//        modDAO.insertModel(mod);
        mod = modDAO.findModel(2);

        System.err.println(mod.getMid());

//        mod.setCid(2);
//        modDAO.updateModel(mod);
//        modDAO.deleteModel(mod);
    }

    public static void displayChooseCourse() throws SQLException {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        CourseDAO couDAO = cloudFactory.getCourseDAO();

        CachedRowSet cr = couDAO.displayChooseCourse("1");

        if (cr.next()) {
            int id = cr.getInt("cid");

            String name = cr.getString("cname");

            String class_id = cr.getString("pid");

            int room_id = cr.getInt("location");

            int cour_time = cr.getInt("classtime");

            String tea_name = cr.getString("tname");

            System.out.print(id);

            System.out.print(name);

        }
    }

    public static void testEnroll() throws SQLException {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        CourseDAO couDAO = cloudFactory.getCourseDAO();

        couDAO.enroll("3", "11");

    }

    public static void testDisplayChooseCourse() throws SQLException {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        ModelDAO modDAO = cloudFactory.getModelDAO();

        CachedRowSet cr = modDAO.findStudentModel("1");

        if (cr.next()) {
            int score = cr.getInt("score");

            String cname = cr.getString("cname");

            String credit = cr.getString("credit");

            System.out.print(score);

            System.out.print(credit);

        }
    }

    public static void getClasst() throws SQLException {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

        CachedRowSet cr = teaDAO.getClass("1");

        if (cr.next()) {
            int pid = cr.getInt("pid");

            String cname = cr.getString("cname");

            System.out.print(pid);

            System.out.print(cname);

        }
    }

    public static void getClasstw() throws SQLException {

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

        CachedRowSet cr = teaDAO.getStudents("1");

        if (cr.next()) {
            int pid = cr.getInt("sid");

            String sname = cr.getString("sname");

            System.out.print(pid);

            System.out.print(sname);

        }
    }
}
