import java.io.PrintStream;
import java.util.Scanner;

/**
 * plays a game
 * @author s-pkumar
 *
 */
public class MadLibs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome ");
		System.out.println("Provide words and phrases to fill in story");
		System.out.println("Result will be in an output file");
		System.out.println();
		
		
		//create a scanner from console
		Scanner console = new Scanner(System.in);
		
		//enter loop and cycle
		boolean done = false;
		do {
			System.out.print("(C)reate a Mid lib, (V)iew, or (Q)uit");
			String command = console.nextLine();
			Scanner input;
			PrintStream output;
			switch(command.toUpperCase()) {
				case "C":
					break;
				case "V":
					break;
				case "Q":
					done = true;
					break;
				default:
					System.out.println("Command" + command + "is not supported");
			}
			
		} while(!done);
			
	}

}
