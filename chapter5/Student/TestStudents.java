import java.util.Scanner;


//import java.util.*;
public class TestStudents{
	
	public static void main(String args[]){
		
		
		Students st=new Students("01",2,"zhang",'ÄÐ',22);
		
		System.out.println(st.toString());

	}
}


class Students{
	
 	String sId;
 	int cId;
 	String sName;
 	char sGender;
	int sAge;
	
	Students(String id,int cid,String name,char gender,int age){
		this.sId=id;
		this.cId=cid;
		this.sName=name;
		this.sGender=gender;
		this.sAge=age;
	}
	
	public String getSId(){
		return this.sId;
	}
	
	public int getCId(){
		return this.cId;
	}
	public String getSName(){
		return this.sName;
	}
	public char getSGender(){
		return this.sGender;
	}
	public int getSAge(){
		return this.sAge;
	}
	
	public void setSAge(int age){
		
	}
	


	
	public String toString(){
		
		return "studentid is"+sId+"class is"+cId+"student name is "+sName;
	}
	
	
}

class CollegeStudents extends Students{
	
	private String company;
	private String major;
	
	CollegeStudents(String id,int cid,String name,char gender,int age,String practiceCompany,String major){
		/*this.sId=id;
		this.cId=cid;
		this.sName=name;
		this.sGender=gender;
		this.sAge=age;
		this.company=com;
		this.major=major;*/
		super(id,clsId,gender,name,age);
		this.practiceCompany=practiceCompany;
		this.major=major;
	}
	public getMajor(){
		return this.major;
	} 
	public getCompany(){
		return this.company;
	}
}