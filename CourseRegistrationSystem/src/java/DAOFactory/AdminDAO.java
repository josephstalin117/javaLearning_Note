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
public interface AdminDAO {

    public boolean insertAdmin(Admin a);

    public boolean deleteAdmin(Admin a);

    public Admin findAdmin(int uuid);

    public boolean updateAdmin(Admin a);
}
