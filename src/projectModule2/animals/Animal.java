package projectModule2.animals;

public abstract class Animal {
    protected double weight;
    protected int maxInEachArea;
    protected int speed;
    protected double foodNeeded;
    protected int foodEaten;
    protected boolean isAlive = true;

    public abstract void eat();

    public abstract void reproduce();

    public abstract void move();
}

