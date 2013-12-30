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
public interface UserDAO {

    public User insertUser(User u);

    public boolean deleteUser(User u);

    public User findUser(int uuid);

    public boolean updateUser(User u);
}
