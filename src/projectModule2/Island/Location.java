package projectModule2.Island;

import org.w3c.dom.ls.LSOutput;
import projectModule2.animals.Animal;
import projectModule2.animals.Plant;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private final List<Plant> plants = new CopyOnWriteArrayList<>();
    private final int x, y;

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

    public void removeAnimal(Animal animal) {
        animals.remove( animal );
    }

    public void removePlant(Plant plant) {
        plants.remove( plant );
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

}
