package swing;

import java.awt.Container;
import java.awt.GridLayout;
/*GridLayout 类是一个布局处理器，它以矩形网格形式对容器的组件进行布置。容器被分成大小相等的矩形，一个矩形中放置一个组件*/
import java.awt.BorderLayout;
/*BorderLayout是一个布置容器的边界布局，它可以对容器组件进行安排，并调整其大小，使其符合下列五个区域：南、北、东、西和中间区域。每个区域最多只能包含一个组件，并通过相应的常量进行标识：NORTH、SOUTH、EAST、WEST 和 CENTER。当使用边界布局将一个组件添加到容器中时，要使用这五个常量之一*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
*
* @author Administrator
*/
public class Cal extends JFrame implements ActionListener {
    JFrame jf;
    JTextField jtf;
    String[] b = new String[] {"+","-","*","/","."};
    JButton jis = new JButton("=");
    private int temp = 0;
    private float result = 0;
    private float fnumber = 0, bnumber = 0;

    public Cal(){
        init();
    }

    public void init(){
        jf = new JFrame();
        jtf = new JTextField();

        Container c = jf.getContentPane();//Returns the contentPane object for this frame. 
        jtf.setHorizontalAlignment(JTextField.RIGHT);//设置文本的水平对齐方式 
         jtf.setLayout(new GridLayout()); 
        c.add(jtf,BorderLayout.NORTH);// 

        JPanel jp = new JPanel(); 
        jp.setLayout(new GridLayout(4,4));//对于GridLayout(int rows,int cols)详情请参见API 
        c.add(jp,BorderLayout.CENTER);/*这里刚开始犯了一低级错误，将c写成了jp，逻辑调用都出现了问题*/

        JButton[] ja = new JButton[10];
        JButton[] jb = new JButton[5];
        for(int i = 0; i < 10; i++){
            ja[i] = new JButton("" + i);
            ja[i].addActionListener(this);
        }
        for(int j = 0; j < 5; j++){
            jb[j] = new JButton("" + b[j]);
            jb[j].addActionListener(this);
        }

        for(int i = 0; i < 10; i++){
            jp.add(ja[i]);
        }
        for(int j = 0; j < 5; j++){
            jp.add(jb[j]);
        }

        jp.add(jis);
        jis.addActionListener(this);
        jf.setSize(200,300);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(s.equals("+")){
            this.fnumber = Float.parseFloat(this.jtf.getText());
            this.jtf.setText("");
            this.temp = 1;
        }
        else if(s.equals("-")){
            this.fnumber = Float.parseFloat(this.jtf.getText());
            this.jtf.setText("");
            this.temp = 2;
        }
        else if(s.equals("*")){
            this.fnumber = Float.parseFloat(this.jtf.getText());
            this.jtf.setText("");
            this.temp = 3;
        }
        else if(s.equals("/")){
            this.fnumber = Float.parseFloat(this.jtf.getText());
            this.jtf.setText("");
            this.temp = 4;
        }
        else if(s.equals(".")){
            if(jtf.equals("")){
                jtf.setText("0.");
            }
            else{
                jtf.setText(jtf.getText() + ".");
            }
        }
        else if(s.equals("=")){
            this.bnumber = Integer.parseInt(this.jtf.getText());
            switch(this.temp){
                case 1:
                    result = fnumber + bnumber;
                    this.jtf.setText(String.valueOf(result));
                    break;
                case 2:
                    result = fnumber - bnumber;
                    this.jtf.setText(String.valueOf(result));
                    break;
                case 3:
                    result = fnumber * bnumber;
                    this.jtf.setText(String.valueOf(result));
                    break;
                case 4:
                result = fnumber / bnumber;
                this.jtf.setText(String.valueOf(result));
                break;
            }
        }
        else{
            jtf.setText(jtf.getText() + e.getActionCommand());
        }
    }

    public static void main(String[] args){
        new Cal();
    }
}