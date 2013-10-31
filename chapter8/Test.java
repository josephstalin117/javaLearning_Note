import java.io.*;     
public class Test 
	{
  public static void main(String[] args) 
	  {
    try 
		{
        File dir1 = new File("subdir");

        if ( dir1.exists() && dir1.isDirectory()){
           System.out.println(dir1.getName()+"目录存在");

           String[] files = dir1.list() ;
           System.out.println("-----列目录-----");
           for( int i=0; i< files.length; i++)    //列目录
              System.out.println( files[i]);

        File dir2=new File("subdir\\d1");
        if(!dir2.exists())  dir2.mkdir();         //建目录
        System.out.println(" -----创建目录后再次列目录-----");
        files = dir1.list() ;	
        for( int i=0; i< files.length; i++)
             System.out.println( files[i]);

        //dir2.delete() ;   //删除创建的目录
        File f1 = new File("subdir\\a.java");    
        System.out.println("-----列出a.java文件的有关信息-----");
        System.out.println(f1.getName() + "   " +f1.getPath() + "   " + f1.length());
      }
	  else 
          System.out.println("subdir不存在或不是目录");
     }   // try 块
     catch(Exception e)  {
         System.out.println(e.toString());
     }
  }  // end of main()
} 


