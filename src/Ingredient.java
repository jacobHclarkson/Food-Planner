/*
 * Ingredient.java
 *
 * Ingredient object. Basically a <name, quantity> tuple
 *
 * JHC
 * June 2016
 */

public class Ingredient {
	public String name;
	public Float quantity;

	public Ingredient(String name, Float quantity) {
		this.name = name;
		this.quantity = quantity;
	}
}
