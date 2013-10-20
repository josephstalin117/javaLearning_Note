import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

public class Calculator 
{ 
	public static void main( String args[] ) 
	{ 
		CalculatorFrame calculatorFrame = new CalculatorFrame ( ) ; 
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	} 
} 

class CalculatorFrame extends JFrame implements ActionListener
{
	private JButton keys[]; 
	private JPanel keyPad; 
	private JTextField lcd; 
	private double number = 0.0;
	private String operator = "=";
	private boolean firstDigit = true;
	
	public CalculatorFrame( ) 
	{ 
		setTitle ( "Calculator" ); 	
		lcd = new JTextField( 20 ); 
		keys = new JButton[ 16 ]; 
		lcd.setEditable(false);
	
		for ( int i=0; i<=9;i++ ) 
			keys[ i ] = new JButton( String.valueOf( i ) ); 
	
		keys[ 10 ] = new JButton( "/" ); 
		keys[ 11 ] = new JButton( "*" ); 
		keys[ 12 ] = new JButton( "-" ); 
		keys[ 13 ] = new JButton( "+" ); 
		keys[ 14 ] = new JButton( "=" ); 
		keys[ 15 ] = new JButton( "." ); 
		
		keyPad = new JPanel(); 

		keyPad.setLayout( new GridLayout( 4, 4 ) ); 

		for ( int i = 7; i <= 10; i++ ) 
			keyPad.add( keys[ i ] ); 
	
		for ( int i = 4; i <= 6; i++ ) 
			keyPad.add( keys[ i ] ); 
			keyPad.add( keys[ 11 ] ); 

		for ( int i = 1; i <= 3; i++ ) 
			keyPad.add( keys[ i ] ); 
			keyPad.add( keys[ 12 ] ); 
 
		keyPad.add( keys[ 0 ] ); 
		for ( int i = 15; i >= 13; i-- ) 
			keyPad.add( keys[ i ] ); 
			
		add( lcd, BorderLayout.NORTH ); 

		add( keyPad );
		
		for (int i = 0; i < keys.length; i++) 
		{
         keys[i].addActionListener(this);
      }  
    
    setSize( 200, 200 ); 
		setVisible( true );    
} 
	
	public double getNumber()
    {
    	return Double.parseDouble(lcd.getText());
    	}    	
  
  public void actionPerformed(ActionEvent e)
    {
    	String s = e.getActionCommand();
    	
    	if ("0123456789.".indexOf(s)!= -1)
    	{
    		if (firstDigit)
    			lcd.setText(s);
    		else if (s.equals(".")&& lcd.getText().indexOf(".")==-1)
    			lcd.setText(lcd.getText()+".");
    		else if (!s.equals("."))
    			lcd.setText(lcd.getText()+s);
    		
    		firstDigit = false;    			
    		}     		
    	else 
    		{
    			if (operator.equals("+"))
    				number += getNumber();
    			else if (operator.equals("-"))
    				number -= getNumber();
    			else if (operator.equals("*"))
    				number *= getNumber();
    			else if (operator.equals("/"))
    				number /= getNumber();
    			else if (operator.equals("="))
    				number = getNumber();
    			
    			lcd.setText(String.valueOf(number)); 
    			operator = s; 
    			firstDigit = true;   			   			
    			}
    	}
} 
