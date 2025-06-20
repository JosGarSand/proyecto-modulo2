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
    public void move(Location currentLocation, Island island) {
        int x = currentLocation.getx();
        int y = currentLocation.gety();

        List<Location> possible = new ArrayList<>();

        for (int dX = -speed; dX <= speed; dX++){
            for (int dY = -speed; dY <= speed; dY++){
                //Si es en la misma posicion, saltar en su lugar, para que no se "mueva" a su lugar
                if (dX == 0 && dY == 0) continue;

                int newX = x + dX;
                int newY = y + dY;
                Location destination = island.getLocation( newX, newY );

                if (destination != null) {
                    long countSameType = 0;
                    for (Animal actual : destination.getAnimals()){
                        if(actual.getClass() == this.getClass()){
                            countSameType++;
                            if (countSameType < maxInEachArea){
                                possible.add(destination);
                            }
                        }
                    }
                }
            }
        }

        //Si hay algun lugar valido, moverse a alguno al azar
        if (!possible.isEmpty()){
            Location destination = possible.get(new Random().nextInt(possible.size()));

            //Quitar de la ubicacion actual y mover a la nueva
            currentLocation.removeAnimal( this );
            destination.addAnimal( this );
        }


    }
    @Override
    public void reproduce(Location currentLocation, Island island) {

    }


}

