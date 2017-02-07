package project.plant_hierarchy.ability;

import project.plant_hierarchy.plant.Plant;

import java.math.BigDecimal;

public interface Slicer {

    BigDecimal slice(Plant plant);
    BigDecimal sliceAll(Plant[] plants);
}
