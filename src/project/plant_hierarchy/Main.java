package project.plant_hierarchy;

import project.plant_hierarchy.basket.Basket;
import project.plant_hierarchy.foodprocessor.FoodProcessor;
import project.plant_hierarchy.plant.Fruit;
import project.plant_hierarchy.plant.Plant;
import project.plant_hierarchy.plant.Ripeness;
import project.plant_hierarchy.plant.Vegetable;
import project.plant_hierarchy.plant.fruit.Apple;
import project.plant_hierarchy.plant.fruit.Banana;
import project.plant_hierarchy.plant.fruit.Orange;
import project.plant_hierarchy.plant.fruit.Pear;
import project.plant_hierarchy.plant.vegetable.Carrot;
import project.plant_hierarchy.plant.vegetable.Celery;
import project.plant_hierarchy.plant.vegetable.Onion;
import project.plant_hierarchy.plant.vegetable.Potato;

import java.math.BigDecimal;
import java.math.MathContext;

public class Main {

    public static void main(String[] args) {

        // Fruits and vegetables creation
        Apple appleRp = new Apple(new BigDecimal(150.5), "red", Ripeness.RIPE, false);
        Banana bananaRp = new Banana(new BigDecimal(175.4), "yellow", Ripeness.RIPE, false);
        Orange orangeVerd = new Orange(new BigDecimal(200.0), "yellow", Ripeness.VERDANT, false);
        Orange orangeRp = new Orange(new BigDecimal(210.2), "orange", Ripeness.RIPE, false);
        Pear pearVerd = new Pear(new BigDecimal(180.9), "green", Ripeness.VERDANT, false);

        Carrot carrotRp = new Carrot(new BigDecimal(100.9), "orange", Ripeness.RIPE, false);
        Celery celeryVerd = new Celery(new BigDecimal(200.0), "green", Ripeness.VERDANT, false);
        Onion onionRp = new Onion(new BigDecimal(90.9), "white", Ripeness.RIPE, true);
        Potato potatoRp = new Potato(new BigDecimal(105.8), "brown", Ripeness.RIPE, false);

        // Main array of plants creation
        Plant[] basketContent = {carrotRp, orangeVerd, bananaRp, celeryVerd};

        // Extra array  of plants creation
        Plant[] additionalBasketContent = {onionRp, appleRp, orangeRp, pearVerd, potatoRp};

        // Food processor creation
        FoodProcessor foodProcessor = new FoodProcessor();

        System.out.println("        FRUITS&VEGETABLES\n\n");

        // Total basket creation
        Basket basket = new Basket();

        // Filling the total basket by the main array of plants
        basket.put(basketContent);

        System.out.println("Basket contains:");
        basket.printContent();
        System.out.println("\nBasket weight: " + basket.getBasketWeight() + " g.");

        // Extra basket creation
        Basket additionalBasket = new Basket();

        // Filling the extra basket by the extra array of plants
        additionalBasket.put(additionalBasketContent);

        // Combining total and extra baskets
        basket.put(additionalBasket);

        System.out.println("\nBasket contains:");
        basket.printContent();
        System.out.println("\nBasket weight: " + basket.getBasketWeight() + " g.");

        System.out.println("\n\n        PEELING FRUITS:\n");

        // Weight of total basket
        BigDecimal oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight of all fruits in total basket
        BigDecimal oldFruitsWeight = basket.getFruitsWeight();
        System.out.println("Fruits weight before peeling: " + oldFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Extracting of all fruits from total basket
        Fruit[] fruitsToProcess = basket.extractAllFruits();

        // Weight of fruits after peeling
        BigDecimal newFruitsWeight = foodProcessor.peelItems(fruitsToProcess);
        System.out.println("Fruits weight after peeling: " + newFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Insertion of peeled fruits back to total basket
        basket.put(fruitsToProcess);
        BigDecimal newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after fruits peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        PEELING VEGETABLES:\n");

        // Current weight of total basket
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before vegetables peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight of all vegetables in total basket
        BigDecimal oldVegetablesWeight = basket.getVegetablesWeight();
        System.out.println("Vegetables weight before peeling: " + oldVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Extracting of all vegetables from total basket
        Vegetable[] vegetablesToProcess = basket.extractAllVegetables();

        // Weight of vegetables after peeling
        BigDecimal newVegetablesWeight = new BigDecimal(0.0);

        try {
            newVegetablesWeight = foodProcessor.peelItems(vegetablesToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vegetables weight after peeling: " + newVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Insertion of peeled vegetables back to total basket
        basket.put(vegetablesToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after vegetables peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        CUTTING VEGETABLES:\n");

        // Current weight of total basket
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before vegetables cutting: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Current weight of vegetables in total basket
        oldVegetablesWeight = basket.getVegetablesWeight();
        System.out.println("Vegetables weight before cutting: " + oldVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Extracting of all vegetables from total basket
        vegetablesToProcess = basket.extractAllVegetables();

        try {
            // Weight of vegetables after cutting
            newVegetablesWeight = foodProcessor.cutAll(vegetablesToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vegetables weight after cutting: " + newVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Insertion of cuted vegetables back to total basket
        basket.put(vegetablesToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after vegetables cutting: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        SLICING FRUITS:\n");

        // Current weight of total basket
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits slicing: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Current weight of fruits in total basket
        oldFruitsWeight = basket.getFruitsWeight();
        System.out.println("Fruits weight before slicing: " + oldFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Extracting of all fruits from total basket
        fruitsToProcess = basket.extractAllFruits();

        try {
            // Weight of fruits after slicing
            newFruitsWeight = foodProcessor.sliceAll(fruitsToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fruits weight after slicing: " + newFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Insertion of sliced fruits back to total basket
        basket.put(fruitsToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after fruits slicing: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        NEW PLANT SLICING\n");

        // New plant creation
        Potato potatoRpPink = new Potato(new BigDecimal(120.9), "pink", Ripeness.RIPE, false);

        // Insertion to the end of total basket
        basket.put(potatoRpPink);
        System.out.println("Basket contains:");
        basket.printContent();
        System.out.println("\nBasket weight: " + basket.getBasketWeight() + " g.\n");

        // Current weight of total basket
        oldBasketWeight = basket.getBasketWeight();

        // Extraction element from the end of total basket
        Plant lastInBasket = basket.extract(basket.getBasketContent().length - 1);

        // Weight of plant before slicing
        BigDecimal oldlastInBasketWeight = lastInBasket.getWeight();
        BigDecimal newLastInBasketWeight = new BigDecimal(0.0);

        System.out.println(lastInBasket);

        try {
            // Weight of plant after slicing
            newLastInBasketWeight = foodProcessor.slice(lastInBasket);
        } catch (IllegalArgumentException e) {
            newLastInBasketWeight = lastInBasket.getWeight();
            System.out.println(e.getMessage());
        }

        System.out.println("Plant weight after slicing: " + newLastInBasketWeight + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldlastInBasketWeight.subtract(newLastInBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        // Insertion of sliced plant back to total basket
        basket.put(lastInBasket);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after last element slicing: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Weight difference
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");


    }
}
