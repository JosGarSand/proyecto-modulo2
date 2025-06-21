package projectModule2.animals.herbivores;

import projectModule2.animals.Herbivore;

public class Boar extends Herbivore {
    public Boar(){
        this.weight = 400;
        this.maxInEachArea = 50;
        this.speed = 2;
        this.foodNeeded = 100;
    }
    @Override
    protected Herbivore createBaby() {
        return new Boar();
    }
}
