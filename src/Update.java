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
			System.out.println(Dinners.get(i).toString());
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
				String fileName = recipeFiles[i].getName();
				if(fileName.substring(fileName.length()-4).equals(".rec")) {
					recipes.add(fileName);
				}
			}
		}
		return recipes;
	}

	// read the contents of each recipe file into a Dinner object
	private static ArrayList<Dinner> CreateDinnerObjects(ArrayList<String> files) {
		ArrayList<Dinner> ds = new ArrayList<Dinner>();
		for(int i=0 ; i<files.size() ; i++) {
			String dName;
			String[] dTags;
			ArrayList<Ingredient> dIngredients = new ArrayList<Ingredient>();
			String[] dDerivedDinners;
			String dCookingInstructions = "";
			try (BufferedReader br = new BufferedReader(new FileReader("../recipes/" + files.get(i)))) {
				// for each file, create a dinner object

				// read name from file
				dName = br.readLine();

				// read tags from file
				String tagsLine = br.readLine();
				dTags = tagsLine.split(",");
				
				//read ingredients from file
				// first line is BEGIN INGREDIENTS
				String check = br.readLine();
				if(check.equals("BEGIN INGREDIENTS")) {
					check = br.readLine();
					while(!check.equals("END INGREDIENTS")) {
						// create ingredient object for each ingredient
						String[] iqPair = check.split(",");
						if(iqPair[1].equals("~"))
							iqPair[1] = "0";
						Ingredient ing = new Ingredient(iqPair[0], Float.parseFloat(iqPair[1]));
						dIngredients.add(ing);
						check = br.readLine();
					}
				}
				
				// read derived dinners from file
				String derivedLine = br.readLine();
				dDerivedDinners = derivedLine.split(".");
				
				// read cooking instructions from file (here until end of file)
				String instructionLine = "";
				while(true) {
					instructionLine = br.readLine();
					if(instructionLine == null) {break;}
					dCookingInstructions += instructionLine + "\n";
				}
				
				// create dinner object
				Dinner d = new Dinner(dName, dTags, dIngredients, dDerivedDinners, dCookingInstructions);
				ds.add(d);
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}
		return ds;
	}
}
