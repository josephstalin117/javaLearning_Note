/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CloudServlet;

import DAOFactory.DAOFactory;
import DAOFactory.User;
import DAOFactory.UserDAO;

/**
 *
 * @author josephstalin
 */
public class UserService {

    public static String getNackname(int uuid) {
        //启动Cloud内核
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        UserDAO useDAO = cloudFactory.getUserDAO();

        User use = new User();

        use = useDAO.findUser(uuid);
        
        return use.getNackname();

    }
}
