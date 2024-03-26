package service.task;

import service.IslandController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class RunTask implements Runnable {

    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(8);
    private final IslandController islandController = new IslandController();
    ReentrantLock lock = new ReentrantLock(true);
    @Override
    public synchronized void run() {

        islandController.printInitialIsland();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            service.scheduleAtFixedRate(islandController::animalEat, 2, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::grassGrow, 3, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::animalMove, 4, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::animalReproduction, 5, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::totalStatistics, 8, 15, TimeUnit.SECONDS);



    }

}
