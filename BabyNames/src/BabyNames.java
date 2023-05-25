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
				String meaning = getMeaning(name, meanings);
				System.out.println("Name: "+ name + " " +   meaning);
				if(meaning.equals("Not found")) {
					continue;
				}
			}
		}
	}
	
	/**
	 * Tries to find meaning for a name
	 * @param name
	 * @param meaning
	 * @return not found if name not in database
	 */
	public static String getMeaning(String name, Scanner meanings) {
		name = name.toUpperCase();
		while(meanings.hasNextLine()) {
			Scanner ls = new Scanner(meanings.nextLine());
				if(name.equals(ls.next())){
					String gender = ls.next();
					String meaning = "Meaning";
					while(ls.hasNext()) {
						meaning += ls.next() + " ";
					}
					return meaning;
				}
			}
		return "Not Found";
	}
}


