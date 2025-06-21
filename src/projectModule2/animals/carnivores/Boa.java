package projectModule2.animals.carnivores;

import projectModule2.animals.Carnivore;

public class Boa extends Carnivore {
    public Boa(){
        this.weight = 15;
        this.maxInEachArea = 30;
        this.speed = 1;
        this.foodNeeded = 3;
    }

    @Override
    protected Carnivore createBaby() {
        return new Boa();
    }
}
