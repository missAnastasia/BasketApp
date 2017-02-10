package project.plant_hierarchy.basket;

import project.plant_hierarchy.plant.Fruit;
import project.plant_hierarchy.plant.Plant;
import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;
import java.math.MathContext;

public class Basket {

    private Plant[] basketContent = {}; // Контейнер с содержимым корзины

    public Plant[] getBasketContent(){
        return basketContent;
    }

    private final Plant[] EMPTY_PLANTBASKET = {};

    // Добавление массива растений в корзину
    public void put(Plant[] plants){

        if (plants != null) {

            Plant[] tempArray = new Plant[basketContent.length + plants.length];

            for (int i = 0; i < basketContent.length; i++) {
                tempArray[i] = basketContent[i];
            }

            for (int i = 0; i < plants.length; i++){
                tempArray[basketContent.length + i] = plants[i];
            }

            basketContent = tempArray;
        }
    }

    // Добавление другой наполненной корзины в корзину
    public void put(Basket basket){

        if (basket != null) {
            this.put(basket.basketContent);
        }
    }

    public void put(Plant plant){

        if (plant != null){

            Plant[] tempArray = new Plant[basketContent.length + 1];

            for (int i = 0; i < basketContent.length; i++){
                tempArray[i] = basketContent[i];
            }

            tempArray[basketContent.length] = plant;
            basketContent = tempArray;
        }
    }

    // Извлечение растения из корзины
    public Plant extract(int index) {

        if (index >= 0) {

            Plant temp = basketContent[index];
            Plant[] tempArray = new Plant[basketContent.length - 1];

            for (int i = 0; i < index; i++){
                tempArray[i] = basketContent[i];
            }

            for (int i = index + 1; i < basketContent.length; i++){
                tempArray[i - 1] = basketContent[i];
            }

            basketContent = tempArray;
            return temp;
        } else return null;
    }

    // Извлечение содержимого корзины с удалением в виде массива растений
    public Plant[] extractAll() {

        Plant[] tempArray = basketContent;
        basketContent = EMPTY_PLANTBASKET;
        return tempArray;
    }

    // Извлечение всех фруктов с удалением, содержащихся в корзине, в виде массива фруктов
    public Fruit[] extractAllFruits() {

        int fruitCount = 0;
        for (int i = 0; i < basketContent.length; i++){
            if (basketContent[i] instanceof Fruit){
                fruitCount++;
            }
        }

        Fruit[] resultFruitArray = new Fruit[fruitCount];
        Plant[] tempResultArray = new Plant[basketContent.length - fruitCount];

        int j = 0, k = 0;
        for (int i = 0; i < basketContent.length; i++){
            if (basketContent[i] instanceof Fruit){
                resultFruitArray[j] = (Fruit) basketContent[i];
                j++;
            } else {
                tempResultArray[k] = basketContent[i];
                k++;
            }
        }

        basketContent = tempResultArray;
        return resultFruitArray;
    }

    // Извлечение всех овощей с удалением, содержащихся в корзине, в виде массива овощей
    public Vegetable[] extractAllVegetables() {

        int vegetableCount = 0;
        for (int i = 0; i < basketContent.length; i++){
            if (basketContent[i] instanceof Vegetable){
                vegetableCount++;
            }
        }

        Vegetable[] resultVegetableArray = new Vegetable[vegetableCount];
        Plant[] tempResultArray = new Plant[basketContent.length - vegetableCount];

        int j = 0, k = 0;
        for (int i = 0; i < basketContent.length; i++){
            if (basketContent[i] instanceof Vegetable){
                resultVegetableArray[j] = (Vegetable) basketContent[i];
                j++;
            } else {
                tempResultArray[k] = basketContent[i];
                k++;
            }
        }

        basketContent = tempResultArray;
        return resultVegetableArray;
    }

    // Вес содержимого корзины
    public BigDecimal getBasketWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : basketContent){
            sumWeight = sumWeight.add(i.getWeight());
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вес всех фруктов, содержащихся в корзине
    public BigDecimal getFruitsWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : basketContent){
            if (i instanceof Fruit) {
                sumWeight = sumWeight.add(i.getWeight());
            }
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вес всех овощей, содержащихся в корзине
    public BigDecimal getVegetablesWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : basketContent){
            if (i instanceof Vegetable) {
                sumWeight = sumWeight.add(i.getWeight());
            }
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вывод инф-ции о содержимом корзины
    public void printContent() {
        for (Plant temp : basketContent){
            System.out.println(temp);
        }
    }
}
