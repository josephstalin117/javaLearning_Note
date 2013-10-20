import java.util.Scanner;
import java.util.*;


//import java.util.*;
public class TestVector{
	
	public static void main(String args[]){
		
		String s;
		
		Students s1=new Students("01","zhang",22);
		Students s2=new Students("02","hehe",22);
		Students s3=new Students("03","wakaka",21);
		

		Teacher t1=new Teacher("mqj",50);
		
		Vector myVector =new Vector();
		
		myVector.addElement(s1);
		myVector.addElement(s2);
		myVector.addElement(s3);

		myVector.insertElementAt(t1,0);

		for(int i=0;i<myVector.size();i++){
			System.out.println(myVector.elementAt(i));
		}
		
		System.out.print("please insert your name");
		
		Scanner scan=new Scanner(System.in);
		s = scan.nextLine();
		
		for(int i=0;i<myVector.size();i++){
			if(myVector.elementAt(i) instanceof Students){
				Students ss = (Students)myVector.elementAt(i);
				if(ss.name.equals(s)){
					System.out.println(myVector.elementAt(i));
				}
			}
			if(myVector.elementAt(i) instanceof Teacher){
				Teacher kk = (Teacher)myVector.elementAt(i);
				if(kk.name.equals(s)){
					System.out.println(myVector.elementAt(i));
				}
			}
		}
		
		//System.out.println(st.toString());

	}
}


class Students{
	
 	String id;
 	String name;
	int age;
	
	Students(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	public String toString(){
		
		return "studentid is"+id+"student name is "+name;
	}
	
	
}


class Teacher{
	String name;
	int age;
	
	Teacher(String n,int a){
		name=n;
		age=a;
	}
	public String toString(){
		return name;
	//	return age;
	}
}
