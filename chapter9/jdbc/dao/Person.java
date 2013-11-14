package dao;

import java.util.Date;

/**
 * @author josephstalin 实体类：数据库表的面向对象表示
 */
public class Person {
	private String id;
	private String username;
	private Date birthday;
	private int state;

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", birthday="
				+ birthday + ", state=" + state + "]";
	}

}
