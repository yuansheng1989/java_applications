package bank;

public class Bank {
	public static void main(String[] args) {
		System.out.println("Strange Bank System...");
		Account account = new Account();
		new Thread() {
			public void run() {
				account.withdrawDollar(1);
				account.withdrawEuros(2);
				account.withdrawPounds(3);
			}
		}.start();
		new Thread() {
			public void run() {
				account.depositDollar(1);
				account.depositEuros(2);
				account.depositPounds(3);
			}
		}.start();
	}
}