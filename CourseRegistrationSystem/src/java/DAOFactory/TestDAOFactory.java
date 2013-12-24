/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.util.Date;

/**
 *
 * @author josephstalin
 */
public class TestDAOFactory {

    public static void main(String args[]) {
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

        user.setNackname("baileilei");
        user.setRole(2);
        user.setEmail("lyz2356002@gmail.com");
        user.setPassword("1234567");

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
            tea.setTid(1);
            tea.setSex(1);
            tea.setTname("ningdaye");
            tea.setSex(1);
            tea.setBirthday(new java.util.Date());
            tea.setDid(2);
            tea.setSpid(2);
            tea.setProid(2);

            teaDAO.inserTeacher(tea);
        }

    }
}
