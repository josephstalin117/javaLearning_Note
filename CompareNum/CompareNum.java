import java.io.IOException;

public class CompareNum {
	public static void main(String args[]){
		int count=1,n,num,max=0,min=0;
		try{
		for(n=0;n<10;n++){
			num=(int)System.in.read();
			System.in.skip(2);
			if(num>max){
				max=num;
			}elseif(num<min){
				min=max;
			}
		}
		catch(IOException e){
			System.err.printli(e.toString());
		}
			
		}
	}
}