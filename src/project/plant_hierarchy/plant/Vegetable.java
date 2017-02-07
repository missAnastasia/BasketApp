package project.plant_hierarchy.plant;

import java.math.BigDecimal;

public abstract class Vegetable extends Plant {

    public Vegetable(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    // Очистка овоща
    @Override
    public void peel() {
        weight = weight.subtract(weight.multiply(new BigDecimal(0.02)));
        peeled = true;
    }
}
