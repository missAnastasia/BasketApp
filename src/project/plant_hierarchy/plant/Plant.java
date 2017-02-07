package project.plant_hierarchy.plant;

import project.plant_hierarchy.ability.Peelable;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class Plant implements Peelable {

    protected BigDecimal weight; // Вес растения
    protected String color; // Цвет растения
    protected Ripeness ripeness; // Зрелость
    protected boolean peeled; // Очищен

    public Plant(BigDecimal weight, String color, Ripeness ripeness, boolean peeled) {
        this.weight = weight;
        this.color = color;
        this.ripeness = ripeness;
        this.peeled = peeled;
    }

    public BigDecimal getWeight() {
        return weight.round(MathContext.DECIMAL32);
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Ripeness getRipeness() {
        return ripeness;
    }

    public void setRipeness(Ripeness ripeness) {
        this.ripeness = ripeness;
    }

    public boolean isPeeled() {
        return peeled;
    }

    public void setPeeled(boolean peeled) {
        this.peeled = peeled;
    }

    @Override
    public String toString() {
        return  "weight = " + weight.round(MathContext.DECIMAL32) +
                " g., color = " + color +
                ", ripeness = " + ripeness +
                ", peeled = " + peeled;
    }
}
