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
public interface StudentDAO {

    public boolean insertStudent(Student s);

    public boolean deleteStudent(Student s);

    public Student findStudent(int uuid);
    
    public List<Student> displayStudent();
    
    public Student loginStudent(int sid);

    public boolean updateStudent(Student s);
    
    
    
}
