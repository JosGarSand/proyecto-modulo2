package projectModule2.Island;

import projectModule2.animals.Animal;
import projectModule2.animals.carnivores.*;
import projectModule2.animals.herbivores.*;

import java.util.HashMap;
import java.util.Map;


public class FoodProbability {
    private static final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> table = new HashMap<>();

    static {
        //Dieta de Lobo
        Map<Class<? extends Animal>, Integer> wolfDiet = new HashMap<>();
        wolfDiet.put( Horse.class, 10 );
        wolfDiet.put( Deer.class, 15 );
        wolfDiet.put( Rabbit.class, 60 );
        wolfDiet.put( Mouse.class, 40 );
        wolfDiet.put( Goat.class, 60 );
        wolfDiet.put( Sheep.class, 70 );
        wolfDiet.put( Boar.class, 15 );
        wolfDiet.put( Duck.class, 40 );
        table.put( Wolf.class, wolfDiet );

        //Dieta de Boa
        Map<Class<? extends Animal>,Integer > boaDiet = new HashMap<>();
        boaDiet.put( Fox.class, 15 );
        boaDiet.put( Rabbit.class, 20 );
        boaDiet.put( Mouse.class, 40 );
        boaDiet.put( Duck.class, 10 );
        table.put( Boa.class, boaDiet );

        //Dieta de Fox
        Map<Class<? extends Animal>, Integer> foxDiet = new HashMap<>();
        foxDiet.put( Rabbit.class, 70 );
        foxDiet.put( Mouse.class, 90 );
        foxDiet.put( Duck.class, 60 );
        table.put( Fox.class, foxDiet );

        //Dieta de Bear
        Map<Class<? extends Animal>, Integer> bearDiet = new HashMap<>();
        bearDiet.put( Boa.class, 80 );
        bearDiet.put( Horse.class, 40 );
        bearDiet.put( Deer.class, 80 );
        bearDiet.put( Rabbit.class, 80 );
        bearDiet.put( Mouse.class, 90 );
        bearDiet.put( Goat.class, 70 );
        bearDiet.put( Sheep.class, 70 );
        bearDiet.put( Boar.class, 50 );
        bearDiet.put( Duck.class, 10 );
        table.put( Bear.class, bearDiet );

        //Dieta de Eagle
        Map<Class<? extends Animal>, Integer> eagleDiet = new HashMap<>();
        eagleDiet.put( Fox.class, 10 );
        eagleDiet.put( Rabbit.class, 90 );
        eagleDiet.put( Mouse.class, 90 );
        eagleDiet.put( Duck.class, 80 );
        table.put( Eagle.class, eagleDiet );

        //Dieta de Duck (orugas)
        Map<Class<? extends Animal>, Integer> duckDiet = new HashMap<>();
        duckDiet.put( Caterpillar.class, 90 );
        table.put( Duck.class, duckDiet );

        //Dieta de Boar (orugas)
        Map<Class<?extends Animal >, Integer > boarDiet = new HashMap<>();
        boarDiet.put( Caterpillar.class, 90 );
        table.put( Boar.class, boarDiet );
    }

    public static int getProbability(Class<? extends Animal> predator, Class<? extends Animal> prey){
        Map<Class<? extends Animal>, Integer> preyMap = table.get(predator);
        if (preyMap != null){
            return preyMap.getOrDefault( prey, 0);
        }
        return 0;

    }



}