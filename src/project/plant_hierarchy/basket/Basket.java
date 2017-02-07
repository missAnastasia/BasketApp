package project.plant_hierarchy.basket;

import project.plant_hierarchy.plant.Fruit;
import project.plant_hierarchy.plant.Plant;
import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private ArrayList<Plant> plantBasket = new ArrayList<>(); // Контейнер с содержимым корзины

    public ArrayList<Plant> getPlantBasket() {
        return plantBasket;
    }

    // Добавление массива растений в корзину
    public void put(Plant[] plants){

        if (plants != null) {
            for (int i = 0; i < plants.length; i++) {
                plantBasket.add(plants[i]);
            }
        }
    }

    // Добавление другой наполненной корзины в корзину
    public void put(Basket basket){

        if (basket != null) {
            this.plantBasket.addAll(basket.plantBasket);
        }
    }

    // Извлечение растения из корзины
    public Plant extract(int index) {

        Plant temp = plantBasket.get(index);
        plantBasket.remove(index);
        return temp;
    }

    // Извлечение содержимого корзины с удалением в виде массива растений
    public Plant[] extractAll() {

        Plant[] tempArray = (Plant[]) plantBasket.toArray();
        plantBasket.clear();
        return tempArray;
    }

    // Извлечение всех фруктов с удалением, содержащихся в корзине, в виде массива фруктов
    public Fruit[] extractAllFruits() {

        List<Plant> tempList = new ArrayList<>();
        for (Plant i : plantBasket){
            if (i instanceof Fruit) {
                tempList.add(i);
            }
        }
        plantBasket.removeAll(tempList);
        Fruit[] resultArray = new Fruit[tempList.size()];
        resultArray = tempList.toArray(resultArray);
        return  resultArray;
    }

    // Извлечение всех овощей с удалением, содержащихся в корзине, в виде массива овощей
    public Vegetable[] extractAllVegetables() {

        List<Plant> tempList = new ArrayList<>();
        for (Plant i : plantBasket){
            if (i instanceof Vegetable) {
                tempList.add(i);
            }
        }
        plantBasket.removeAll(tempList);
        Vegetable[] resultArray = new Vegetable[tempList.size()];
        resultArray = tempList.toArray(resultArray);
        return  resultArray;
    }

    // Вес содержимого корзины
    public BigDecimal getBasketWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : plantBasket){
            sumWeight = sumWeight.add(i.getWeight());
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вес всех фруктов, содержащихся в корзине
    public BigDecimal getFruitsWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : plantBasket){
            if (i instanceof Fruit) {
                sumWeight = sumWeight.add(i.getWeight());
            }
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вес всех овощей, содержащихся в корзине
    public BigDecimal getVegetablesWeight() {

        BigDecimal sumWeight = new BigDecimal(0.0);

        for (Plant i : plantBasket){
            if (i instanceof Vegetable) {
                sumWeight = sumWeight.add(i.getWeight());
            }
        }
        return sumWeight.round(MathContext.DECIMAL32);
    }

    // Вывод инф-ции о содержимом корзины
    public void printContent() {
        for (Plant temp : plantBasket){
            System.out.println(temp);
        }
    }
}
