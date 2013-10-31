import java.util.*;

public class Test {
	public static void main(String args[]) {
		while (true) {
			System.out.print("please insert the date");
			Scanner sc = new Scanner(System.in);
			int y = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			System.out.print("this day is " + weekday(y, m, d));
		}
	}

	public static boolean isLeapYear(int year) {
		boolean flag = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static String weekday(int year,int month,int day){
		long amount =0;
		for(int i=1;i<year;i++){
			if(isLeapYear(i)){
				amount++;
			}
		}
		amount+=365*(year-1);
		for(int i=1;i<month;i++){
			amount+=daysofMonth(year,i);
		}
		
		amount+=day;
		int week=(int)(amount%7);
		String w="";
		switch(week){
		case 0:w="sunday";break;
		case 1:w="monday";break;
		case 2:w="tuesday";break; 
		case 3:w="wednesday";break; 
		case 4:w="thursday";break; 
		case 5:w="friday";break; 
		case 6:w="saturday";break; 
		
		
		
		}
		return w;
		
	}

	private static int daysofMonth(int year,int month){
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:return 31;
		case 4:
		case 6:
		case 9:
		case 11:return 30;
		case 2:if(isLeapYear(year)){
					return 29;
				}else{
					return 28;
				}
		default :return 0;
		}
	}
}