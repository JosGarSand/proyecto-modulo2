package projectModule2.base.herbivores;

import projectModule2.base.Herbivore;

public class Mouse extends Herbivore {
    public Mouse(){
        this.weight = 0.05;
        this.maxInEachArea = 500;
        this.speed = 1;
        this.foodNeeded = 0.01;
    }
}
