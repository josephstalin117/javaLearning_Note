import java.io.*;

public class InAndOut
{
		public static void main(String args[])
		{
			try
			{
				BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
				System.out.print("请输入一个整数：");
				int i = Integer.parseInt(br.readLine());
				System.out.print("您输入的整数是"+i);
			}
			catch(IOException e)
			{
				System.err.println(e.toString());
			}
		}
}
