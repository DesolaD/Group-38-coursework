import java.io.File;
import java.util.Scanner;

public class Reader {
	
	private Scanner input;
	private String string;
	
	public String readStream() {
		File file = new File("E:/java programming/COURSEWORK 3/coursework/Project/src/twoShelves.sim");
		try{
			input = new Scanner(file);
			string = "";

			while (input.hasNextLine()) {
				string = string + input.nextLine();
		}
		return string;
	}catch(Exception e){

		e.printStackTrace();}
		
		return(string);
	}
}