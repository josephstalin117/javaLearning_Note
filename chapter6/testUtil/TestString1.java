import java.util.*;

public class TestString1{
	
	public static void main(String args[]){
		boolean flag = true;
		
		Scaner scan = new Scanner(System.in);
		System.out.print("please input a string");
		String s = scan.nextLine();
		
		for(int i = 0;i<s.length()/2;i++){
			if(s.charAt(i) !== s.charAt(s.length()-(i+1))){
				flag = false;
			}
		}
		if(flag){
			System.out.println("yes");
			
		}else{
			System.out.println("no");
		}
		
	}
}