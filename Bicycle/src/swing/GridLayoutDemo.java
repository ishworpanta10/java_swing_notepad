package swing;

import java.awt.*;
import javax.swing.*;
public class GridLayoutDemo extends JFrame{
	JPanel panel;
	JButton b1, b2, b3;
	GridLayout gl;

	public GridLayoutDemo()	{
		panel=new JPanel();
		getContentPane().add(panel);
		gl=new GridLayout(3,3,10,10);
		panel.setLayout(gl);

		b1=new JButton("Button1");
		b2=new JButton("Button2");
		b3=new JButton("Button3");

		setTitle("Grid Layout Demo Program");

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[]){
		GridLayoutDemo obj=new GridLayoutDemo();
	}
}