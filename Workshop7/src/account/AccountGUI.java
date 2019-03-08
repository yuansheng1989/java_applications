package account;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

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
	    		Connection con = null;
	    		Statement stmt = null;
	        	try {
	        		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB?useSSL=true", "root", "205411");
	        		stmt = con.createStatement();
	        		stmt.executeUpdate(
	        						"insert into Accounts " +
	        						"values(" + 
	        						Integer.parseInt(textField1.getText()) + ", " +
	        						"'"+ textField2.getText() + "', " +
	        						"'"+ textField3.getText() + "', " +
	        						Double.parseDouble(textField4.getText()) + ")"
	        						);
	        	} catch(SQLException ex) {
	        		System.err.println("SQLException: " + ex.getMessage());
	        	} finally {
	        		try {
	        			if (stmt != null)
	        				stmt.close();
	        			if (con != null)
	        				con.close();
	        		} catch (Exception ex) {
	            		System.err.println("SQLException: " + ex.getMessage());
	            	}
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
	    		Connection con = null;
	    		Statement stmt = null;
	        	try {
	        		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB?useSSL=true", "root", "205411");
	        		stmt = con.createStatement();
	        		ResultSet rs = stmt.executeQuery("select * from Accounts");
	    			String account = "";
	    			String fName = "";
	    			String lName = "";
	    			String balance = "";
	    			while (rs.next()) {
	    				account += rs.getString("ACCOUNT_NUMBER") + "\n";
	    				fName += rs.getString("FIRST_NAME") + "\n";
	    				lName += rs.getString("LAST_NAME") + "\n";
	    				balance += rs.getString("BALANCE") + "\n";
	    			}
    				textArea1.setText(account);
    				textArea2.setText(fName);
    				textArea3.setText(lName);
    				textArea4.setText(balance);
	        	} catch(SQLException ex) {
	        		System.err.println("SQLException: " + ex.getMessage());
	        	} finally {
	        		try {
	        			if (stmt != null)
	        				stmt.close();
	        			if (con != null)
	        				con.close();
	        		} catch (Exception ex) {
	            		System.err.println("SQLException: " + ex.getMessage());
	            	}
	        	}
	    	}
	    });

	    createAccountTable();
	}

    public static void createAccountTable() {
    	Connection con = null;
    	Statement stmt = null;
    	
    	String createString = "create table IF NOT EXISTS Accounts " + "(ACCOUNT_NUMBER int, " + "FIRST_NAME varchar(32), " + "LAST_NAME varchar(32), " + "BALANCE double)";
    	try {
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB?useSSL=true", "root", "205411");
    		stmt = con.createStatement();
    		stmt.executeUpdate(createString);
    	} catch(SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    	} finally {
    		try {
    			if (stmt != null)
    				stmt.close();
    			if (con != null)
    				con.close();
    		} catch (Exception ex) {
        		System.err.println("SQLException: " + ex.getMessage());
        	}
    	} 
    } 
}