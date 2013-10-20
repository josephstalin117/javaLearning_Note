import java.util.*;

public class TestBubbleSort{
	static int[] a = new int[10];
	
	public static void main(String args[]){
		int[] array_int = {4,-5,23,7,0}
		Arrays.sort(array_int);
		for(int i=0;i<array_int.length;i++){
			System.out.print(array_int[i])
		}
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

