import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * plays a game
 * @author s-pkumar
 *
 */
public class MadLibs {

	public static void main(String[] args) throws FileNotFoundException {
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
			System.out.print("");
			String command = console.nextLine();
			Scanner input;
			PrintStream output;
			switch(command.toUpperCase()) {
				case "C":
					input = getInputScanner(console);
					output = System.out;
					createFile(input, output);
					break;
				case "V":
					input = getInputScanner(console);
					viewFile(input);
					//input.close();
					
					break;
				case "Q":
					done = true;
					break;
				default:
					System.out.println("Command " + command + "is not supported");
			}
			
		} while(!done);
		
		console.close();
		
	}
	
	/**
	 * prompts user for file and opens
	 * @param console
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static Scanner getInputScanner (Scanner console) throws FileNotFoundException {
		boolean validFile = false;
		File f = null;
		System.out.print("Input file name: ");
		do {
			f = new File(console.nextLine());
			if(f.exists()) {
				validFile = true;
			}else {
				System.out.print("File not found. Try again.");
			}
		}while(!validFile);
		
		Scanner input = new Scanner(f);
		return input;
	}
	
	public static void viewFile(Scanner input) {
		System.out.println();
		while(input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		System.out.println();
	
	}
	
	/**
	 * Prints out the file after madlibs
	 * @param in input
	 * @param out output
	 */
	public static void createFile(Scanner in, PrintStream out) {
		out.println("TEst");
		
	}
	
	
	

}
