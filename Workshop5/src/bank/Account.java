package bank;

public class Account {
	double dollar;
	double euros;
	double pounds;

	public Account() {
		this(0.0, 0.0, 0.0);
	}

	public Account(double dollar, double euros, double pounds){
		this.dollar = dollar;
		this.euros = euros;
		this.pounds = pounds;
	}

	synchronized void depositDollar(double dollar) {
		System.out.println("going to deposit dollar...");
		while (this.euros > 0.0 || this.pounds > 0.0 || this.dollar > 0.0) {
			System.out.println("currency exist; waiting for deposit");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.dollar += dollar;
		System.out.println("deposit dollar completed... ");
		System.out.println(this);
		notify();
	}
	
	synchronized void depositEuros(double euros) {
		System.out.println("going to deposit euros...");
		while (this.dollar > 0.0 || this.pounds > 0.0 || this.euros > 0.0) {
			System.out.println("currency exist; waiting for deposit");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.euros += euros;
		System.out.println("deposit euros completed... ");
		System.out.println(this);
		notify();
	}

	synchronized void depositPounds(double pounds) {
		System.out.println("going to deposit pounds...");
		while (this.dollar > 0.0 || this.euros > 0.0 || this.pounds > 0.0) {
			System.out.println("currency exist; waiting for deposit");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.pounds += pounds;
		System.out.println("deposit pounds completed... ");
		System.out.println(this);
		notify();
	}
	
	synchronized void withdrawDollar(double dollar) {
		System.out.println("going to withdraw dollar...");
		while (this.dollar < dollar) {
			System.out.println("less dollar balance; waiting for deposit...");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.dollar -= dollar;
		System.out.println("withdraw dollar completed...");
		System.out.println(this);
		notify();
	}
	
	synchronized void withdrawEuros(double euros) {
		System.out.println("going to withdraw euros...");
		while (this.euros < euros) {
			System.out.println("less euros balance; waiting for deposit...");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.euros -= euros;
		System.out.println("withdraw euros completed...");
		System.out.println(this);
		notify();
	}
	
	synchronized void withdrawPounds(double pounds) {
		System.out.println("going to withdraw pounds...");
		while (this.pounds < pounds) {
			System.out.println("less pounds balance; waiting for deposit...");
			try {
				wait();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		this.pounds -= pounds;
		System.out.println("withdraw pounds completed...");
		System.out.println(this);
		notify();
	}
	
	@Override
	public String toString(){
		return "\nAccount Balance:\n" + "Dollar: " + this.dollar + " " + "Euros: " + this.euros + " " + "Pounds: " + this.pounds + "\n";
	}
}