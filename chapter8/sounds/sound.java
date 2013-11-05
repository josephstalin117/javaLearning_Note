import sun.audio.*;//引入sun.audio包
import java.io.*;
InputStream in=new FileInputStream(Filename);
//打开一个声音文件流作为输入
AudioStream as=new AudioStream(in);
//用输入流创建一个AudioStream对象
AudioPlayer.player.start(as);
//”player”是AudioPlayer中一个静态成员用于控制播放
AudioPlayer.player.stop(as);
//当需要从网上下载文件播放时，用下列代码打开音乐文件网址：
AudioStream as=new AudioStream(url.openStream());
//播放一个持续的声音流如下：
//首先如上创建声音流;
AudioData data=as.getData();
//创建AudioData源
ContinuousAudioDataStream cas=new ContinuousAudioDataStream(data);
AudioPlayer.player.play(cas);//播放
AudioPlayer.player.stop(cas);//停止
//下面是一个综合的声音程序：
//AudioApplicationDemo.java
import sun.audio.*;        // 引 入sun.audio 包
import java.io.*;
import java.awt.event.*;
import java.awt.*;
public class AudioApplicationDemo extends Frame implements ActionListener
{
       AudioStream  as;
       //创建功能按钮，用于控制声音操作
       Button btnStart=new Button("开发播放");
       Button btnPause=new Button("暂停播放");
       Button btnContinue=new Button("继续播放");
       public AudioApplicationDemo()
       {
              try{
                     InputStream in = new FileInputStream ("computer.au");
                     //打开一个声音文件流作为输入
                     as = new AudioStream (in);
              }catch( Exception e){
                     e.printStackTrace();
              }            
              //给功能按钮添加事件监听器
              btnStart.addActionListener(this);
              btnPause.addActionListener(this);
              btnContinue.addActionListener(this);
              //把功能按钮加入到Applet容器中，并显示
              this.setLayout(new FlowLayout());
              this.add(btnStart);
              this.add(btnPause);
              this.add(btnContinue);
              //显示框架窗口
              this.pack();
              this.setVisible(true);
       }
       public static void main( String[] args )
       {
              AudioApplicationDemo fame=new AudioApplicationDemo();
              fame.addWindowListener(new WindowAdapter(){
                     public void windowClosing(WindowEvent e)
                     {
                            System.exit(0);
                     }
              });
       }
       //处理按钮事件
       public void actionPerformed(ActionEvent e)
       {
              //如果AudioStream对象为空，则直接返回
              if( as==null ){
                     System.out.println("AudioStream object is not created!");
                     return;
              }
              //获取用户激活的按钮
              Object cmd= e.getSource();
              
              if ( cmd == btnStart ){
                     //播放
                     AudioPlayer.player.start (as);               
              }else if( cmd == btnPause ){
                     //暂停
                     AudioPlayer.player.stop(as);
              }else if( cmd == btnContinue ){
                     //继续
                     AudioPlayer.player.start (as);
              }
       }
}
