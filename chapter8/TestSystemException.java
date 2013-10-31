public class TestSystemException
{
  public static void main(String args[])
  {
	int a=0,b=5;
	System.out.println(b/a);	//以零为除数，引发系统定义的算术异常
  }
}
