package account;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class FileObjectOutputStream {
	private static ObjectOutputStream output;
	
	public static void openFile(){
		try{
			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
		}catch (IOException ioException){
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		}
	}
	
	public static void addRecords(){
		Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name and balance.", "Enter end-of-file indicator to end input.");

        while (input.hasNext()) {
        	try {
        		Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
        		output.writeObject(record); //serialize record object into file
        	} catch(NoSuchElementException elementException) {
        		System.err.println("Invalid input. Please try again.");
        		input.nextLine(); // discard input so user can try again
        	} catch(IOException ioException) {
        		System.err.println("Error writing to file. Terminating.");
        		break;
        	}

        	System.out.print("? ");
        }
        System.out.printf("%n%n");
        input.close();
	}
	
	public static void closeFile(){
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
	
}