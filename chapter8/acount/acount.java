import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class acount {
	public static void main(String[] args) {
		testAcount hehe=new testAcount();
		hehe.examine("hehe","wakaka");
	}
}

class testAcount {
	HashMap<String,String> userMap=new HashMap<String,String>();
	userMap.put("hehe","wakaka");
	void examine(String user1,String pwd1){
		if(pwd==userMap.get("hehe")){
			System.out.println("success~");
		}else{
			System.out.println("user error~");
		}
	}
}