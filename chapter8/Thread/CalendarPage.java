import java.util.*; 
import java.text.*;

class CalendarPage
{ 
   public static void main(String args[ ])
   { 

     Calendar c=Calendar.getInstance();
	 // 
     c.set(2012,8,1); 
	 System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));

	 //0代表星期日，1代表星期1，2代表星期2，以此类推
     int week=c.get(Calendar.DAY_OF_WEEK)-1;
	System.out.println(week);

     int a[]=new int[week+31];            //存放号码的一维数组。
     for(int i=0;i<week;i++)
       {
           a[i]=0;
       }
     for(int i=week,n=1;i<week+31;i++)
       {        
          a[i]=n ;
           n++;
       }
	   
	System.out.printf("%4c%4c%4c%4c%4c%4c%4c\n",'日','一','二', '三','四','五','六');
    for(int i=0;i<a.length;i++)
       {  if(i%7==0&&i!=0)
                System.out.printf("\n");
          System.out.printf("%5d",a[i]);      
       } 
   } 
}
