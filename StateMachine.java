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
 * This class is the state machine, which accepts a String, processes it, 
 * and returns the result.
 *
 */

public class StateMachine {
	
	// Current State
	private static int cs;
	// Start State
	private static final int s = 1; 
	// Array of Final States
	private static final int[] F = {7, 11, 14, 17, 18, 19, 22, 23, 25, 26, 27, 28, 29, 31, 33, 34, 35, 36, 37, 38, 39, 41, 42, 43, 44, 45, 46};
	// Two dimensional array of the transition table, with each row referring to the state, and column referring to the input character
	private static final int[][] T = {{0, 0}, {2, 3}, {4, 3}, {2, 3}, {5, 6}, {7, 3}, {8, 9}, {10, 11}, {12, 6}, {13, 6}, {10, 3}, {14, 11}, {15, 16}, {17, 9}, {18, 11}, {19, 6}, {20, 16}, {21, 22}, {23, 22}, {24, 25}, {26, 16}, {27, 9}, {28, 25}, {29, 11}, {30, 6}, {31, 22}, {32, 33}, {30, 22}, {34, 22}, {29, 11}, {24, 9}, {35, 25}, {32, 16}, {36, 33}, {37, 38}, {39, 22}, {40, 33}, {41, 22}, {42, 22}, {43, 25}, {44, 16}, {40, 33}, {45, 25}, {35, 25}, {42, 22}, {46, 33}, {46, 33}};
	
	/**
	 * The transition function which takes a state and a character, 
	 * performs the correct transition, and returns the next state.
	 * @param s The current state 
	 * @param c The next character to process
	 * @return The next state
	 */
	private static int transition(int s, char c) {
		switch (c) {
		case '0': 
			return T[s][0];
		case '1': 
			return T[s][1];
		}
		return 0;
	}
	
	/**
	 * The process function which takes a string as an input, and 
	 * then iterates through each character and performs each
	 * transition. After the whole string has been processed, it 
	 * checks whether the last state is a final/accepting state and
	 * returns the result.
	 * @param in The whole string that will be processed
	 * @return Whether the string is valid according to the state machine
	 */
	public static Boolean process(String in) {
		reset();
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			cs = transition(cs, c);
		}
		return isFinal(cs);
	}
	
	/**
	 * The reset function that changes the value of cs (current state) 
	 * to the start state.
	 */
	private static void reset() {
		cs = s;
	}
	
	/**
	 * This function checks whether a given state is a final/accepting one, 
	 * it then returns the result.
	 * @param s State
	 * @return Whether the state is final
	 */
	private static Boolean isFinal(int s) {
		for (int f : F) {
			if (s == f) {
				return true;
			}
		}
		return false;
	}
	
}
