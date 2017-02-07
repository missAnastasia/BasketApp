package project.plant_hierarchy.ability;

import project.plant_hierarchy.plant.Plant;

import java.math.BigDecimal;

public interface Peeler {

    BigDecimal peelItem(Plant plant);
    BigDecimal peelItems(Plant[] plants);
}
