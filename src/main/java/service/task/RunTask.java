package service.task;

import config.IslandConfig;
import lombok.Getter;
import service.IslandController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class RunTask implements Runnable {
    @Getter
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(8);

    private final IslandController islandController = new IslandController();


    IslandConfig c = new IslandConfig();
    int time = c.timeOfPeriod;

    @Override
    public void run() {
        islandController.printInitialIsland();

        service.scheduleAtFixedRate(islandController::animalEat, 2, time, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(islandController::grassGrow, 3, time, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(islandController::animalMove, 4, time, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(islandController::animalReproduction, 5, time, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(islandController::totalStatistics, 8, time, TimeUnit.SECONDS);




    }

}
