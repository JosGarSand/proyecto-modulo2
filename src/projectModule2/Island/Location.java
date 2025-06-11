package projectModule2.Island;

import projectModule2.animals.Animal;
import projectModule2.animals.Plant;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private final List<Plant> plants = new CopyOnWriteArrayList<>();
    public int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void addAnimal(Animal animal) {
        animals.add( animal );
    }

    public void addPlant(Plant plant) {
        plants.add( plant );
    }

}
