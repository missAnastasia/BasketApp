package project.plant_hierarchy.plant.fruit;

import project.plant_hierarchy.plant.Fruit;
import project.plant_hierarchy.plant.Ripeness;

import java.math.BigDecimal;

public class Pear extends Fruit {

    public Pear(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    @Override
    public String toString() {
        return "Pear { " + super.toString() + " }";
    }
}
