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
public class CloudModelDAO implements ModelDAO {

    public boolean insertModel(Model m) {
        return true;
    }

    public boolean deleteModel(Model m) {
        return true;
    }

    public Model findModel(int mid) {
        Model m = new Model();
        return m;
    }

    public boolean updateModel(Model m) {
        return true;
    }
}
