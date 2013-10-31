import java.util.HashMap;


public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contact one1=new Contact();
		one1.set("cellphone", "120120");
		one1.set("email", "nlq@126.com");
		one1.set("qq","110");
		
		System.out.println(one1);
		System.out.println(one1.get("qq"));

	}

}

class Contact
{
	HashMap<String,String> fields=new HashMap<String,String>();
	
	void set(String field,String value)
	{
		fields.put(field, value);
	}
	
	String get(String field)
	{
		return fields.get(field);
	}
	
	public String toString()
	{
		return fields.toString();
	}
}
