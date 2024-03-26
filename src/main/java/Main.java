import service.task.RunTask;



public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunTask() {});
               t1.start();







    }
}
