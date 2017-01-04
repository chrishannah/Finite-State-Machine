import java.util.Scanner;

/**
 * Finite State Machine
 * 
 * This program is the Java representation of a finite state machine, 
 * it checks whether a given String is valid, based upon specific 
 * criteria.
 * 
 * 
 * The criteria for this state machine, is that the characters can 
 * only be '0' or '1', and the string contains two pairs of adjacent 
 * 0's separated by an even number of characters.
 * 
 * @author Christopher Hannah
 * 
 * This class is the interface, that is used to pass a String to the
 * state machine, and then print out the results.
 *
 */
public class StateMachineInterface {
	
	/**
	 * This is the main method, which continuously asks for an 
	 * input string, and then processes each one.
	 * @param args
	 */
	public static void main(String args[]) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter a String to be Checked: ");
		    String s = scanner.next();
		    process(s);
		}
	}
	
	/**
	 * This is the process function, that passes a String to the 
	 * state machine, and prints the results to the console.
	 * @param in String to be processed
	 */
	private static void process(String in) {
		if (StateMachine.process(in)) {
			System.out.println(in + " accepted");
		} else {
			System.out.println(in + " rejected");
		}
	}
}
