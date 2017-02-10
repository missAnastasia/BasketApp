package project.plant_hierarchy.foodprocessor;

import project.plant_hierarchy.ability.Cutter;
import project.plant_hierarchy.ability.Peeler;
import project.plant_hierarchy.ability.Slicer;
import project.plant_hierarchy.plant.Plant;
import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;

public class FoodProcessor implements Peeler, Cutter, Slicer {

    // Peeling of single plant. Returns weight of peeled plant
    @Override
    public BigDecimal peelItem(Plant plant) {

        if (plant != null) {

            if (plant.isPeeled()){
                return plant.getWeight();
            } else {
                plant.peel();
                return plant.getWeight();
            }
        } else
            return new BigDecimal(0.0);
    }

    // Peeling of array of plants. Returns summary weight of peeled plants
    @Override
    public BigDecimal peelItems(Plant[] plants) {

        BigDecimal summaryWeight = new BigDecimal(0.0);

        if (plants != null) {

            for (int i = 0; i < plants.length; i++) {

                if (plants[i].isPeeled()){
                    summaryWeight = summaryWeight.add(plants[i].getWeight());
                } else {
                    plants[i].peel();
                    summaryWeight = summaryWeight.add(plants[i].getWeight());
                }
            }
        }
        return summaryWeight;
    }

    // Cutting of single vegetable. Returns weight of cuted vegetable
    // If plant is unpeeled, throws IllegalArgumentException
    @Override
    public BigDecimal cut(Vegetable vegetable) {

        if (vegetable != null) {

            if (vegetable.isPeeled()) {
                vegetable.setWeight(vegetable.getWeight()
                        .subtract(vegetable.getWeight()
                                .multiply(new BigDecimal(0.02))));
                return vegetable.getWeight();
            } else
                throw new IllegalArgumentException("UNPEELED VEGETABLE!");
        } else
            return new BigDecimal(0.0);
    }

    // Cutting of array of vegetables. Returns summary weight of cuted plants
    // If any plant is unpeeled, throws IllegalArgumentException
    @Override
    public BigDecimal cutAll(Vegetable[] vegetables) {

        BigDecimal summaryWeight = new BigDecimal(0.0);

        if (vegetables != null) {

            for (Vegetable temp : vegetables) {

                if (temp.isPeeled()) {
                    temp.setWeight(temp.getWeight()
                            .subtract(temp.getWeight()
                                    .multiply(new BigDecimal(0.02))));
                    summaryWeight = summaryWeight.add(temp.getWeight());
                } else
                    throw new IllegalArgumentException("UNPEELED VEGETABLES!");
            }
        }
        return summaryWeight;
    }

    // Slicing of single plant. Returns weight of sliced plant
    // If plant is unpeeled, throws IllegalArgumentException
    @Override
    public BigDecimal slice(Plant plant) {

        if (plant != null) {
            if (plant.isPeeled()) {
                plant.setWeight(plant.getWeight()
                        .subtract(plant.getWeight()
                                .multiply(new BigDecimal(0.02))));
                return plant.getWeight();
            } else {
                throw new IllegalArgumentException("UNPEELED PLANT!");
            }
        } else
            return new BigDecimal(0.0);
    }

    // Slicing of array of plants. Returns summary weight of sliced plants
    // If any plant is unpeeled, throws IllegalArgumentException
    @Override
    public BigDecimal sliceAll(Plant[] plants) {

        BigDecimal summaryWeight = new BigDecimal(0.0);

        if (plants != null) {

            for (Plant temp : plants) {

                if (temp.isPeeled()) {
                    temp.setWeight(temp.getWeight()
                            .subtract(temp.getWeight()
                                    .multiply(new BigDecimal(0.02))));
                    summaryWeight = summaryWeight.add(temp.getWeight());
                } else
                    throw new IllegalArgumentException("UNPEELED PLANTS!");
            }
        }
        return summaryWeight;
    }
}
