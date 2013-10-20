import java.util.*;

public class StudentVector
{
	public static void main(String args[])
	{
		String s;
		//int k;
		
		Student s1 = new Student("01","wxh",30);
		Student s2 = new Student("02","kzh",31);
		Student s3 = new Student("03","nlq",32);
		
		Teacher t1 = new Teacher("mqj",50);
		
		Vector myVector = new Vector();
		myVector.addElement(s1);
		myVector.addElement(s2);
		myVector.addElement(s3);
		
		myVector.insertElementAt(t1,0);
				
		for(int i = 0; i<myVector.size();i++)
		{
			 System.out.println(myVector.elementAt(i));
		}		
		
		System.out.print("请输入要查找的姓名：");
		Scanner scan = new Scanner(System.in);
		s = scan.nextLine();
		//k = scan.nextInt();
		
		for(int i = 0; i<myVector.size();i++)
		{
			if (myVector.elementAt(i) instanceof Student)
			{
				Student ss = (Student)myVector.elementAt(i);
				if (ss.name.equals(s))
					System.out.println(myVector.elementAt(i));
				}
			if (myVector.elementAt(i) instanceof Teacher)
			{
				//Student ss = (Student)myVector.elementAt(i);
				if (((Teacher)myVector.elementAt(i)).name.equals(s))
					System.out.println(myVector.elementAt(i));
				}
			
			}
		
		}
	}

class Student
{
	String id;
	String name;
	int age;
	
	Student(String i,String n,int a )
	{
		id = i;
		name = n;
		age = a;
		}
	
	public String toString()
	{
		return "学生学号："+id+"，姓名："+name+"，年龄："+age;
		}
	
}

class Teacher
{
	String name;
	int age;
	
	Teacher(String n, int a)
	{
		name = n;
		age = a;
		}
	
	public String toString()
	{
		return "教师姓名："+name+"，年龄："+age;
		}
	}