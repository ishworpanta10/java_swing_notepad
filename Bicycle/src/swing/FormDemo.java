package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormDemo extends JFrame {
	FormDemo(){
	JPanel jPanel = new JPanel();
	Border border = BorderFactory.createLineBorder(Color.GREEN);
	
	jPanel.setBorder(border);
	
	JLabel labelClub = new JLabel("Favourite Club :");
	labelClub.setBounds(50, 40, 180, 40);
	
	
	JCheckBox real_madrid = new JCheckBox("Real Madrid");
	real_madrid.setBounds(170, 40, 122, 40);
	JCheckBox barcelona  = new JCheckBox("Barcelona");
	barcelona.setBounds(290, 40, 150, 40);
	
	JLabel labelGender = new JLabel("Gender:");
	labelGender.setBounds(50, 80, 150, 40);
	
	JRadioButton male = new JRadioButton("Male");
	male.setBounds(140, 80, 80, 40);
	JRadioButton female = new JRadioButton("Female");
	female.setBounds(250, 80, 80, 40);
	JRadioButton other =  new JRadioButton("Other");
	other.setBounds(350, 80, 80, 40);
	
	JLabel labelAge = new JLabel("Age:");
	labelAge.setBounds(50, 120, 150, 40);
	
	JLabel labelPlayer = new JLabel("Football Players:");
	labelPlayer.setBounds(50, 160, 150, 40);
	
	
	ButtonGroup group = new ButtonGroup();
	group.add(male);
	group.add(female);
	group.add(other);
	
	
	String[] footballPlayers = {"Messi", "Ronaldo", "Suarez", "Ter Stegen", "Ramos" };
	JComboBox<String> playerList = new JComboBox<>(footballPlayers);
	playerList.setBounds(200, 170, 120, 20);
		
	
	JSlider slider =  new JSlider(20,30,24);
	slider.setPaintLabels(true);
	slider.setPaintTicks(true);
	slider.setMajorTickSpacing(2);
	slider.setMinorTickSpacing(2);
	slider.setBounds(140, 120, 200, 40);
	
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(50,320, 120, 30);
	
	JLabel labelPassword = new JLabel("Password");
	labelPassword.setBounds(50, 200, 120, 30);
	JPasswordField passwordField = new JPasswordField(10);
	passwordField.setBounds(150, 200, 200, 30);
	
	JLabel labelDetails = new JLabel("Feedback:");
	labelDetails.setBounds(50, 250, 200, 30);
	
	JTextArea textArea = new JTextArea(2,4);
//	textArea.setBounds(140, 250, 330, 40);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setBounds(140, 250, 330, 60);
	
	
	jPanel.setLayout(null);
	
	jPanel.add(labelClub);
	jPanel.add(barcelona);
	jPanel.add(real_madrid);
	
	jPanel.add(labelGender);
	jPanel.add(male);
	jPanel.add(female);
	jPanel.add(other);
	
	jPanel.add(labelAge);
	jPanel.add(slider);

	jPanel.add(labelPlayer);
	jPanel.add(playerList);
	
	jPanel.add(labelPassword);
	jPanel.add(passwordField);
	
	jPanel.add(labelDetails);
	jPanel.add(scrollPane);
	
	jPanel.add(btnSubmit);
	
	add(jPanel);
	setSize(600,400);
	setVisible(true);
	
	btnSubmit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Thank You for submitting form");
			}
		});
	
	}
	
	public static void main(String[] args) {
		new FormDemo();

	}

}
