package com.is.codingexercise.serviceprovider;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Pokemontest {
	
	public Map<String, Integer> productCount;
	public Pokemonsale pokemonSale = null;
	
    @Before
    public void setUp() {
    	productCount = new ConcurrentHashMap<String, Integer>();
    	pokemonSale = new Pokemonsale();	
    }
    
    @Test
    public void calculatePriceForSingleProdSingleItem() {
        productCount.put("Pikachu", 1);
        Double expResult = 6.0;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
        }

    @Test
    public void calculatePriceForSingleProdTestOne()
    {
         productCount.put("Squirtle", 1);
         Double expResult = 5.0;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calculatePriceForSingleProdTestTwo()
    {
         productCount.put("Charmander", 1);
         Double expResult = 5.0;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForSingleProdTwoItems()
    {
    	//productCount = new ConcurrentHashMap<String, Integer>();
         productCount.put("Pikachu", 2);
         Double expResult = 12.0;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForSingleProdWithTwoItemsOne()
    {
         productCount.put("Squirtle", 2);
         Double expResult = 10.0;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForSingleProdWithTwoItemsTwo()
    {
         productCount.put("Charmander", 2);
         Double expResult = 10.0;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForTwoProducts() {
    	 productCount.put("Pikachu", 1);
    	 productCount.put("Squirtle", 1);
         Double expResult = 9.90;
         pokemonSale.insertProductQuantites(productCount);
         pokemonSale.calculatePrice();
         assertEquals(expResult, pokemonSale.bestPrice);
    }

    @Test
    public void calcPriceForTwoProductsOne() {
    	productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 1);
        Double expResult = 9.0;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForTwoProductsTwo() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Charmander", 1);
        Double expResult = 9.90;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }

    @Test
    public void priceForTwoProdWithDiffCombOne() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Squirtle", 2);
        Double expResult = 19.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombTwo() {
    	productCount.put("Pikachu", 3);
   	    productCount.put("Squirtle", 3);
        Double expResult = 29.70;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombThree() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Charmander", 2);
        Double expResult = 19.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombFour() {
    	productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 2);
        Double expResult = 18.0;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombFive() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Squirtle", 2);
        Double expResult = 14.9;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombSix() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Squirtle", 1);
        Double expResult = 15.9;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombSeven() {
    	productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 2);
        Double expResult = 14.0;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
   
    @Test
    public void priceForTwoProdWithDiffCombEight() {
    	productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 1);
        Double expResult = 14.0;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
   
    @Test
    public void priceForTwoProdWithDiffCombNine() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Charmander", 2);
        Double expResult = 14.9;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForTwoProdWithDiffCombTen() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Charmander", 1);
        Double expResult = 15.9;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void calcPriceForThreeProd() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 1);
        Double expResult = 12.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombOne() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 1);
        Double expResult = 18.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombTwo() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 2);
        Double expResult = 17.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombThree() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 1);
        Double expResult = 17.80; 
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombFour() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 1);
        Double expResult = 22.700000000000003;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult,pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombFive() {
    	productCount.put("Pikachu", 2);
   	    productCount.put("Squirtle", 1);
   	    productCount.put("Charmander", 2);
        Double expResult = 22.700000000000003;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult,pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombSix() {
    	productCount.put("Pikachu", 1);
   	    productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 2);
        Double expResult = 21.80;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @Test
    public void priceForThreeProdWithDiffCombSeven() {
    	productCount.put("Pikachu", 4);
   	    productCount.put("Squirtle", 2);
   	    productCount.put("Charmander", 3);
        Double expResult = 41.50;
        pokemonSale.insertProductQuantites(productCount);
        pokemonSale.calculatePrice();
        assertEquals(expResult, pokemonSale.bestPrice);
    }
    
    @After
    public void tearDown() {
        productCount = null;
        pokemonSale = null;
    }

}
