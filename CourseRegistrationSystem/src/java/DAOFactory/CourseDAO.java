/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import com.sun.rowset.CachedRowSetImpl;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author josephstalin
 */
public interface CourseDAO {

    public boolean insertCourse(Course s);

    public boolean deleteCourse(Course s);

    public Course findCourse(int cid);

    public List<Course> displayCourse();

    public CachedRowSet displayChooseCourse(String sid);

    public boolean enroll(String sid, String pid);

    public boolean updateCourse(Course s);
}
