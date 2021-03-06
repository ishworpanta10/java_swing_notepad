package Menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SwingToolbarDemo extends JFrame{
	SwingToolbarDemo(){
		JToolBar bar = new JToolBar("Color");
		JButton blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setToolTipText("Blue Button");
    	bar.add(blueButton);
    	add(bar, BorderLayout.NORTH);

		setSize(300, 300);
    	setVisible(true);
	}
	public static void main(String[] args) {
		new SwingToolbarDemo();
	}
}