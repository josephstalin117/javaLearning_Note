 
import java.io.*;

public class Exercise
{
    public static void main(String args[])
    {
        int i=0;
		String s;
		try
		{
		FileReader fr=new FileReader("Student.txt");
		BufferedReader br=new BufferedReader(fr);
		FileWriter fw=new FileWriter("Result.txt");
		BufferedWriter bw=new BufferedWriter(fw);

		while((s=br.readLine())!=null)
		{
		   i++;
		   bw.write(i+"  "+s);
		   bw.newLine();
		}
		br.close();
		fr.close();
		bw.close();
		fw.close();
		}catch(IOException e)
			{
			e.printStackTrace();
			}
    }
}

