import java.util.*; 
 
 public class TestRectangle{
 	public static void main(String args[]){
 		int a,b;
 		
 		Scanner scan = new Scanner(System.in);
 		System.out.print("请输入正方形的边长:");
 		a = scan.nextInt();
 		//System.out.print("请输入矩形宽度:");
 		//b = scan.nextInt();
 		Square s=new Square()
 		Rectangle rec = new Rectangle(5,6);
 		System.out.println(rec.getGrith());
 		System.out.println(rec.getArea());
 	}
 }
 

class Rectangle{
 	
 	int length;
 	int width;
 	
 	Rectangle(int len , int wid){
		length = len;
		width = wid;
	}
	
	int getGirth(){
		return (length+width)*2;
	}
	
	int getArea(){
		return (length*width);
	}
}

class Square extends Rectangle{
	Square(int side){
		super(side,side);
	}
	
	int getGirth(){
		return length*4;
	}
	
	int getArea(){
		return Math.pow(length,2);
	}	
}
