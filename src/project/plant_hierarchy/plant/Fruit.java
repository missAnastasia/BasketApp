package project.plant_hierarchy.plant;

import java.math.BigDecimal;

public abstract class Fruit extends Plant {

    public Fruit(BigDecimal weight, String color, Ripeness ripeness, boolean condition) {
        super(weight, color, ripeness, condition);
    }

    // Очистка фрукта
    @Override
    public void peel() {

        weight = weight.subtract(weight.multiply(new BigDecimal(0.05)));
        peeled = true;
    }
}
