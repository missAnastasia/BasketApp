package project.plant_hierarchy;

import project.plant_hierarchy.basket.Basket;
import project.plant_hierarchy.foodprocessor.FoodProcessor;
import project.plant_hierarchy.plant.Fruit;
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

        // Создание объектов фруктов и овощей
        Apple appleRp = new Apple(new BigDecimal(150.5), "red", Ripeness.RIPE, false);
        Banana bananaRp = new Banana(new BigDecimal(175.4), "yellow", Ripeness.RIPE, false);
        Orange orangeVerd = new Orange(new BigDecimal(200.0), "yellow", Ripeness.VERDANT, false);
        Orange orangeRp = new Orange(new BigDecimal(210.2), "orange", Ripeness.RIPE, false);
        Pear pearVerd = new Pear(new BigDecimal(180.9), "green", Ripeness.VERDANT, false);

        Carrot carrotRp = new Carrot(new BigDecimal(100.9), "orange", Ripeness.RIPE, false);
        Celery celeryVerd = new Celery(new BigDecimal(200.0), "green", Ripeness.VERDANT, false);
        Onion onionRp = new Onion(new BigDecimal(90.9), "white", Ripeness.RIPE, true);
        Potato potatoRp = new Potato(new BigDecimal(105.8), "brown", Ripeness.RIPE, false);

        // Создание массива фруктов
        Fruit[] fruits = {appleRp, bananaRp, orangeVerd, orangeRp, pearVerd};

        // Создание массива овощей
        Vegetable[] vegetables = {carrotRp, celeryVerd, onionRp, potatoRp};

        // Создание кухонного комбайна
        FoodProcessor foodProcessor = new FoodProcessor();

        System.out.println("        FRUITS&VEGETABLES\n\n");

        // Создание общей корзины
        Basket basket = new Basket();

        // Наполнение корзины массивом овощей
        basket.put(vegetables);

        System.out.println("Basket contains:");
        basket.printContent();
        System.out.println("\nBasket weight: " + basket.getBasketWeight() + " g.");

        // Создание корзины фруктов
        Basket fruitsBasket = new Basket();

        // Наполнение корзины массивом фруктов
        fruitsBasket.put(fruits);

        // Объединение корзины фруктов с общей корзиной
        basket.put(fruitsBasket);

        System.out.println("\nBasket contains:");
        basket.printContent();
        System.out.println("\nBasket weight: " + basket.getBasketWeight() + " g.");

        System.out.println("\n\n        PEELING FRUITS:\n");

        // Вес общей корзины
        BigDecimal oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Вес фруктов в общей корзине
        BigDecimal oldFruitsWeight = basket.getFruitsWeight();
        System.out.println("Fruits weight before peeling: " + oldFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Извлечение всех фруктов из общей корзины
        Fruit[] fruitsToProcess = basket.extractAllFruits();

        // Вес фруктов после очистки
        BigDecimal newFruitsWeight = foodProcessor.peelItems(fruitsToProcess);
        System.out.println("Fruits weight after peeling: " + newFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Помещение очищенных фруктов обратно в общую корзину
        basket.put(fruitsToProcess);
        BigDecimal newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after fruits peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Разница в весе
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        PEELING VEGETABLES:\n");

        // Текущий вес общей корзины
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Вес овощей в общей корзине
        BigDecimal oldVegetablesWeight = basket.getVegetablesWeight();
        System.out.println("Vegetables weight before peeling: " + oldVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Извлечение всех овощей из общей корзины
        Vegetable[] vegetablesToProcess = basket.extractAllVegetables();

        // Вес овощей после очистки
        BigDecimal newVegetablesWeight = new BigDecimal(0.0);

        try {
            newVegetablesWeight = foodProcessor.peelItems(vegetablesToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vegetables weight after peeling: " + newVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Помещение очищенных фруктов обратно в корзину
        basket.put(vegetablesToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after vegetables peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Разница в весе
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        CUTTING VEGETABLES:\n");

        // Текущий вес общей корзины
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Текущий вес овощей в общей корзине
        oldVegetablesWeight = basket.getVegetablesWeight();
        System.out.println("Vegetables weight before peeling: " + oldVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Извлечение овощей из общей корзины
        vegetablesToProcess = basket.extractAllVegetables();

        try {
            // Вес после шинковки извлеченных овощей
            newVegetablesWeight = foodProcessor.cutAll(vegetablesToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vegetables weight after peeling: " + newVegetablesWeight.round(MathContext.DECIMAL32) + " g.");

        // Помещение нашинкованных овощей в корзину
        basket.put(vegetablesToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after vegetables peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Разница в весе
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        SLICING FRUITS:\n");

        // Текущий вес общей корзины
        oldBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight before fruits peeling: " + oldBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Текущий вес фруктов в общей корзине
        oldFruitsWeight = basket.getFruitsWeight();
        System.out.println("Fruits weight before peeling: " + oldFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Извлечение фруктов из общей корзины
        fruitsToProcess = basket.extractAllFruits();

        try {
            // Вес после нарезки извлеченных фруктов
            newFruitsWeight = foodProcessor.sliceAll(fruitsToProcess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fruits weight after peeling: " + newFruitsWeight.round(MathContext.DECIMAL32) + " g.");

        // Помещение нарезанных фруктов в корзину
        basket.put(fruitsToProcess);
        newBasketWeight = basket.getBasketWeight();
        System.out.println("Basket weight after fruits peeling: " + newBasketWeight.round(MathContext.DECIMAL32) + " g.");

        // Разница в весе
        System.out.println("Weight difference: " + (oldBasketWeight.subtract(newBasketWeight)).round(MathContext.DECIMAL32) + " g.");

        System.out.println("\n\n        NEW POTATO PROCESSING\n");

        // Создание нового объекта картофеля
        Potato potatoRpPink = new Potato(new BigDecimal(120.9), "pink", Ripeness.RIPE, false);
        System.out.println(potatoRpPink);

        // Вес картофеля
        BigDecimal oldPotatoWeight = potatoRpPink.getWeight();

        try {
            // Шинковка картофеля
            foodProcessor.cut(potatoRpPink);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Potato weight after cutting: " + potatoRpPink.getWeight() + " g.");

        // Разница в весе
        System.out.println("Weight difference: " + (oldPotatoWeight.subtract(potatoRpPink.getWeight())).round(MathContext.DECIMAL32) + " g.");


    }
}
