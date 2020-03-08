package swing;

import java.awt.*;
import javax.swing.*;
public class GridBagLayoutDemo extends JFrame{
	JPanel panel;
	JLabel lName, lPhone;
	JTextField tName, tPhone;
	JButton b1, b2;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	public GridBagLayoutDemo()	{
			panel=new JPanel();
			getContentPane().add(panel);
			gbl=new GridBagLayout();
			gbc=new GridBagConstraints();
			panel.setLayout(gbl);
			lName=new JLabel("Name : ");
			lPhone=new JLabel("Phone : ");
			tName=new JTextField(10);
			tPhone=new JTextField(10);
			b1=new JButton("Button 1");
			b2=new JButton("Button 2");
			setSize(400,300);
			setVisible(true);
			setTitle("Grid Bag View");
			
			gbc.gridx=0;gbc.gridy=1;
			gbl.setConstraints(lName,gbc);
			
			panel.add(lName);
			gbc.gridx=2;gbc.gridy=1;
			gbl.setConstraints(tName,gbc);
			panel.add(tName);
			
			gbc.gridx=0;gbc.gridy=2;
			gbl.setConstraints(lPhone,gbc);
			panel.add(lPhone);
			
			gbc.gridx=2;gbc.gridy=2;
			gbl.setConstraints(tPhone,gbc);
			panel.add(tPhone);
			
			gbc.gridx=0;gbc.gridy=4;
			gbc.gridheight=2;gbc.gridwidth=2;
			gbc.weightx=1.0;
			gbc.weighty=1.0;
			gbc.fill=GridBagConstraints.BOTH;
			gbl.setConstraints (b1,gbc);
			panel.add(b1);
			gbc.gridx=4;gbc.gridy=6;
			gbc.fill=GridBagConstraints.NONE;
			gbl.setConstraints(b2,gbc);
			panel.add(b2);
	}
	public static void main(String []args){
		new GridBagLayoutDemo();
	}
}