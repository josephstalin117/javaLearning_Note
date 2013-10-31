import java.util.Iterator;
import java.util.LinkedList;


public class TestLinkedListParam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Point> al=new LinkedList<Point>();
		
		al.add(new Point(0,1));
		al.add(new Point(1,2));
		al.add(new Point(2,3));
		
	
/*		//遍历元素，查询
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
*/		
		//遍历元素，查询
		Iterator<Point> iter=al.iterator();
		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			Point p=iter.next();
			System.out.println(p.p());
		}

	}	
}

class Point
{
	int x;
	int y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	String p()
	{
		return x+":"+y;
	}
}
