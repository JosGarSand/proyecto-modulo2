package projectModule2.animals;

import projectModule2.Island.Island;
import projectModule2.Island.Location;

public abstract class Animal {
    protected double weight;
    protected int maxInEachArea;
    protected int speed;
    protected double foodNeeded;
    protected int foodEaten;
    protected boolean isAlive = true;

    public abstract void eat(Location location);

    public abstract void reproduce(Location currentLocation, Island island);

    public abstract void move();
}

