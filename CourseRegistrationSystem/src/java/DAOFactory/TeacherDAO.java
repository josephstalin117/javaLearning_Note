/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.util.List;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author josephstalin
 */
public interface TeacherDAO {

    public boolean insertTeacher(Teacher s);

    public boolean deleteTeacher(Teacher s);

    public Teacher findTeacher(int uuid);

    public List<Teacher> displayTeacher();

    public CachedRowSet getClass(String tid);

    public CachedRowSet getStudents(String class_id);

    public Teacher loginTeacher(int tid);

    public boolean updateTeacher(Teacher t);

}
