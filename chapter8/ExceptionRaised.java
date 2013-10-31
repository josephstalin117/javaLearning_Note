public class ExceptionRaised {
    public  ExceptionRaised() {
     }
    public int calculate( int operand1, int operand2) {
        int result = operand1 / operand2;     
        return result;
   }
   public static void main(String[] args) {
      ExceptionRaised obj = new ExceptionRaised();
         int result = obj.calculate(9, 0);
         System.out.println(result);
   }
}
