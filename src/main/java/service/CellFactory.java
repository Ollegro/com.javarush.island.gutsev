package service;

import config.InhabitantConfig;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class CellFactory {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public Cell createCell() {
        Cell cell = new Cell();
        int number;
        int maxNumberOnCell = 0;
        for (Class<? extends Inhabitant> inhabitantClass : inhabitantConfig.inhabitantClassList) {
            Inhabitant inhabitant;
            try {
                inhabitant = inhabitantClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

                for (Map.Entry<Class<? extends Inhabitant>                       // Присвоение максимума животных на одной клетке при создании ячеек при инициализации острова. Перетаскиваем значения из одной мапы в другую
                        , Integer> maxNumberOnCellEntry : inhabitantConfig.maxNumberOnCellMap.entrySet()) {
                    if (inhabitantClass.equals(maxNumberOnCellEntry.getKey())) {
                        maxNumberOnCell = maxNumberOnCellEntry.getValue();
                        break;
                    }
                }

                number = (ThreadLocalRandom.current().nextInt(100) * maxNumberOnCell)/100;// задание количества животных на клетке при инициализации клетки острова

                //number = (int) (Math.random() * maxNumberOnCell);


            for (int i = 0; i <= number; i++) {
                try {
                    if (inhabitant instanceof Animal) {
                        cell.getAnimals().add((Animal) inhabitant.clone());
                    } else {
                        cell.getPlants().add((Plant) inhabitant.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cell;
    }
}