package rollName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class randomRoll {
	
	public static void main(String arg[]) {
		add(1);
		add(2);
		add(3);
		List<Integer> testArray = new ArrayList<Integer>();
		
		testArray=show();
		Iterator<Integer> it = testArray.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
	static List<Integer> historyArray = new ArrayList<Integer>();
	
	
	/**
	 * 加入新角色
	 * @param sessionHistory
	 */
	public static void add(int sessionHistory){
		historyArray.add(sessionHistory);
	}
	
	/**
	 * 返回数组
	 * @return
	 */
	public static List show(){
		return historyArray;
	}
	
	/**
	 * 判断方法
	 * @param sessionMethod
	 * @return
	 */
	public static int goTo(String sessionMethod){
		if(sessionMethod.equals("simple")){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 简单随机抽样
	 * @param num
	 * @return
	 */
	public static int simpleSampling(String num) {
		int number = Integer.parseInt(num);
		int n = (int) (Math.random() * number) + 1;
		return n;
	}
	/**
	 * 分层抽样
	 * @param num
	 * @param cla
	 * @return
	 */
	public static int stratifiedSampling(String num,String num2){
		int number=Integer.parseInt(num);
		int number2=Integer.parseInt(num2);
		int sum=number2+number;
		int n=(int)(Math.random()*sum)+1;
		return n;
	}
	/**
	 * 方便抽样
	 * @param num
	 * @param spe
	 * @return
	 */
	public static int convenienceSampling(String num,String spe){
		return 0;
	}
	

	

}
