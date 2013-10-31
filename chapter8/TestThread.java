public class TestThread
{
	public static void main(String args[])
	{
		/*
Test1£ºnew ThreadDemo().start();
		new ThreadDemo().start();
		new ThreadDemo().start();
		new ThreadDemo().start();	*/
		/*
Test2:ThreadDemo tt =new ThreadDemo();
	  tt.start();
	  tt.start();
	  tt.start();
	  tt.start();*/
	  ThreadDemo tt= new ThreadDemo();
	  new Thread(tt).start();
	  new Thread(tt).start();
	  new Thread(tt).start();
	  new Thread(tt).start();	  
		}
	}

class ThreadDemo implements Runnable //extends Thread ¡ª¡ªTest1,Test2
{
	int tickets = 100;
	public void run()
	{
		while(true)
		{
		   if(tickets>0)
		     System.out.println(Thread.currentThread().getName()+"is saling ticket"+tickets--);
		}
	}
	}