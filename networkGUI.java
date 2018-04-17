package Networking;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

public class networkGUI extends JFrame implements ActionListener{

	static JFrame gui = new JFrame("Networking Mathematics");
	
	JTextField textbox = new JTextField("Enter your code here");
	JLabel instruction = new JLabel("Choose what you want to learn from the menu", SwingConstants.CENTER);
	JButton enter = new JButton("Enter");
	JButton reset = new JButton("Reset");
	BasicArrowButton next = new BasicArrowButton(BasicArrowButton.EAST);
	BasicArrowButton previous = new BasicArrowButton(BasicArrowButton.WEST);
	static JTextArea printer = new JTextArea("Print");
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("What do you want to learn?");
	JMenuItem runLength = new JMenuItem("Lossless Compression: Run-Length Encoding");
	JMenuItem codeDivision = new JMenuItem("Code Division Multiplexing");
	JMenuItem asynchronous = new JMenuItem("Asynchronous Bit Calculation");
	JMenuItem synchronous = new JMenuItem("Synchronous Bit Calculation");
	JMenuItem crcError = new JMenuItem("Cyclic Redundancy Checksum");
	
	JPanel layout = new JPanel();
	JPanel instructions = new JPanel(new FlowLayout());
	JPanel button = new JPanel(new FlowLayout());
	
	int menuCode = 0;
	
	public networkGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setJMenuBar(bar);
		bar.add(menu);
		menu.add(runLength);
		menu.add(codeDivision);
		menu.add(asynchronous);
		menu.add(synchronous);
		menu.add(crcError);
		
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		add(layout);
		
		layout.add(instructions);
		instructions.add(previous);
		instructions.add(instruction);
		instructions.add(next);
		
		layout.add(textbox);
		layout.add(button);
		button.add(reset);
		button.add(enter);
		layout.add(printer);
		
		printer.setMargin(new Insets(20, 20, 0, 20));
		printer.setEditable(false);
		
		
		setSize(750,500);
		setVisible(true);
		
		runLength.addActionListener(this);
		codeDivision.addActionListener(this);
		asynchronous.addActionListener(this);
		synchronous.addActionListener(this);
		crcError.addActionListener(this);
		enter.addActionListener(this);
		reset.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a) {
		Object source = a.getSource();
		
		if (source == reset) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
		}
		
		if (source == enter) {
			if (menuCode == 1) {
				functions.binary = textbox.getText();
				functions.runLength(functions.binary);
			}
			if (menuCode == 2) {
				
			}
			if (menuCode == 3) {
				functions.charCount = textbox.getText();
				functions.asynchronous(functions.charCount);
			}
			if (menuCode == 4) {
				functions.charCount = textbox.getText();
				functions.synchronous(functions.charCount);
			}
			if (menuCode == 5) {
				
			}
		}
		
		if (source == runLength) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
			menuCode = 1;
			instruction.setText("Enter a string of 0s and 1s and then press Enter  (Make sure to end with a 1!)");
		}
		
		if (source == codeDivision) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
			menuCode = 2;
			
		}
		
		if (source == asynchronous) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
			menuCode = 3;
			instruction.setText("Please enter an integer for the number of characters you want to send");
		}
		
		if (source == synchronous) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
			menuCode = 4;
			instruction.setText("Please enter an integer for the number of characters you want to send");
		}
		
		if (source == crcError) {
			textbox.setText("");
			printer.setText("");
			functions.binary = "";
			functions.count0 = 0;
			functions.count1 = 0;
			functions.index = 0;
			functions.charCount = "";
			functions.bitCount = 0;
			functions.ready = false;
			functions.counter = 0;
			functions.zeros = new int[0];
			menuCode = 5;
		}
	}
	
	public static void main(String[] args) {
		gui = new networkGUI();
	}
}
