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
public interface ModelDAO {

    public boolean insertModel(Model m);

    public boolean deleteModel(Model m);

    public Model findModel(int mid);

    public CachedRowSet findStudentModel(String sid);

    public List<Model> displayModel();

    public boolean updateModel(Model m);
}
