package Dialog;

import java.awt.event.*;
import javax.swing.*;


public class DialogFrame extends JFrame{
	private AboutDialog dialog;

	public DialogFrame(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){
                 if (dialog == null) // first time
                 dialog = new AboutDialog(DialogFrame.this);
                 dialog.setVisible(true); // pop up dialog
              }
        });
        fileMenu.add(aboutItem);

        // The Exit item exits the program.

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event){
                 System.exit(0);
              }
        });
        fileMenu.add(exitItem);

        setSize(400, 300);
		setVisible(true);
     }

     public static void main(String[] args){
		 new DialogFrame();
	 }
}