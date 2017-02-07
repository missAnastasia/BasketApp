package project.plant_hierarchy.plant.vegetable;

import project.plant_hierarchy.plant.Ripeness;
import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;

public class Carrot extends Vegetable {

    public Carrot(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    @Override
    public String toString() {
        return "Carrot { " + super.toString() + " }";
    }
}
