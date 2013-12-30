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
public interface PlanDAO {

    public boolean insertPlan(Plan p);

    public boolean deletePlan(Plan p);

    public Plan findPlan(int pid);

    public boolean updatePlan(Plan p);
}
