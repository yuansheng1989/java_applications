package account;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.util.NoSuchElementException;

public class AccountGUI extends JFrame {
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JTextField textField4;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JLabel label4;
	private final JLabel label5;
	private final JLabel label6;
	private final JLabel label7;
	private final JLabel label8;
	private final JButton saveButton;
	private final JButton readButton;
	private final JTextArea textArea1;
	private final JTextArea textArea2;
	private final JTextArea textArea3;
	private final JTextArea textArea4;
	
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public AccountGUI() {
		super("Account GUI");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("Account");
		add(label1);
		textField1 = new JTextField(10);
		add(textField1);
		
		label2 = new JLabel("First Name");
		add(label2);
		textField2 = new JTextField(10);
		add(textField2);
		
		label3 = new JLabel("Last Name");
		add(label3);
		textField3 = new JTextField(10);
		add(textField3);
		
		label4 = new JLabel("Balance");
		add(label4);
		textField4 = new JTextField(10);
		add(textField4);

	    saveButton = new JButton("Save");
	    add(saveButton);
	    saveButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
	    		if (output == null) {
		    		// open file for writing
		    		try{
		    			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
		    		}catch (IOException ioException){
		    			System.err.println("Error opening file. Terminating.");
		    			System.exit(1); // terminate the program
		    		}
	    		}
	    		// add record
	        	try {
	        		Account record = new Account(Integer.parseInt(textField1.getText()), textField2.getText(), textField3.getText(), Double.parseDouble(textField4.getText()));
	        		output.writeObject(record); //serialize record object into file
	        	} catch(NoSuchElementException elementException) {
	        		System.err.println("Invalid input. Please try again.");
	        	} catch(IOException ioException) {
	        		System.err.println("Error writing to file. Terminating.");
	        	}
	    	}
	    });
	    
	    label5 = new JLabel("Account");
	    add(label5);
	    Box box1 = Box.createHorizontalBox();
	    textArea1 = new JTextArea(5, 10);
	    textArea1.setEditable(false);
	    box1.add(new JScrollPane(textArea1));
	    add(box1);
	    
	    label6 = new JLabel("First Name");
	    add(label6);
	    Box box2 = Box.createHorizontalBox();
	    textArea2 = new JTextArea(5, 10);
	    textArea2.setEditable(false);
	    box2.add(new JScrollPane(textArea2));
	    add(box2);
	    
	    label7 = new JLabel("Last Name");
	    add(label7);
	    Box box3 = Box.createHorizontalBox();
	    textArea3 = new JTextArea(5, 10);
	    textArea3.setEditable(false);
	    box3.add(new JScrollPane(textArea3));
	    add(box3);
	    
	    label8 = new JLabel("Balance");
	    add(label8);
	    Box box4 = Box.createHorizontalBox();
	    textArea4 = new JTextArea(5, 10);
	    textArea4.setEditable(false);
	    box4.add(new JScrollPane(textArea4));
	    add(box4);
	    
	    readButton = new JButton("Read");
	    add(readButton);
	    readButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
	    		// open file
	    		try {
	    			input = new ObjectInputStream(new FileInputStream("clients.ser"));
	    		} catch (IOException ioException) {
	    			System.err.println("Error opening file.");
	    			System.exit(1);
	    		}
	    		
	    		
	    		// read record
	    		try {
	    			String account = "";
	    			String fName = "";
	    			String lName = "";
	    			String balance = "";
	    			
	    			while(true) {
	    				Account record = (Account) input.readObject();

	    				account += (String.valueOf(record.getAccount()) + "\n");
	    				fName += (record.getFirstName() + "\n");
	    				lName += (record.getLastName() + "\n");
	    				balance += (String.valueOf(record.getBalance()) + "\n");
	    				
	    				textArea1.setText(account);
	    				textArea2.setText(fName);
	    				textArea3.setText(lName);
	    				textArea4.setText(balance);
	    				
	    			}
    				
	    		} catch(EOFException endOfFileException) {
	    			System.out.printf("Reading end%n");
	    		} catch (ClassNotFoundException classNotFoundException) {
	    			System.err.println("Invalid object type. Terminating.");
	    		} catch (IOException ioException) {
	    			System.err.println("Error reading from file. Terminating.");
	    		}
	    		
	    		// close file
	    		try {
	    			if (input != null)
	    				input.close();
	    		} catch (IOException ioException) {
	    			System.err.println("Error closing file. Terminating.");
	    			System.exit(1);
	    		}
	    	}
	    });
	    
	}
}