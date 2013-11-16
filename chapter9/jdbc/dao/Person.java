package dao;

import java.util.Date;

/**
 * @author josephstalin 实体类：数据库表的面向对象表示
 */
public class Person {
	private int id;
	private String username;
	private Date birthday;
	private int state;

	/**
	 * 获取id
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设定用户名
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取生日
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 设定生日
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取离职状态
	 * @return
	 */
	public int getState() {
		return state;
	}

	/**
	 * 设定状态
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * 重写toString方法
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", birthday="
				+ birthday + ", state=" + state + "]";
	}

}
