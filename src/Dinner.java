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
	private String[] tags;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private String[] derivedDinners;
	private String cookingInstructions;

	//ctor
	public Dinner(String name, String[] tags, ArrayList<Ingredient> ingredients,
			String[] derivedDinners, String cookingInstructions) {
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
		for(int i=0 ; i<tags.length ; i++) {
			dinnerString += tags[i] + ", ";
		}
		dinnerString += "\nIngredients:\n";
		for(int i=0 ; i<ingredients.size() ; i++) {
			dinnerString += "\t" + ingredients.get(i).name + ": " + ingredients.get(i).quantity + "\n";
		}
		dinnerString += "Derived Dinners: ";
		for(int i=0 ; i<derivedDinners.length ; i++) {
			dinnerString += "\t" + derivedDinners[i];
		}
		dinnerString += "\nCooking Instructions: \n" + cookingInstructions;;
		return dinnerString;
	}

	//getters
	public String getDinnerName() {return name;}
	public String[] getDinnerTags() {return tags;}
	public ArrayList<Ingredient> getDinnerIngredients() {return ingredients;}
	public String[] getDerivedDinners() {return derivedDinners;}
	public String getDinnerInstructions() {return cookingInstructions;}
}
