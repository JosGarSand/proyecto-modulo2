package projectModule2.animals;

import projectModule2.Island.Island;
import projectModule2.Island.Location;

public abstract class Animal {
    protected double weight;
    protected int maxInEachArea;
    protected int speed;
    protected double foodNeeded;
    protected double foodEaten;
    protected boolean alive = true;

    public boolean isAlive() {
        return alive;
    }



    public abstract void eat(Location location);

    public abstract void reproduce(Location currentLocation, Island island);

    public abstract void move(Location location);
}

