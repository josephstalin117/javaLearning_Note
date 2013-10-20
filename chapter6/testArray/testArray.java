import java.util.*;

public class testArray{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		//allow user input
		
		System.out.println("How many number do want to enter");
		int num=input.nextInt();
		
		int array[]=new int[num];
		System.out.println("Enter the "+ num+"number now.");
		
		for(int i=0;i<array.length,i++){
			array[i]=input.nextInt();
		}
		
		System.out.println("There are the numbers you have entered");
		printArray(array);
		
		max=min=sum=a[0];
		
		
		public static void printArray(int arr[]){
			int n=arr.length;
			
			for(int i=0;i<n;i++){
				System.out.print(arr[i]+" ");
			}
		}
	}
}
