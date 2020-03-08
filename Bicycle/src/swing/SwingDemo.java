package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingDemo {

	public static void main(String[] args) {
		JFrame frame =  new JFrame("Swing Demo");
		frame.setVisible(true);
		frame.setSize(200,200);
		
		JLabel labelName = new JLabel("Name");
		JTextField txtName = new JTextField(20);
		JButton btnSave = new JButton("Save");
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.add(labelName);
		panel.add(txtName);
		panel.add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				JOptionPane.showMessageDialog(null, name);
				
			}
		});
		
		frame.pack();
	}
}
