package main;

import account.FileObjectOutputStream;
import account.DeSerializationOfObject;
import javax.swing.JFrame;
import account.AccountGUI;

public class Main {
	public static void main(String[] args) {
		/*
		// Serialize objects
		FileObjectOutputStream.openFile();
		FileObjectOutputStream.addRecords();
		FileObjectOutputStream.closeFile();

		// Deserialize objects
		DeSerializationOfObject.openFile();
		DeSerializationOfObject.readRecords();
		DeSerializationOfObject.closeFile();
		*/
		AccountGUI accountGUI = new AccountGUI();
		accountGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountGUI.setSize(800, 200); 
		accountGUI.setVisible(true);
		
	}
}