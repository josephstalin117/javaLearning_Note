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
public abstract class DAOFactory {

    // There will be a method for each DAO that can be 
    // created. The concrete factories will have to 
    // implement these methods.
    public abstract StudentDAO getStudentDAO();

    public abstract TeacherDAO getTeacherDAO();

    public abstract AdminDAO getAdminDAO();

    public abstract CourseDAO getCourseDAO();

    public abstract UserDAO getUserDAO();

    public abstract PlanDAO getPlanDAO();
    
    public abstract ModelDAO getModelDAO();

    public static DAOFactory getDAOFactory() {
        return new CloudDAOFactory();
    }
}
