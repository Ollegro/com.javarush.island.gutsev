package service.task;

import config.InhabitantConfig;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
public class ReproductionTask {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();
    public void animalReproduction(Cell cell) {
        for (Class<? extends Inhabitant> animalClass : inhabitantConfig.inhabitantClassList) {
            for (int i = 0; i < cell.getAnimals().size(); i++) {
                int countEqualsObjects = i;
                if (cell.getAnimals().stream().filter(s -> Objects.equals(cell.getAnimals().get(countEqualsObjects).getName(), s.getName())).count() <  0.98 * inhabitantConfig.maxNumberOnCellMap.get(cell.getAnimals().get(i).getClass())) {
                   // boolean isReproduction = ThreadLocalRandom.current().nextBoolean();
                    boolean isReproduction = Math.random() < 0.5;

                    if (animalClass.equals(cell.getAnimals().get(i).getClass()) && isReproduction) {
                        try {
                            cell.getAnimals().add((Animal) animalClass.getConstructor().newInstance());
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                                 NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
    }
}


