import java.util.ArrayList;
import java.util.Iterator;


public class TestListObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al=new ArrayList();
		
		//增加元素
		al.add("nlq");
		al.add(1);
		al.add(new Point(0,1));
		
		//更新元素
		Point p=(Point)al.get(2);
		System.out.println(p.p());
		al.set(2, new Point(2,3));
		p=(Point)al.get(2);
		System.out.println(p.p());
		
		//遍历元素，查询
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
		//删除元素
		al.remove(0);
		
		//遍历元素，查询
		Iterator iter=al.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
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
