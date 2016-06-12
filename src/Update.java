//TODO fully create each dinner object
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;

/*
 * Update.java
 *
 * Check recipes directory for new entries and update the database.
 *
 * JHC
 * June 2016
 */

public class Update {
	public static void main (String[]args) {
		ArrayList<String> recipeFileNames = new ArrayList<String>();
		ArrayList<Dinner> Dinners = new ArrayList<Dinner>();
		recipeFileNames = GetListOfFiles();
		Dinners = CreateDinnerObjects(recipeFileNames);

		for(int i=0 ; i<Dinners.size() ; i++)
		{
			System.out.println(Dinners.get(i).name);
		}

		
		// TODO for each Dinner object, check if it exists in the database, if not, add it
	}

	// get all of the names of the recipe files
	private static ArrayList<String> GetListOfFiles (){
		ArrayList<String> recipes = new ArrayList<String>();
		File recipeFolder = new File("../recipes");
		File[] recipeFiles = recipeFolder.listFiles();
		for(int i=0 ; i< recipeFiles.length; i++) {
			if(recipeFiles[i].isFile()) {
				// if ends with .rec
				String fileName = recipeFiles[i].getName();
				if(fileName.substring(fileName.length()-4).equals(".rec")) {
					// add name to recipe list
					recipes.add(fileName);
				}
			}
		}
		return recipes;
	}

	// read the contents of each recipe file into a Dinner object
	private static ArrayList<Dinner> CreateDinnerObjects(ArrayList<String> files) {
		ArrayList<Dinner> d = new ArrayList<Dinner>();
		for(int i=0 ; i<files.size() ; i++) {
			try (BufferedReader br = new BufferedReader(new FileReader("../recipes/" + files.get(i)))) {
				Dinner dinner = new Dinner(br.readLine());
				d.add(dinner);


				//for(String line; (line = br.readLine()) != null; ) {
					//process the line
				//	System.out.println(line);
				//}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}
		return d;
	}
}
