package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试Dao类
 * 
 * @author josephstalin
 * 
 */
public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 实例化员工类
		PersonDaoJdbc pdj = new PersonDaoJdbc();
		Person p = pdj.findPerson("1");
		System.out.println(p);

		// 员工离职
		if (pdj.invalidPerson(p)) {
			System.out.println("offline");
		}
		p = pdj.findPerson("1");
		System.out.println(p);

		// 新增员工
		Person pp = new Person();
		pp.setUsername("林永泽");
		pp.setBirthday(new java.util.Date());     
		pp.setState(1);
		Person hehe = pdj.newPerson(pp);

		// 删除员工
		Person ppp = pdj.findPerson("3");
		System.out.println(ppp);
		if (pdj.deletePerson(ppp)) {
			System.out.println("delect person");
		}

		// 修改姓名
		Person pppp = pdj.findPerson("4");
		if (pdj.changeName(pppp, "hehe")) {
			System.out.print(pppp);
		}

		// 列出离职员工信息
		List<Person> list = pdj.findState("0");
		for (Iterator<Person> iter = list.iterator(); iter.hasNext();) {
			Person s = iter.next();
			System.out.println(s);
		}

		// factory
		 PersonDao pd = DaoFactory.getInstance().getPersonDao();
		 Person p1 = pd.findPerson("1");
		 System.out.println(p1);
	}
}
