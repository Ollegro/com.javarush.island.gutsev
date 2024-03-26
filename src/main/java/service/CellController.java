package service;

import model.Island.Cell;
import service.task.EatTask;
import service.task.PlantsIncreaseTask;
import service.task.ReproductionTask;


public class CellController {
    private final EatTask eatTask = new EatTask();
    private final PlantsIncreaseTask grassGrowTask = new PlantsIncreaseTask();
    private final ReproductionTask reproductionTask = new ReproductionTask();
    public void animalEat(Cell cell) {
        eatTask.animalEat(cell);
    }
    public void grassGrow(Cell cell) {
        grassGrowTask.grassGrow(cell);
    }
    public  synchronized void animalReproduction(Cell cell) {
            reproductionTask.animalReproduction(cell);
    }


}
