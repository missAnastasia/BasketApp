package project.plant_hierarchy.ability;

import project.plant_hierarchy.plant.Vegetable;

import java.math.BigDecimal;

public interface Cutter {

    BigDecimal cut(Vegetable vegetable);
    BigDecimal cutAll(Vegetable[] vegetables);
}
