import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Programs searches through");
		System.out.println("top names from 1980-2010");
		System.out.println("then graphs probability");
		System.out.println("");
		
		Scanner console = new Scanner(System.in);
		
		boolean quit = false;
		while(!quit) {
			Scanner names = new Scanner(new File("names.txt"));
			Scanner meanings = new Scanner(new File("meanings.txt"));
			System.out.print("Enter a name: ");
			String name = console.next();
			name = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();
			if(name.equals("Quit")) {
				quit = true;
			}else {
				System.out.println("Main loop: " + name);
			}
		}
	}

}
