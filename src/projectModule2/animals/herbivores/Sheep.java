package projectModule2.animals.herbivores;

import projectModule2.animals.Herbivore;

public class Sheep extends Herbivore {
    public Sheep(){
        this.weight = 70;
        this.maxInEachArea = 140;
        this.speed = 3;
        this.foodNeeded = 15;
    }

    @Override
    protected Herbivore createBaby() {
        return new Sheep();
    }
}
