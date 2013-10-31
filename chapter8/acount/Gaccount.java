import java.util.HashMap;
import java.util.Scanner;

//根据用户名、密码，判断是否运行用户登录。
//要求：用户名，密码以map形式进行存储。

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Login> table = new HashMap<String, Login>();
		Login l1 = new Login("wyl", "123");
		Login l2 = new Login("tj", "123");
		Login l3 = new Login("ljy", "123");
		table.put(l1.username, l1);
		table.put(l2.username, l2);
		table.put(l3.username, l3);

		System.out.println("请输入用户名");
		Scanner sc1 = new Scanner(System.in);
		String s1 = sc1.next();

		if (table.containsKey(s1)) {//判断用户名
			System.out.println("请输入密码");
			Scanner sc2 = new Scanner(System.in);
			String s2 = sc2.next();
			if (table.get(s1).password.equals(s2))
				System.out.println("登陆成功");
			else
				System.out.println("登陆失败");
		} else
			System.out.println("无此用户名");
	}

}

class Login {
	String username;
	String password;

	Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
}