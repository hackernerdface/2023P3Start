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
					output = getOutputPS(console);
					createFile(input, output, console);
					input.close();
					output.close();
					break;
				case "V":
					input = getInputScanner(console);
					viewFile(input);
					input.close();
					
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
	public static void createFile(Scanner in, PrintStream out, Scanner console) {
		out.println("TEst");
		while(in.hasNextLine()) {
			String line = in.nextLine();
			Scanner ls = new Scanner(line);
			while(ls.hasNext()) {
				String token = ls.next();
				if(token.charAt(0)=='<'&&token.charAt(token.length()-1)=='>') {
					System.out.println("Give me a/an " + token.substring(1, token.length()-1)+" : " );
					token=console.nextLine();
				}
				out.print(token+" ");
			}
			out.println();
		}
		//out.close();
		//in.close();
	}
	
	public static PrintStream getOutputPS(Scanner console) {
		boolean validFile = false;
		PrintStream ps= null;
		
		do {
			try {
				System.out.print("output file name: ");
				File f = new File(console.nextLine());
				ps = new PrintStream(f);
				validFile = true;
			}
			catch (FileNotFoundException e) {
				System.out.println("File Exception "+ e);
			}
			
		}while(!validFile);
		return ps;
		
	}
	

}
