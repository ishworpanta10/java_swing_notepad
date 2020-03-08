package Dialog;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SwingDialogDemo extends JFrame{
	
	
	SwingDialogDemo(){
		JPanel panel = new JPanel();
		add(panel);
		JButton btn = new JButton("Click");
		panel.add(btn);

		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);

		String inputValue = JOptionPane.showInputDialog("Please input a value");
		System.out.println("Input Value: "+inputValue);

		int selection = JOptionPane.showConfirmDialog(null,
				   "Message", "Title",
				   JOptionPane.OK_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE);
				if (selection == JOptionPane.OK_OPTION){
					System.out.println("Ok.....");
				}else{
					System.out.println("Cancel....");
		}

		Object[] possibleValues = { "First", "Second", "Third" };
		Object selectedValue = JOptionPane.showInputDialog(null,

		        "Choose one", "Input",

		        JOptionPane.INFORMATION_MESSAGE, null,

        		possibleValues, possibleValues[0]);

        System.out.println("Selected Value: "+selectedValue.toString());

		setSize(300, 300);
    	setVisible(true);
	}
	public static void main(String[] args) {
		new SwingDialogDemo();
	}
}