import java.util.*;

public class TestBubbleSort{
	static int[] a = new int[10];
	
	public static void main(String args[]){
		for(int i=0;i<10;i++){
			System.out.print("please insert the number");
			
		}
	}
	static void BubbleSort(){
		int pass,i,temp;
	
		for(pass = 0;pass < a.length;pass++){
			for(i=0;i<a.length-1-pass;i++){
				if(a[i]>a[i+1]){
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
	}
}

