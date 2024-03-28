package service;

import config.IslandConstants;
import model.Island.Cell;
import model.Island.Island;
import model.animal.Animal;
import model.plant.Plant;
import service.task.MoveTask;
import view.View;

import java.util.Collection;
import java.util.List;

public class IslandController {
    int count = 0;
    private final View view = new View();
    private final MoveTask moveTask = new MoveTask();
    private final IslandFactory islandFactory = new IslandFactory();
    private static Island island;
    private final CellController cellController = new CellController();
    {
        island = islandFactory.getInitialIsland();
    }
    public synchronized void printInitialIsland() {
        view.printIsland(island, IslandConstants.START_NEW_ISLAND);
    }
    public synchronized void animalEat() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalEat);
        view.printIsland(island, IslandConstants.ANIMAL_EAT);
    }

    public synchronized void grassGrow() {

        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::grassGrow);
        view.printIsland(island, IslandConstants.GRASS_GROW);

    }
    public synchronized void animalMove() {

        island = moveTask.animalMove(island);
        view.printIsland(island, IslandConstants.ANIMAL_MOVE);
    }
    public synchronized void animalReproduction() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalReproduction);
        view.printIsland(island, IslandConstants.ANIMAL_REPRODUCTION);
    }
    public synchronized void totalStatistics() {

        Cell totalCell = new Cell();
        List<List<Cell>> llc = island.getIsland();
        for (List<Cell> iter : llc) {
            for (Cell c : iter) {
                for (Animal i : c.getAnimals()) {
                    totalCell.getAnimals().add(i);
                }
            }
            for (Cell c : iter) {
                for (Plant i : c.getPlants()) {
                    totalCell.getPlants().add(i);
                }
            }
        }
        try {            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n".repeat(1) + "********************************* CYCLE STATISTIC **********************************");
        System.out.print("Total on the Island  CYCLE " + ++count + "  ");
        view.print(totalCell);
        System.out.println("*********************************** END CYCLE *************************************" + "\n".repeat(3) );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}







