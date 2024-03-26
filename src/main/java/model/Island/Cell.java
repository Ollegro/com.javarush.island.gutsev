package model.Island;

import lombok.Getter;
import model.animal.Animal;
import model.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Cell {
    private final List<Animal> animals;
    private final List<Plant> plants;

    public Cell() {
        animals = new CopyOnWriteArrayList<>();
        plants = new CopyOnWriteArrayList<>();
    }




}
