package projectModule2.base;

public abstract class Animal {
    protected double weight;
    protected int maxInEachArea;
    protected int speed;
    protected double foodNeeded;
    protected int foodEaten;
    protected boolean isAlive = true;

    public void eat(){
        System.out.println("Aquí va el método de comer");
    }

    public void reproduce(){
        System.out.println("Aquí va la lógica para reproducirse");
    }

    public void move(){
        System.out.println("Aquí va la lógica para elegir la dirección de movimiento y moverse");
    }
}

