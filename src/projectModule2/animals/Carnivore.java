package projectModule2.animals;

import projectModule2.Island.FoodProbability;
import projectModule2.Island.Island;
import projectModule2.Island.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carnivore extends Animal {
    @Override
    public void eat(Location location) {
        List<Animal> animals = new ArrayList<>(location.getAnimals());

        for (Animal prey : animals){
            if (prey == this || !prey.isAlive()) continue;

            int chance = FoodProbability.getProbability( this.getClass(), prey.getClass() );

            if (chance > 0 && new Random().nextInt(100) < chance){
                double preyWeight = prey.weight;
                double foodLeft = foodNeeded - foodEaten;
                double consumed = Math.min(preyWeight, foodLeft);

                foodEaten += consumed;
                prey.alive = false;
                location.removeAnimal( prey );

                if (foodEaten >= foodNeeded) break;
            }
        }
    }

    @Override
    public void reproduce(Location currentLocation, Island island) {

    }

    @Override
    public void move(Location location) {

    }
}

