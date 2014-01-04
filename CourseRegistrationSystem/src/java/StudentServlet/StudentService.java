/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentServlet;

import DAOFactory.Course;
import DAOFactory.CourseDAO;
import DAOFactory.DAOFactory;
import java.util.List;

/**
 *
 * @author josephstalin
 */
public class StudentService {

    public static List<Course> displayChooseCourse() {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        CourseDAO couDAO = cloudFactory.getCourseDAO();

        List<Course> cou = couDAO.displayCourse();

        return cou;
    }

}
