import java.io.*;
public class MyFileIo
{
  public static void main(String args[])
  {
     char ch;
     int chi;
     File myPath=new File("subdir");
     if(!myPath.exists())
       myPath.mkdir();
     File myFile=new File(myPath,"crt.txt");
     try
     {
        FileOutputStream fout=new FileOutputStream(myFile);
	System.out.println("请输入一个字符串，以#结尾");
	while((ch=(char)System.in.read())!='#')
	   fout.write(ch);
	fout.close();
	System.out.println("下面是从刚写入的文件中读出的数据");
	FileInputStream fin=new FileInputStream(myFile);
	while((chi=fin.read())!=-1)
	   System.out.print((char)chi);
	fin.close();
     }catch(FileNotFoundException e){
        System.err.println(e);
     }
     catch(IOException e){
        System.err.println(e);
     }     
  }
}