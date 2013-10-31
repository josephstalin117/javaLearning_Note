public class TestMultiException
{
  public static void main(String[] args)
  {
    TestArray a = new TestArray();
    try{
       a.te();
       }
    catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("数组下标越界");
    }
    catch(ArithmeticException e)
    {
      System.out.println("分母为0，运算错误");
      e.printStackTrace();    
    }
  }
}
class TestArray
{
  private int i;
  private int[] array={1,2,3,4,5};
  void te()
  {
    while(true)
    {
      i = (int) (Math.random()*10);
      System.out.println("以随机数为分母的除法的结果是："+100/i);
      System.out.println("数组array["+i+"]的值为"+array[i]);
    }
  }
}