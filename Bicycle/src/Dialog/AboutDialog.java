package Dialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutDialog extends JDialog{
	public AboutDialog(JFrame owner){
		super(owner, "About Dialog Test Box", true);
		add(new JLabel("<html><h3><b>I am Dialog</b></h3><hr><p>I am integrated in Menu Bar Example</p></html>"),
				BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				setVisible(false);
			}
		});
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		setSize(250, 150);
	}
}