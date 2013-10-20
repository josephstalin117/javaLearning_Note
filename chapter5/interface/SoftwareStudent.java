package mystudent;


interface Student{
	public abstract void printInfo();
}


abstract class InfoStudent implements Student{
	String name;
	int age;
	String id;
	
	String getName(){
		return this.name;
	}
	
	public String toString(){
		return "student name is "+name +"age is "+age;
	}
	
	abstract void doPractice();
}

public class SoftwareStudent extends InfoStudent{
	public void doPractice(){
		System.out.println("hehe~");
	}
	public void printInfo(){
		System.out.println(this.toString());
	}
}