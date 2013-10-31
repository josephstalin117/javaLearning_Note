import java.io.*;

public class TestThread
{
	public static void main(String args[])
	{
		// 将线程置于新建状态
		PrimeThread subthread=new PrimeThread(10);
		// 将线程置于就绪状态
		subthread.start();
		while(subthread.isAlive() && subthread.readyToGoOn())
		{
			System.out.println("主线程运行中...\n"); 		
			try
			{
				// 将线程置于阻塞状态
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				return;
			}
		}
		
		System.out.println("主线程运行结束...");
	}
}

class PrimeThread extends Thread
{
	boolean bContinue=true;
	int CircleNum;

	PrimeThread(int Num)
	{
		CircleNum=Num;
	}

	boolean readyToGoOn()
	{
		return bContinue;
	}

	public void run()
	{
		int number=3;
		boolean flag=true;

		while(true)
		{
			for(int i=2;i<number;i++)
			{
				if(number%i==0)
				{
					flag=false;
				}
			}
			if(flag)
			{
				System.out.println(number+"是素数\n");
			}
			else
			{
				System.out.println(number+"不是素数\n");
			}
			
			number++;
			flag=true;
			
			try
			{
				sleep(10);
			}
			catch(InterruptedException e)
			{
				return;
			}
			
			if(number>CircleNum)
			{
				bContinue=false;
				return;
			}
		}
	}
}