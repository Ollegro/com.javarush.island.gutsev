
import service.task.RunTask;

import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        RunTask.getService().submit(new RunTask());
        if(!RunTask.getService().awaitTermination(15, TimeUnit.MINUTES)) RunTask.getService().shutdownNow();












    }
}
