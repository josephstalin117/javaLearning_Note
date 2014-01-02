/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminServlet;

import DAOFactory.Admin;
import DAOFactory.AdminDAO;
import DAOFactory.Course;
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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author josephstalin
 */
public class AdminService {

    public static void main(String args[]) {
        List<Student> list = displayStudent();
        for (Iterator<Student> iter = list.iterator(); iter.hasNext();) {
            Student s = iter.next();
            System.out.println(s.getSname());
        }
    }

    public static List<Student> displayStudent() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        List<Student> stu = stuDAO.displayStudent();

        return stu;
    }

    public static List<Teacher> displayTeacher() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

        List<Teacher> tea = teaDAO.displayTeacher();

        return tea;
    }

    public static List<Course> displayCourse() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        CourseDAO couDAO = cloudFactory.getCourseDAO();

        List<Course> cou = couDAO.displayCourse();

        return cou;
    }

    public static List<Model> displayModel() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        ModelDAO modDAO = cloudFactory.getModelDAO();

        List<Model> mod = modDAO.displayModel();

        return mod;
    }

    public static List<Plan> displayPlan() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        PlanDAO plaDAO = cloudFactory.getPlanDAO();

        List<Plan> pla = plaDAO.displayPlan();

        return pla;
    }

}
