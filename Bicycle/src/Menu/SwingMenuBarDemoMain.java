package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Dialog.AboutDialog;
import Dialog.DialogFrame;

public class SwingMenuBarDemoMain extends JFrame{
	  
	private AboutDialog dialog;
	private JFileChooser chooser,opener;
	JTextArea textArea = new JTextArea(6,12);
    JScrollPane scrollPane = new JScrollPane(textArea);
    JMenuItem newItem = new JMenuItem("New",new ImageIcon("src/resources/new.png"));
    JMenuItem openItem = new JMenuItem("Open",new ImageIcon("src/resources/open.png"));
    JMenuItem saveItem = new JMenuItem("Save",new ImageIcon("src/resources/save.png"));
    JMenuItem exitItem = new JMenuItem("Exit",new ImageIcon("src/resources/exit.png"));
    JMenuItem aboutItem = new JMenuItem("About",new ImageIcon("src/resources/open.png"));
    
    JMenuItem cutItem = new JMenuItem("Cut", new ImageIcon("src/resources/cut.png"));
    JMenuItem copyItem = new JMenuItem("Copy", new ImageIcon("src/resources/copy.png"));
    JMenuItem pasteItem = new JMenuItem("Paste", new ImageIcon("src/resources/paste.png"));
    

    JMenu editMenu = new JMenu("Edit");
    
	KeyStroke keyStrokeToNew = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
	KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK);
	KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
    
	 
	
	SwingMenuBarDemoMain(){
		
		chooser = new JFileChooser();
		opener = new JFileChooser();
		//setting 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		helpMenu.add(aboutItem);
		
		aboutItem.setMnemonic('A');
		
		
		menuBar.add(editMenu);
		
		//cutItem.setHorizontalTextPosition(SwingConstants.LEFT);
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		
		newItem.setAccelerator(keyStrokeToNew);
	    fileMenu.add(newItem);
	    
		newItem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						saveConfirm();
					}
				});
		

		
		openItem.setAccelerator(keyStrokeToOpen);
		fileMenu.add(openItem);

		openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)  {
            	openFilehandling();
             }   
          });

		fileMenu.add(saveItem);
        //saveItem.setEnabled(false);
		saveItem.setAccelerator(keyStrokeToSave);
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFilehandling();
			}
		});
		
		//Dialog box in about click
	     aboutItem.addActionListener(new ActionListener(){
	           public void actionPerformed(ActionEvent event){
	              if (dialog == null) // first time
	                dialog = new AboutDialog(SwingMenuBarDemoMain.this);
	                dialog.setVisible(true); // pop up dialog
	              }
	        });
	     

	        // The Exit item exits the program.

	     fileMenu.add(exitItem);
	     exitItem.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent event){
                System.exit(0);
              }
          });

		JMenu optionsMenu = new JMenu("Options");
		editMenu.add(optionsMenu);

		JCheckBoxMenuItem readonlyItem = new JCheckBoxMenuItem("Read-only",new ImageIcon("src/resources/read.png"));
		readonlyItem.setHorizontalTextPosition(SwingConstants.LEFT);
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert",new ImageIcon("src/resources/insert.png"));
		insertItem.setHorizontalTextPosition(SwingConstants.LEFT);
		
		add(scrollPane);
		
    	optionsMenu.add(readonlyItem);
    	optionsMenu.add(insertItem);

    	
    	
    	JPopupMenu popup = new JPopupMenu();
   	    JMenuItem cut = new JMenuItem("Cut");
   	    JMenuItem copy = new JMenuItem("Copy");
   	    JMenuItem paste = new JMenuItem("Paste");
   	    JMenuItem selectAll = new JMenuItem("Select All");
	    popup.add(cut);
	    popup.add(copy);
	    popup.add(paste);
	    popup.add(selectAll);
	    
	    
	  
		setSize(600, 600);
    	setVisible(true);
  	
	}
	
	void saveConfirm() {
		//String data=textArea.getText().trim(); //read contents of text area into 'data'
		//(data.length() > 0)
		 
		  if(!textArea.equals(null) ){
		     newItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("I am not empty");
					System.out.println(textArea);
					
					int selection = JOptionPane.showConfirmDialog(null,
							   "Do you want to save existing file", "Confirmation for Saving",
							   JOptionPane.OK_CANCEL_OPTION,
							   JOptionPane.QUESTION_MESSAGE);
							if (selection == JOptionPane.OK_OPTION){
								System.out.println("Saving file.....");
								saveFilehandling();
							}else{
								System.out.println("Cancel....");
					}		
				}
			});
		}
		
	}
	
	void openFilehandling() {
		chooser.setDialogTitle("Location of file to open");
        chooser.setCurrentDirectory(new File("/home/ishworpanta/Documents/TEXT"));

		// show file chooser dialog
		int result = chooser.showOpenDialog(SwingMenuBarDemoMain.this);

        // if image file accepted, set it as icon of the label
        if (result == JFileChooser.APPROVE_OPTION){
           String fileContent = "";
           String name = chooser.getSelectedFile().getPath();
           //System.out.println("File Path: "+name);
           File file = new File(name);
       	   FileInputStream fis = null;
       		try {
       			fis = new FileInputStream(file);
       			//System.out.println("Total file size to read in(bytes)" + fis.available());
       			int content;
       			while((content = fis.read())!= -1) {
       				//convert to char and display it
       				char c = (char) content;
       				fileContent += String.valueOf(c);
       				
       			}
       			
       		}catch(IOException e) {
       			e.printStackTrace();
       			
       		}finally {
       			try {
       				if (fis != null) {
       					fis.close();
       				}
       					}catch(IOException ex) {
       					ex.printStackTrace();
       				}

       		}
       		//setting text file content in textArea 
       		//System.out.print(fileContent);
       		textArea.setText(fileContent);
        }
	}
	
	
	
	void saveFilehandling() {
		opener.setCurrentDirectory(new File("/home/ishworpanta/Documents/TEXT"));
		// show file chooser dialog
			int result = opener.showSaveDialog(SwingMenuBarDemoMain.this);
        // if image file accepted, set it as icon of the label
        if (result == JFileChooser.APPROVE_OPTION){
           String content = "";
           	//saving file in name location
           		FileOutputStream fop = null;
        		File file ;
        		
        		//getting content from textArea
        	    content = textArea.getText();
        	    System.out.println(content);
        		
        	    try {
        			file  =  opener.getSelectedFile();
        			fop  = new FileOutputStream(file);
        			
        			//if file does not exist
        			
        			if(!file.exists()) {
        				file.createNewFile();
        			}
        			
        			//get the content in bytes
        			byte[] contentInBytes = content.getBytes();
        			fop.write(contentInBytes);
        			fop.flush();
        			fop.close();
        			System.out.println("Done Writting");

        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}finally {
        			try {
        				if (fop!=null) {
        					fop.close();
        				}
        			}catch(IOException e1) {
        				e1.printStackTrace();
        				
        		}
        	}	
        }	
        System.exit(0);
	}
	
			//Cut copy paste section
	
	 JPopupMenu popupMenu = new JPopupMenu();

	  void CutCopyPastActionSupport() {
	      init();
	  }
	  
	  private void init() {
	      
	      addAction(new DefaultEditorKit.CutAction(), KeyEvent.VK_X, "Cut" );
	      addAction(new DefaultEditorKit.CopyAction(), KeyEvent.VK_C, "Copy" );
	      addAction(new DefaultEditorKit.PasteAction(), KeyEvent.VK_V, "Paste" );
	  }
	  
	  private void addAction(TextAction action, int key, String text) {
	      action.putValue(AbstractAction.ACCELERATOR_KEY,
	              KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
	      action.putValue(AbstractAction.NAME, text);
	      editMenu.add(new JMenuItem(action));
	      popupMenu.add(new JMenuItem(action));
	  }
	  
	   void setPopup(JTextComponent... components){
	      if(components == null){
	          return;
	      }
	      for (JTextComponent tc : components) {
	          tc.setComponentPopupMenu(popupMenu);
	      }
	  }	
	   

	
	
	
	public static void main(String[] args) {
		new SwingMenuBarDemoMain();
		
	}
	
}