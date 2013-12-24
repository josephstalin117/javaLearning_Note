/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

/**
 *
 * @author josephstalin
 */
public interface StudentDAO {

    public boolean insertStudent(Student s);

    public boolean deleteStudent(Student s);

    public Student findStudent(int uuid);

    public boolean updateStudent(Student s);
    
}
