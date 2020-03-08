package swing;

import java.awt.*;
import javax.swing.*;
public class BorderLayoutDemo extends JFrame{
	JPanel panel;
	JButton b1, b2, b3, b4, b5;
	BorderLayout bl;

	public BorderLayoutDemo(){
		panel=new JPanel();
		getContentPane().add(panel);
		bl=new BorderLayout(10,10);
		panel.setLayout(bl);

		b1=new JButton("North");
		b2=new JButton("South");
		b3=new JButton("East");
		b4=new JButton("West");
		b5=new JButton("Center");

		setTitle("Border Layout Demo Program");

		panel.add("North",b1);
		panel.add("South",b2);
		panel.add("East",b3);
		panel.add("West",b4);
		panel.add("Center",b5);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[]){
		BorderLayoutDemo obj = new BorderLayoutDemo();
	}
}