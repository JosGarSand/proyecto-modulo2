package projectModule2.animals.carnivores;

import projectModule2.animals.Carnivore;

public class Eagle extends Carnivore {
    public Eagle(){
        this.weight = 6;
        this.maxInEachArea = 20;
        this.speed = 3;
        this.foodNeeded = 1;
    }

    @Override
    protected Carnivore createBaby() {
        return new Eagle();
    }
}
