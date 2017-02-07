package project.plant_hierarchy.plant.fruit;

import project.plant_hierarchy.plant.Fruit;
import project.plant_hierarchy.plant.Ripeness;

import java.math.BigDecimal;

public class Banana extends Fruit {

    public Banana(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    @Override
    public String toString() {
        return "Banana { " + super.toString() + " }";
    }
}
