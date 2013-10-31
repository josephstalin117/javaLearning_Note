import java.io.*;
public class TestBuffered
{  
   public static void main(String args[ ])
   { 
      File readFile=new File("Student.txt"),
           writeFile=new File("Hello.txt");
      try{
           FileReader  fr=new FileReader("Student.txt");
           BufferedReader br= new BufferedReader(fr);
           FileWriter  fw=new FileWriter("Hello.txt");
           BufferedWriter bw= new BufferedWriter(fw);
           String s=null;
           int i=0;
           while((s=br.readLine())!=null)
           {
               i++;
               bw.write(i+" "+s);
               bw.newLine();
           }
		   br.close();
		   fr.close();
           bw.flush();
           bw.close();
           fw.close();
          
      }
      catch(IOException e)
         {
           System.out.println(e);
         }  
   }
}
