import java.util.ArrayList;
/*
 * Dinner.java
 *
 * A dinner object. Contains all information about a particular dinner
 *
 * JHC
 * June 2016
 */
public class Dinner {
	private String name;
	private ArrayList<String> tags = new ArrayList<String>();
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private ArrayList<Dinner> derivedDinners= new ArrayList<Dinner>();
	private String cookingInstructions;

	//ctor
	public Dinner(String name, ArrayList<String> tags, ArrayList<Ingredient> ingredients,
			ArrayList<Dinner> derivedDinners, String cookingInstructions) {
		this.name = name;
		this.tags = tags;
		this.ingredients = ingredients;
		this.derivedDinners = derivedDinners;
		this.cookingInstructions = cookingInstructions;
	}

	//print out a dinner object
	@Override
	public String toString() {
		String dinnerString = "";
		dinnerString += "Dinner: " + name;
		dinnerString += "\nTags: ";
		for(int i=0 ; i<tags.size() ; i++) {
			dinnerString += tags.get(i) + " ";
		}
		dinnerString += "\nIngredients:";
		for(int i=0 ; i<ingredients.size() ; i++) {
			dinnerString += "\t" + ingredients.get(i).name + ": " + ingredients.get(i).quantity + "\n";
		}
		dinnerString += "Derived Dinners: ";
		for(int i=0 ; i<derivedDinners.size() ; i++) {
			dinnerString += "\t" + derivedDinners.get(i).name;
		}
		dinnerString += "\nCooking Instructions: \n" + cookingInstructions;;
		return dinnerString;
	}

	//getters
	public String getDinnerName() {return name;}
	public ArrayList<String> getDinnerTags() {return tags;}
	public ArrayList<Ingredient> getDinnerIngredients() {return ingredients;}
	public ArrayList<Dinner> getDerivedDinners() {return derivedDinners;}
	public String getDinnerInstructions() {return cookingInstructions;}
}
