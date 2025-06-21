package projectModule2.animals;

import projectModule2.Island.FoodProbability;
import projectModule2.Island.Island;
import projectModule2.Island.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Herbivore extends Animal {
    protected abstract Herbivore createBaby();

    @Override
    public void eat(Location location) {

        //Comer plantas
        List<Plant> plants = new ArrayList<>(location.getPlants());
        for (Plant plant : plants) {
            double foodLeft = foodNeeded - foodEaten;
            double consumed = Math.min(plant.weight, foodLeft);

            foodEaten += consumed;
            location.removePlant(plant);

            if (foodEaten >= foodNeeded) return;
        }

        //Comer orugas si aplica
        if (foodEaten < foodNeeded) {

            List<Animal> animals = new ArrayList<>(location.getAnimals());
            for (Animal prey : animals) {
                if (prey == this || !prey.isAlive()) continue;

                int chance = FoodProbability.getProbability(this.getClass(), prey.getClass());

                if (chance > 0 && new Random().nextInt(100) < chance) {
                    double preyWeight = prey.weight;
                    double foodLeft = foodNeeded - foodEaten;
                    double consumed = Math.min(preyWeight, foodLeft);

                    foodEaten += consumed;
                    prey.alive = false;
                    location.removeAnimal(prey);

                    if (foodEaten >= foodNeeded) break;
                }
            }
        }

        //Evalua si sobrevive o muere de hambre
        if (foodEaten >= foodNeeded) {
            hungerCycles = 0;
        } else {
            hungerCycles++;
            if (hungerCycles >= maxHungerCycles) {
                alive = false;
                location.removeAnimal(this);
            }
        }
        foodEaten = 0;
    }

    @Override
    public void move(Location currentLocation, Island island) {
        int x = currentLocation.getx();
        int y = currentLocation.gety();

        List<Location> possibleLocations = new ArrayList<>();

        for (int dx = -speed; dx <= speed; dx++) {
            for (int dy = -speed; dy <= speed; dy++) {
                //Si es en la misma posicion, saltar en su lugar, para que no se "mueva" a su lugar
                if (dx == 0 && dy == 0) continue;

                int newX = x + dx;
                int newY = y + dy;
                Location destination = island.getLocation(newX, newY);

                if (destination != null) {
                    long countSameType = 0;
                    for (Animal actual : destination.getAnimals()) {
                        if (actual.getClass() == this.getClass()) {
                            countSameType++;

                        }
                    }
                    if (countSameType < maxInEachArea) {
                        possibleLocations.add(destination);
                    }
                }
            }
        }

        //Si hay algun lugar valido, moverse a alguno al azar
        if (!possibleLocations.isEmpty()) {
            Location destination = possibleLocations.get(new Random().nextInt(possibleLocations.size()));

            //Quitar de la ubicacion actual y mover a la nueva
            currentLocation.removeAnimal(this);
            destination.addAnimal(this);
        }
    }

    @Override
    public void reproduce(Location currentLocation, Island island) {
        int sameTypeAlive = 0;
        int sameTypeTotal = 0;

        List<Animal> animals = currentLocation.getAnimals();

        for (Animal animal : animals) {
            if (animal.getClass() == this.getClass()) {
                sameTypeTotal++;
                if (animal.isAlive()) {
                    sameTypeAlive++;
                }
            }
        }

        if (sameTypeAlive >= 2 && sameTypeTotal < maxInEachArea) {
            Animal baby = createBaby();
            currentLocation.addAnimal(baby);
        }
    }
}
