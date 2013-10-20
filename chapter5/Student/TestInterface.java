
	
public abstract interface Student{
	public void printInfo();
}
abstract class InfoStudent implements Student{
	int Id;
	char name;
	
	abstract doPractice();
}
