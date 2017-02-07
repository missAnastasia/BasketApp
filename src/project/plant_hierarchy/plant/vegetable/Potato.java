package project.plant_hierarchy.plant.vegetable;

import project.plant_hierarchy.plant.Ripeness;
import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;

public class Potato extends Vegetable {

    public Potato(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    @Override
    public String toString() {
        return "Potato { " + super.toString() + " }";
    }
}
