import java.io.*;

public class showCharValue{
	public static void main(String arg[]){
		char ch=0,minchar=256;
		
		try{
			System.out.println("please insert a char,use '#' to end this line");
				do{
					ch=(char)System.in.read();
					//System.out.println("char"+ch+" integer is "+(int)ch);
					if(ch<minchar && ch!='#'){
						minchar=ch;
					}
					System.in.skip(2);
				}while(ch!='#');
			
				
		}
		catch(IOException e){
			System.err.println(e.toString());
		}
		System.out.println("the minchar is"+minchar);
	}
}