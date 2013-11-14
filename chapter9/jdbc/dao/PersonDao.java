package dao;

/**
 * @author josephstalin 定义业务逻辑与数据库之间的接口
 */
public interface PersonDao {
	/**
	 * @param id
	 * @return 根据工号查找个人信息
	 */
	public Person findPerson(String id);

	/**
	 * @param p
	 * @return 办理离职（仅仅将状态置为离职状态）
	 */
	public boolean invalidPerson(Person p);

	public boolean deletePerson(Person p);

	public boolean newPerson(Person p);


	boolean changeName(Person p, String hehename);
}
