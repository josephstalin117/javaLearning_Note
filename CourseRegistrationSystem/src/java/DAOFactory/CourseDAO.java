/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.util.List;

/**
 *
 * @author josephstalin
 */
public interface CourseDAO {

    public boolean insertCourse(Course s);

    public boolean deleteCourse(Course s);

    public Course findCourse(int cid);

    public List<Course> displayCourse();

    public boolean updateCourse(Course s);
}
