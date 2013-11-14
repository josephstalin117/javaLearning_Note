package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static PersonDao personDao = null;
	private static DaoFactory instance = new DaoFactory(); // 单例

	private DaoFactory() {// 单例
		try {
			Properties p = new Properties();// 工厂
			InputStream is = new FileInputStream(new File(
					"daoconfig.properties"));
			p.load(is);
			String sc = p.getProperty("PersonDaoClass");
			Class c = Class.forName(sc);
			personDao = (PersonDao) c.newInstance();// 产生具体对象
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public static PersonDao getPersonDao() {
		return personDao;
	}

}
