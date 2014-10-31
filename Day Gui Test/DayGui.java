/***********************************************************************
 Program Name: DayGui.java
 Programmer's Name: Steven Bennett
 Program Description: Program displays dialog box that allows user to
 choose if they are having a bad day or good day.
 ***********************************************************************/ 

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DayGui extends JFrame {
	
	//declare instance variables
	private JFrame mainFrame;
	private JButton cmdGood;
	private JButton cmdBad;
	
	//create constructors
	public DayGui(){
		
		//instantiate JFrame object
		mainFrame = new JFrame("What kind of day are you having?");
		
		//instantiate button objects
		cmdGood = new JButton("Good");
		cmdBad = new JButton("Bad");
		
		//create a container to hold objects and give it a flow layout
		Container c = mainFrame.getContentPane();
		c.setLayout(new FlowLayout());
		
		//set background color of buttons
		cmdGood.setBackground(Color.green);
		cmdBad.setBackground(Color.red);
		cmdBad.setForeground(Color.white);
		
		//add buttons to window
		c.add(cmdGood);
		c.add(cmdBad);
		
		//set mnemonics for the two buttons
		cmdGood.setMnemonic('G');
		cmdBad.setMnemonic('B');
		
		//set the initial size and location of the window
		mainFrame.setBounds(750, 300, 500, 100);
		
		//set background color of window
		c.setBackground(Color.darkGray);
		
		//add listener to allow user to close window and terminat application
		mainFrame.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				});
		
		ButtonsHandler bhandler = new ButtonsHandler();
		cmdGood.addActionListener(bhandler);
		cmdBad.addActionListener(bhandler);
		
		//allow application to be visible
		mainFrame.setVisible(true);
	}
	
	//implement event handler
	class ButtonsHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == cmdGood)
				JOptionPane.showMessageDialog(null, "Today is a good day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE);
			
			if (e.getSource() == cmdBad)
				JOptionPane.showMessageDialog(null, "Today is a bad day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
