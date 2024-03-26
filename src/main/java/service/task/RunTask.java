package service.task;
import service.IslandController;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class RunTask implements Runnable {

    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(0);
    private final IslandController islandController = new IslandController();

    @Override
    public void run() {

        islandController.printInitialIsland();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        synchronized (service) {
            service.scheduleAtFixedRate(islandController::animalEat, 2, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::grassGrow, 3, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::animalMove, 4, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::animalReproduction, 5, 15, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(islandController::totalStatistics, 8, 15, TimeUnit.SECONDS);
        }


    }

}
