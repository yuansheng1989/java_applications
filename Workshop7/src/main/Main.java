package main;

import javax.swing.JFrame;
import account.AccountGUI;

public class Main {
	public static void main(String[] args) {
		AccountGUI accountGUI = new AccountGUI();
		accountGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountGUI.setSize(800, 200);
		accountGUI.setVisible(true);
	}
}