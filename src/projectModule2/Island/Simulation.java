package projectModule2.Island;

import projectModule2.animals.Animal;

import java.util.List;
import java.util.concurrent.*;

public class Simulation {
    private final Island island;
    private final ScheduledExecutorService scheduler;

    public Simulation(Island island) {
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(3);
    }

    public void start() {
        printGreen("Simulacion iniciada...");
        //Acciones de animales
        scheduler.scheduleAtFixedRate(new AnimalTask(), 0, 2, TimeUnit.SECONDS);
        //Acciones de plantas
        scheduler.scheduleAtFixedRate(new PlantTask(), 0, 4, TimeUnit.SECONDS);
        //Mostrar estadisticas
        scheduler.scheduleAtFixedRate(new StatsTask(), 0, 2, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            ;
        }
    }

    private class AnimalTask implements Runnable {
        private final ExecutorService animalThreadPool = Executors.newScheduledThreadPool(10);

        public void run() {
            printYellow("[Animales] ejecutando acciones (comer, moverse, reproducirse)...");
            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Location location = island.getLocation(x, y);

                    List<Animal> animals = new CopyOnWriteArrayList<>(location.getAnimals());

                    for (Animal animal : animals) {
                        if (!animal.isAlive()) continue;
                        animalThreadPool.submit(new Runnable() {
                            @Override
                            public void run() {
                                animal.eat(location);
                                animal.move(location, island);
                                animal.reproduce(location, island);
                            }
                        });
                    }
                }
            }
        }
    }

    private class PlantTask implements Runnable {
        public void run() {
            printGreen("[Plantas] ejecutando acciones (crecer)...");
            //Falta implementar agregar plantas si hay espacio
        }
    }

    private class StatsTask implements Runnable {
        public void run() {
            System.out.println("[Mapa] Estado actual de la isla");
            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Location location = island.getLocation(x, y);
                    int animals = location.getAnimals().size();
                    int plants = location.getPlants().size();

                    // 🐾 = animal, 🌿 = planta, . = vacío
                    String cell = ".";
                    if (animals > 0 && plants > 0) {
                        cell = "🐾🌿";
                    } else if (animals > 0) {
                        cell = "🐾";
                    } else if (plants > 0) {
                        cell = "🌿";
                    }

                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            System.out.println("=".repeat(60));
        }
    }

    private void printGreen(String message) {
        System.out.println("\033[32m" + message + "\033[0m");
    }

    private void printYellow(String message) {
        System.out.println("\033[33m" + message + "\033[0m");
    }
}




