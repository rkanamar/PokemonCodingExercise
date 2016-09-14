package com.is.codingexercise.serviceprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Pokemonsale {

	public Map<String, Integer> productCount = new ConcurrentHashMap<String, Integer>();
	
	public Map<String, Integer> productCost = null;

	public Map<Integer, Double> productDiscount = null;

	public Double bestPrice = 0.0;

	/**
	 * Initializing the Pokemon Products cost map and discounts map.
	 */
	Pokemonsale() {
		productCost = new HashMap<String, Integer>();
		productCost.put("Pikachu", 6);
		productCost.put("Squirtle", 5);
		productCost.put("Charmander", 5);
		productDiscount = new HashMap<Integer, Double>();
		productDiscount.put(1, 0.0);
		productDiscount.put(2, 10.0);
		productDiscount.put(3, 20.0);
	}

	/**
	 * This method updates the productCount map based on the user selection.
	 * 
	 * @param productQuantities
	 */

	public void insertProductQuantites(Map<String, Integer> productQuantities) {
		this.productCount = productQuantities;
	}

	/**
	 * This Method calculates the bestPrice of the Selected Pokemon Combinations
	 * based on the selected number of products. Ex: - Pikachu -3, Squirtle - 2,
	 * Charmander -2. In the above selection commonNumberCount - 2 (Go to findCommonNumber method to find out this value) 
	 * noOfProducts selection - 3 as three selections are provided, discount - 20% based on
	 * the requirement. During the first iteration, it will execute "if" part
	 * with the discount evaluation and then the Product count will be updated
	 * so the map will become now Pikachu - 1, Squirtle - 0, Charmander - 0. Now
	 * the second iteration will be executed as one more product selection is
	 * left which gets the bestPrice after the calculation. This Method gets
	 * iterated until the products left out which provides the best price
	 * finally.
	 */
	public void calculatePrice() {
		int commonNumberCount = findCommonNumber(productCount);
		int noOfProducts = productCount.size();
		double discount = (productDiscount.get(noOfProducts) / 100);

		if (noOfProducts != 1) {
			double totalAmount = commonNumberCount * productSum(productCount);
			double discountAmount = totalAmount * discount;
			bestPrice += totalAmount - discountAmount;
		} else
			bestPrice += commonNumberCount * productSum(productCount);

		updateProductCount(commonNumberCount);
	}

	/**
	 * This Map removes the products when discount and calculation is evaluated
	 * and iterates for the remaining products calculation.
	 */
	public void updateProductCount(int commonNumberCount) {

		for (String productName : productCount.keySet()) {
			productCount.put(productName, productCount.get(productName) - commonNumberCount);

			if (productCount.get(productName) == 0)
				productCount.remove(productName);
		}

		if (productCount.size() > 0)
			calculatePrice();
	}

	/**
	 * This method returns the sum of selected Pokemons.
	 * 
	 * @param productCount
	 * @return
	 */
	public int productSum(Map<String, Integer> productCount) {
		int productSum = 0;
		for (String productName : productCount.keySet())
			productSum += productCost.get(productName);
		return productSum;
	}

	/**
	 * This method returns common number count of different Pokemon selected
	 * products which helps in evaluating the discounts for the combinations.
	 * Ex: - Pikachu - 3, Squirtle - 2, Charmander - 2. In the above common
	 * number count is 2
	 * 
	 * @param productCount
	 * @return
	 */
	public int findCommonNumber(Map<String, Integer> productCount) {
		TreeSet<Integer> commonNumber = new TreeSet<Integer>(productCount.values());
		return commonNumber.first();
	}

	public static void main(String[] args) {

		Pokemonsale pokemonSale = new Pokemonsale();
		System.out.println("\t\tPOKEMON - SALE");
		System.out.print("" + "\tPokemon for Sale         Price\n" + "\t----------------         -----\n"
				+ "\tPikachu                  $6\n" + "\tSquirtle                 $5\n"
				+ "\tCharmander               $5\n");

		System.out.println();

		System.out.println("\t\tPOKEMON - OFFER");
		System.out.println("" + "\tNumber Of Pokemons Purchased     Discount Amount\n"
				+ "\t----------------------------     ---------------\n"
				+ "\t1                                No Discount\n" + "\t2                                10%\n"
				+ "\t3                                20%\n");

		System.out.println("Please find below the different type of pokemons and make your selection");
		System.out.println("NOTE: PLEASE ENTER THE VALUE AS '0' - IF PARTICULAR POKEMON IS NOT REQUIRED\n");
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter number of pikachus required::: ");
			Integer pikachuCount = sc.nextInt();
			System.out.print("Enter number of Squirtle required::: ");
			Integer squirtleCount = sc.nextInt();
			System.out.print("Enter number of Charmander required:: ");
			Integer charmanderCount = sc.nextInt();

			if (pikachuCount < 0 || squirtleCount < 0 || charmanderCount < 0)
				throw new Exception("INVALID INPUT - PLEASE ENTER VALID INPUT");

			Map<String, Integer> productQuantities = new ConcurrentHashMap<String, Integer>();

			productQuantities.put("Pikachu", pikachuCount);
			productQuantities.put("Squirtle", squirtleCount);
			productQuantities.put("Charmander", charmanderCount);

			pokemonSale.insertProductQuantites(productQuantities);
			pokemonSale.calculatePrice();
			
			System.out.println("\n The Best Price for the selected products is:: " + pokemonSale.bestPrice);
		} catch (Exception e) {
			if (e.getMessage() != null && e.getMessage()!="")
				System.out.println("\n\t" + e.getMessage());
			else
				System.out.println("\n\t INVALID INPUT - PLEASE ENTER VALID INPUT");
		}
	}
}
