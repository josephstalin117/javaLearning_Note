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

	/**
	 * 删除员工信息
	 * @param p
	 * @return
	 */
	public boolean deletePerson(Person p);

	/**
	 * 添加员工信息
	 * @param p
	 * @return
	 */
	public Person newPerson(Person p);


	/**
	 * 修改员工姓名
	 * @param p
	 * @param hehename
	 * @return
	 */
	boolean changeName(Person p, String hehename);
}
